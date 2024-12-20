package com.scholarsync.emailService;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.io.IOException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service 
public class EmailServiceClass {
    
    private final JavaMailSender sender;
    
    public EmailServiceClass(JavaMailSender sender) {
        this.sender = sender;
    }
    
    public void studentMail(String firstName, String to, String courseType) throws MessagingException, IOException {
        if (to == null || firstName == null) {
            throw new IllegalArgumentException("Email and name cannot be null");
        }

        String subject = "Thanks For!!! Contacting Testing Shastra.";
        MimeMessage mime = sender.createMimeMessage();
        MimeMessageHelper mimeHelper = new MimeMessageHelper(mime, true);
        
        try {
            mimeHelper.setTo(to);
            mimeHelper.setSubject(subject);

            String body = "<html><body>"
                    + "Hi " + firstName + ","
                    + "<br><br>Thank you for reaching out to Testing Shastra!"
                    + "<br><br>We are thrilled that you've shown interest in our programs."
                    + (courseType != null ? "<br>Your selected course is: <b>" + courseType + "</b>." : "")
                    + "<br><br>At Testing Shastra, we are committed to providing top-notch training and support..."
                    + "<br><br>Follow us on:   "
                    + "<a href=\"https://www.instagram.com/testingshastra/\" target=\"_blank\">"
                    + "<img src='cid:instaImage' style='width:18px; height:18px;' />"
                    + "</a> |  "
                    + "<a href=\"https://www.linkedin.com/company/testing-shasrta/\" target=\"_blank\">"
                    + "<img src='cid:linkedinImage' style='width:18px; height:16px;' />"
                    + "</a> |  "
                    + "<a href=\"https://www.youtube.com/@testingshastra/\" target=\"_blank\">"
                    + "<img src='cid:youtubeImage' style='width:18px; height:16px;' />"
                    + "</a>"
                    + "<br><br>We look forward to helping you achieve your goals!"
                    + "<br><br>Contact details:"
                    + "<br>+91-9130502135 | +91-8484831616 | +91-8484831600" 
                    + "<br>Mail: info@testingshastra.com"
                    + "<br><br>Best regards,<br>Testing Shastra ;) "
                    + "<br><br><img src='cid:adminLogo' style='width:110px; height:110px;' />"
                    + "<br><br><small>*** Please note that this is an automatically generated email and cannot receive replies ***</small>"
                    + "</body></html>";

            mimeHelper.setText(body, true);

            // Add inline images
            mimeHelper.addInline("adminLogo", new ClassPathResource("static/Admin-img/logo.png"));
            mimeHelper.addInline("instaImage", new ClassPathResource("static/social-media-imgs/insta-png.webp"));
            mimeHelper.addInline("linkedinImage", new ClassPathResource("static/social-media-imgs/linkedln-png.webp"));
            mimeHelper.addInline("youtubeImage", new ClassPathResource("static/social-media-imgs/youtube-png.webp"));

            // Add course-specific PDF if courseType is provided
            if (courseType != null) {
                switch (courseType) {
                    case "Java fullStack development":
                        mimeHelper.addAttachment("FullStack_plus_React.pdf", 
                            new ClassPathResource("static/course_pdf/FullStack_+_React.pdf"));
                        break;
                    case "Automation Testing":
                        mimeHelper.addAttachment("Java-Selenium_Syllabus.pdf", 
                            new ClassPathResource("static/course_pdf/Java-Selenium_Syllabus_.pdf"));
                        break;
                    case "UI/UX":
                        mimeHelper.addAttachment("UI/UX_syllabus.pdf", 
                            new ClassPathResource("static/course_pdf/Diploma-in-Fullstack-Development_UI_UX.pdf"));
                        break;
                    case "MERN Stack":
                        mimeHelper.addAttachment("MERN_Stack_syllabus.pdf", 
                            new ClassPathResource("static/course_pdf/Advance_JS_&_React syllabus.pdf"));
                        break;
                    default:
                        mimeHelper.addAttachment("REST_Api_syllabus.pdf", 
                            new ClassPathResource("static/course_pdf/Rest_Api_Testing_syllabus.pdf"));
                }
            }
            log.info("sending mail");
            sender.send(mime);
            log.info("successfully sended!!1");
        }
        catch (MessagingException e) {
            throw new MessagingException("Failed to send email: " + e.getMessage());
        }
        catch (IOException e) {
            throw new IOException("Failed to attach files: " + e.getMessage());
        }
    }
}
