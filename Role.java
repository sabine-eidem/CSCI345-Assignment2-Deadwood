import java.util.HashMap;

public class Role {

    private String name;
    private String line;
    private int reqRank;
    private boolean taken;
    private boolean onScene;

    private HashMap<String, Integer> areaHashMap;

    public Role(String newName, int rank, String newLine, HashMap<String, Integer> AreaHashMap) {
        name = newName;
        reqRank = rank;
        line = newLine;
        taken = false;
        areaHashMap = AreaHashMap;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return reqRank;
    }

    public String getLine() {
        return line;
    }

    public boolean isTaken() {
        return taken;
    }

    public boolean isOnScene() {
        return onScene;
    }

    public void take() {
        taken = true;
        return;
    }

    public void leave() {
        taken = false;
        return;
    }

    public HashMap<String, Integer> getAreaHashMap(){
        return areaHashMap;
    }

    public void printRoleInfo() {
        System.out.println("Role:");
        System.out.println("\t  Name: " + name);
        System.out.println("\t  Line: " + line);
        System.out.println("\t  Rank: " + reqRank);
        System.out.println();

    }

}
