package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChainCensorDecoratorTest extends AbstractSocialChanneldDecoratorTest {
    @Test
    public void testChanin(){
        SocialChannel channel = new TestSpySocialChannel();
        SocialChannel messageCensorChannel = new WordCensor(channel);
        SocialChannel urlAppenderChannel = new URLAppender("http://google.com",messageCensorChannel);
        SocialChannel messaeTruncatorChannel = new MessageTruncator(40, urlAppenderChannel);

        messaeTruncatorChannel.deliverMessage("this message is long message ended with google link");
        TestSpySocialChannel spyChannel = (TestSpySocialChannel) channel;

        assertEquals("this # is long # ended wi... http://google.com", spyChannel.lastMessagePublished());
    }
}
