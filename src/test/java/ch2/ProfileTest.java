package ch2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

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
}