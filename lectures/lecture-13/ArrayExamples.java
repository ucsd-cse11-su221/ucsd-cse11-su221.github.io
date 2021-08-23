import tester.*;

class TextTweet {
  String user;
  String contents;
  TextTweet(String user, String contents) {
    this.user = user;
    this.contents = contents;
  }
  boolean hasHashtag(String hashtag) {
    return this.contents.contains("#" + hashtag + " ");
  }
}

class ArrayExamples {
  TextTweet t1 = new TextTweet("gregmiranda", "#welcome to CSE11, incoming students!");
  TextTweet t2 = new TextTweet("jacobsschool", "#welcome to #engineering at #ucsd ");
  TextTweet t3 = new TextTweet("ucsd", "#welcome to UCSD!");
  TextTweet t4 = new TextTweet("warrencollegeucsd", "You're going to love #ucsd new students!");

  TextTweet[] tweets = { t1, t2, t3, t4 };
  TextTweet[] tweets2 = { t1, t2, t3 };


  // How would we access the contents of the third tweet in the tweest array
  // (without writing t3 in our code)
  String contentsOfT3 = tweets[2].contents;

  // What wouuld we write to get the string "jacobsschool" below using just array
  // lookup and field lookup:
  String userOfT2 = tweets[1].user;

  // What would we write to get the length of the contents of the t4 tweet:
  int lengthOfT4Tweet = tweets[3].contents.length();


  int countTweetsWithHashtag(TextTweet[] tweets, String hashtag) {
    int total = 0;

    for (TextTweet t: tweets) {
      if (t.hasHashtag(hashtag)) {
        total += 1;
      }
    }

    return total;
  }

  void testCountWithHashtabg(Tester t) {
    t.checkExpect(this.countTweetsWithHashtag(tweets, "welcome"), 3);
    t.checkExpect(this.countTweetsWithHashtag(tweets, "ucsd"), 2);
    t.checkExpect(this.countTweetsWithHashtag(tweets, "banana"), 0);

    t.checkExpect(this.countTweetsWithHashtag(tweets2, "welcome"), 3);
    t.checkExpect(this.countTweetsWithHashtag(tweets2, "ucsd"), 1);
    t.checkExpect(this.countTweetsWithHashtag(tweets2, "banana"), 0);
  }

  double averageLengthOfTweetsWithHashtag(TextTweet[] tweets, String hashtag) {
    int total = 0;
    int count = 0;

    for (TextTweet t: tweets) {
      if (t.hasHashtag(hashtag)) {
        total += t.contents.length();
        count += 1;   //count++;
      }
    }

    if (count == 0) {
      return 0.0;
      //return -1.0;    //return an error condition?
    }

    //return (double) total / tweets.length;    //incorrect
    
    return (double) total / count;              //type cast integer to double
    //return (total * 1.0) / count;             //same as above
  }

  double length1 = this.averageLengthOfTweetsWithHashtag(tweets, "ucsd");
  double length1Expected = (t2.contents.length() + t4.contents.length()) / 2.0;
  double length2 = this.averageLengthOfTweetsWithHashtag(tweets, "welcome");
  double length2Expected = (t1.contents.length() + t2.contents.length() + t3.contents.length()) / 3.0;
  double length3 = this.averageLengthOfTweetsWithHashtag(tweets, "banana");


}
