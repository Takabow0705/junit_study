package ch6;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;
import java.util.*;
import java.util.function.Supplier;


public class ProfileTest{
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void create(){
        profile = new Profile("Bull Hockey,Inc.");
        question = new BooleanQuestion(1, "ボーナスは支給されますか？");
        criteria = new Criteria();
    }

    //必須の条件にマッチしない場合はFalseとなる。
    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet(){
        Answer profileanswer = new Answer(question,Bool.FALSE);
        profile.add(profileanswer);
        Answer criteriaAnswer = new Answer(question,Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer,Weight.MustMatch);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertFalse(matches);
    }

    //不問の条件があればmatchesはTrueを返す。
    @Test
    public void matchAnswerTrueForAnyDontCareCriteria(){
        Answer profileAnswer = new Answer(question,Bool.FALSE);
        profile.add(profileAnswer);
        Answer criteriaAnswer = new Answer(question,Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertTrue(matches);
    }

    int[] ids(Collection<Answer> answers){
        return answers.stream().mapToInt(a -> a.getQuestion().getId()).toArray();
    }
    @Test
    public void findsAnswerBasedOnPredicate(){
        profile.add(new Answer(new BooleanQuestion(1, "1"),Bool.TRUE));
        profile.add(new Answer(new PercentileQuestion(2, "2", new String[]{}),0));
        profile.add(new Answer(new PercentileQuestion(3, "3", new String[]{}),0));
        profile.add(new Answer(new PercentileQuestion(4, "4", new String[]{}),0));

        List<Answer> answers = profile.find(a -> a.getQuestion().getClass() == PercentileQuestion.class);

        assertThat(ids(answers),equalTo(new int[]{2,3,4}));

        //crosscheck
        List<Answer> answers2 = profile.find(a -> a.getQuestion().getClass() != PercentileQuestion.class);

        assertThat(ids(answers2),equalTo(new int[]{1}));
    }

    private long run(int times,Runnable func){
        long start = System.nanoTime();
        for(int i = 0; i < times; i++){
            func.run();
        }
        long stop = System.nanoTime();
        return (stop - start) / 1000000;
    }
    @Test
    public void findAnswers(){
        int datasize = 5000;
        for(int i = 0; i < datasize; i++){
            profile.add(new Answer(
                new BooleanQuestion(i, String.valueOf(i)),Bool.FALSE
            ));
        }

        profile.add(new Answer(new PercentileQuestion(
            datasize,String.valueOf(datasize),new String[] {}
        ), 0));

        int numberOfTimes = 1000;
        long elapseMs = run(numberOfTimes,
                            () -> profile.find(a -> a.getQuestion().getClass() == PercentileQuestion.class));
    }
}