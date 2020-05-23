package User;
//TODO: Remove this
import java.util.Arrays;

public class MemberCollection {
    //TODO: Change how to adding Member to collection. Assumed that there is only max 10 members.
    private static Member[] memberCollection = {};

    // singleton class - lazy initalisation
    // https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
    private static MemberCollection instance = null;

    private MemberCollection() {};

    public static MemberCollection getInstance() {
        if (instance == null) {
            instance = new MemberCollection();
            memberCollection = new Member[1000];
        }
        return instance;
    }
    public void addMember(Member newMember) {
        memberCollection = Arrays.copyOf(memberCollection, memberCollection.length + 1);
        memberCollection[memberCollection.length - 1] = newMember;
    }

    public Member searchMember(String fullname) {
        for (int i = 0; i< memberCollection.length; i++){
            if(fullname.toLowerCase().equals(memberCollection[i].getFullName().toLowerCase())){
                return memberCollection[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "list=" + Arrays.toString(memberCollection) +
                '}';
    }
}
