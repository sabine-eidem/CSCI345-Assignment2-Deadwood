public class Room {
    private String name;
    private int shotCounter;
    private int currentShots;
    private Scene currentScene;
    private List<String> neighbors;
    private List<Role> offCardRoles;
    private boolean visited;

    public Room(String newName, int shots, List<String> neighborNames, List<Role> roles) {
        name = newName;
        shotCounter = shots;
        neighbors = neighborNames;
        offCardRoles = roles;
    }
}