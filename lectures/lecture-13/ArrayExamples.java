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

}