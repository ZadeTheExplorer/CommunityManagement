package User;

public class MemberCollection {
    //Assumed that there is only max 10 members.
    private static Member[] memberCollection;
    private static int totalMem;

    // singleton class - lazy initalisation
    // https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
    private static MemberCollection instance = null;

    private MemberCollection() {};

    public static MemberCollection getInstance() {
        if (instance == null) {
            instance = new MemberCollection();
            memberCollection = new Member[10];
            totalMem = 0;
        }
        return instance;
    }

    public void addMember(Member newMember) {

        memberCollection[totalMem] = newMember;
        totalMem++;
    }

    public Member searchMember(String username) {
        for (Member member : memberCollection) {
            if (member == null) {
                return null;
            }
            if (username.toLowerCase().compareTo(member.getUsername().toLowerCase()) == 0) {
                return member;
            }
        }
        return null;
    }
}
