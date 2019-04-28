package ch2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

public class ProfileTest{

    //必須の条件にマッチしない場合はFalseとなる。
    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet(){
        Profile profile = new Profile("Bull Hockey, Inc.");
        Question question = new BooleanQuestion(1, "ボーナスは支給されますか？");
        Answer profileanswer = new Answer(question,Bool.FALSE);
        profile.add(profileanswer);
        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question,Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer,Weight.MustMatch);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertFalse(matches);
    }

    @Test
    public void matchAnswerTrueForAnyDontCareCriteria(){
        Profile profile = new Profile("Bull Hockey,Inc.");
        Question question = new BooleanQuestion(1, "牛乳は支給されますか");
        Answer profileAnswer = new Answer(question,Bool.TRUE);
        profile.add(profileAnswer);
        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question,Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertTrue(matches);
    }
}