package com.example.christhai.fulcrum;

/**
 * Created by Arvind on 10/20/2017.
 */

/*package com.google.firebase.quickstart.model;

        import com.google.firebase.database.IgnoreExtraProperties;

        import java.util.HashMap;
        import java.util.Map;*/
import java.util.Map;
import java.util.HashMap;
/**
 * POJO class representing a Post stored in the Firebase Database.
 */
// [START post_class]
//@IgnoreExtraProperties
public class Post {

    public String uid;
    public String author;
    public String title;
    public String body;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<String, Boolean>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String title, String body) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
    }
}
// [END post_class]