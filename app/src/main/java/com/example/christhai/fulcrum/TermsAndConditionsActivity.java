package com.example.christhai.fulcrum;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TermsAndConditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
    }
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_terms_and_conditions);


        TextView termsAndConditionsText = (TextView) findViewById(R.id.terms_and_cond_html);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            termsAndConditionsText.setText(Html.fromHtml("<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>0. Introduction</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>These Application Standard Terms and Conditions written on\n" +
                            "this application shall manage your use of this website. These Terms will be\n" +
                            "applied fully and affect to your use of this native mobile application. By\n" +
                            "using this application, you agreed to accept all terms and conditions written\n" +
                            "in here. You must not use this application if you disagree with any of these\n" +
                            "Application Standard Terms and Conditions.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Minors or people below 18 years old are not allowed to use\n" +
                            "this Application.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>1. Intellectual Property Rights</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Other than the content you own, under these Terms,\n" +
                            "Fulcrum: College Student Wellness Application and/or its licensors own all the\n" +
                            "intellectual property rights and materials contained in this Application.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>You are granted limited license only for purposes of\n" +
                            "viewing the material contained on this Application.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>2. Restrictions</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>You are specifically restricted from all of the following</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>publishing any Application material in any other media;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>selling, sublicensing and/or otherwise commercializing any\n" +
                            "Application material;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>publicly performing and/or showing any Application material;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>using this Application in any way that is or may be damaging to\n" +
                            "this Application;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>using this Application in any way that impacts user access to this\n" +
                            "Application;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>using this Application contrary to applicable laws and\n" +
                            "regulations, or in any way may cause harm to the Application, or to any person\n" +
                            "or business entity;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>engaging in any data mining, data harvesting, data extracting or\n" +
                            "any other similar activity in relation to this Application;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>using this Application to engage in any advertising or marketing.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Certain areas of this Application are restricted from\n" +
                            "being access by you and Fulcrum: College Student Wellness Application may\n" +
                            "further restrict access by you to any areas of this Application, at any time,\n" +
                            "in absolute discretion. Any user ID and password you may have for this\n" +
                            "Application are confidential and you must maintain confidentiality as well.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>3. Your Content</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>In these Application Standard Terms and Conditions, “Your\n" +
                            "Content” shall mean any audio, video text, images or other material you choose\n" +
                            "to display on this Application. By displaying Your Content, you grant Fulcrum:\n" +
                            "College Student Wellness Application a non-exclusive, worldwide irrevocable, sub\n" +
                            "licensable license to use, reproduce, adapt, publish, translate and distribute\n" +
                            "it in any and all media.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Your Content must be your own and must not be invading any\n" +
                            "third-party’s rights. Fulcrum: College Student Wellness Application reserves\n" +
                            "the right to remove any of Your Content from this Application at any time\n" +
                            "without notice.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>4. No warranties</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>This Application is provided “as is,” with all faults, and\n" +
                            "Fulcrum: College Student Wellness Application express no representations or\n" +
                            "warranties, of any kind related to this Application or the materials contained\n" +
                            "on this Application. Also, nothing contained on this Application shall be\n" +
                            "interpreted as advising you.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>5. Limitation of liability</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>In no event shall Fulcrum: College Student Wellness\n" +
                            "Application, nor any of its officers, directors and employees, shall be held\n" +
                            "liable for anything arising out of or in any way connected with your use of\n" +
                            "this Application whether such liability is under contract. &nbsp;Fulcrum:\n" +
                            "College Student Wellness Application, including its officers, directors and\n" +
                            "employees shall not be held liable for any indirect, consequential or special\n" +
                            "liability arising out of or in any way related to your use of this Application.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>6. Indemnification</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>You hereby indemnify to the fullest extent Fulcrum: College\n" +
                            "Student Wellness Application from and against any and/or all liabilities,\n" +
                            "costs, demands, causes of action, damages and expenses arising in any way\n" +
                            "related to your breach of any of the provisions of these Terms.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>7. Severability</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>If any provision of these Terms is found to be invalid\n" +
                            "under any applicable law, such provisions shall be deleted without affecting\n" +
                            "the remaining provisions herein.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>8. Variation of Terms</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Fulcrum: College Student Wellness Application is permitted\n" +
                            "to revise these Terms at any time as it sees fit, and by using this Application\n" +
                            "you are expected to review these Terms on a regular basis.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>9. Assignment</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>The Fulcrum: College Student Wellness Application is\n" +
                            "allowed to assign, transfer, and subcontract its rights and/or obligations\n" +
                            "under these Terms without any notification. However, you are not allowed to\n" +
                            "assign, transfer, or subcontract any of your rights and/or obligations under\n" +
                            "these Terms.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>10. Entire Agreement</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>These Terms constitute the entire agreement between\n" +
                            "Fulcrum: College Student Wellness Application and you in relation to your use\n" +
                            "of this Application, and supersede all prior agreements and understandings.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>11. Governing Law &amp; Jurisdiction</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>These Terms will be governed by and interpreted in\n" +
                            "accordance with the laws of the State of Georgia, and you submit to the\n" +
                            "non-exclusive jurisdiction of the state and federal courts located in Georgia\n" +
                            "for the resolution of any disputes.</p>\n"
                    , Html.FROM_HTML_MODE_COMPACT));
        } else {
            termsAndConditionsText.setText(Html.fromHtml("<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>0. Introduction</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>These Application Standard Terms and Conditions written on\n" +
                            "this application shall manage your use of this website. These Terms will be\n" +
                            "applied fully and affect to your use of this native mobile application. By\n" +
                            "using this application, you agreed to accept all terms and conditions written\n" +
                            "in here. You must not use this application if you disagree with any of these\n" +
                            "Application Standard Terms and Conditions.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Minors or people below 18 years old are not allowed to use\n" +
                            "this Application.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>1. Intellectual Property Rights</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Other than the content you own, under these Terms,\n" +
                            "Fulcrum: College Student Wellness Application and/or its licensors own all the\n" +
                            "intellectual property rights and materials contained in this Application.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>You are granted limited license only for purposes of\n" +
                            "viewing the material contained on this Application.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>2. Restrictions</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>You are specifically restricted from all of the following</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>publishing any Application material in any other media;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>selling, sublicensing and/or otherwise commercializing any\n" +
                            "Application material;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>publicly performing and/or showing any Application material;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>using this Application in any way that is or may be damaging to\n" +
                            "this Application;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>using this Application in any way that impacts user access to this\n" +
                            "Application;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>using this Application contrary to applicable laws and\n" +
                            "regulations, or in any way may cause harm to the Application, or to any person\n" +
                            "or business entity;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-top:0in;margin-right:0in;margin-bottom:0in;\n" +
                            "margin-left:35.35pt;margin-bottom:.0001pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>engaging in any data mining, data harvesting, data extracting or\n" +
                            "any other similar activity in relation to this Application;</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt;text-indent:-14.15pt'><span\n" +
                            "style='font-family:Symbol'>·<span style='font:7.0pt \"Times New Roman\"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                            "</span></span>using this Application to engage in any advertising or marketing.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Certain areas of this Application are restricted from\n" +
                            "being access by you and Fulcrum: College Student Wellness Application may\n" +
                            "further restrict access by you to any areas of this Application, at any time,\n" +
                            "in absolute discretion. Any user ID and password you may have for this\n" +
                            "Application are confidential and you must maintain confidentiality as well.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>3. Your Content</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>In these Application Standard Terms and Conditions, “Your\n" +
                            "Content” shall mean any audio, video text, images or other material you choose\n" +
                            "to display on this Application. By displaying Your Content, you grant Fulcrum:\n" +
                            "College Student Wellness Application a non-exclusive, worldwide irrevocable, sub\n" +
                            "licensable license to use, reproduce, adapt, publish, translate and distribute\n" +
                            "it in any and all media.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Your Content must be your own and must not be invading any\n" +
                            "third-party’s rights. Fulcrum: College Student Wellness Application reserves\n" +
                            "the right to remove any of Your Content from this Application at any time\n" +
                            "without notice.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>4. No warranties</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>This Application is provided “as is,” with all faults, and\n" +
                            "Fulcrum: College Student Wellness Application express no representations or\n" +
                            "warranties, of any kind related to this Application or the materials contained\n" +
                            "on this Application. Also, nothing contained on this Application shall be\n" +
                            "interpreted as advising you.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>5. Limitation of liability</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>In no event shall Fulcrum: College Student Wellness\n" +
                            "Application, nor any of its officers, directors and employees, shall be held\n" +
                            "liable for anything arising out of or in any way connected with your use of\n" +
                            "this Application whether such liability is under contract. &nbsp;Fulcrum:\n" +
                            "College Student Wellness Application, including its officers, directors and\n" +
                            "employees shall not be held liable for any indirect, consequential or special\n" +
                            "liability arising out of or in any way related to your use of this Application.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>6. Indemnification</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>You hereby indemnify to the fullest extent Fulcrum: College\n" +
                            "Student Wellness Application from and against any and/or all liabilities,\n" +
                            "costs, demands, causes of action, damages and expenses arising in any way\n" +
                            "related to your breach of any of the provisions of these Terms.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>7. Severability</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>If any provision of these Terms is found to be invalid\n" +
                            "under any applicable law, such provisions shall be deleted without affecting\n" +
                            "the remaining provisions herein.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>8. Variation of Terms</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>Fulcrum: College Student Wellness Application is permitted\n" +
                            "to revise these Terms at any time as it sees fit, and by using this Application\n" +
                            "you are expected to review these Terms on a regular basis.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>9. Assignment</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>The Fulcrum: College Student Wellness Application is\n" +
                            "allowed to assign, transfer, and subcontract its rights and/or obligations\n" +
                            "under these Terms without any notification. However, you are not allowed to\n" +
                            "assign, transfer, or subcontract any of your rights and/or obligations under\n" +
                            "these Terms.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>10. Entire Agreement</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>These Terms constitute the entire agreement between\n" +
                            "Fulcrum: College Student Wellness Application and you in relation to your use\n" +
                            "of this Application, and supersede all prior agreements and understandings.</p>\n" +
                            "\n" +
                            "<p class=MsoBodyText style='margin-left:35.35pt'><strong><span\n" +
                            "style='font-family:\"Arial\",sans-serif'>11. Governing Law &amp; Jurisdiction</span></strong></p>\n" +
                            "\n" +
                            "<p class=MsoBodyText>These Terms will be governed by and interpreted in\n" +
                            "accordance with the laws of the State of Georgia, and you submit to the\n" +
                            "non-exclusive jurisdiction of the state and federal courts located in Georgia\n" +
                            "for the resolution of any disputes.</p>\n"));
        }
    }
}
