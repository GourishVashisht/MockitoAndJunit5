package com.nagarro.employeemanaement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.internal.verification.VerificationModeFactory;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmailService.class) // can aslo take array
public class EmailHandlerTest {

    @InjectMocks // koi dependency nahi hai tabh bhi use karlo
    EmailHandler handler;

    @Test
    public void shouldSendNewEmails() {
        PowerMockito.mockStatic(EmailService.class);
        handler.sendEmail();
        // verify static aur ali line mein koi aur line nahi honi chahiye
        // jisko verify karna hai wahi next line honi chahiye
        PowerMockito.verifyStatic(VerificationModeFactory.times(1));
        EmailService.sendMail();
    }
}
