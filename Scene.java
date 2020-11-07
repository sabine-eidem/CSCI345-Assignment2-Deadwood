public class Scene {

    private String name;
    private String description;
    private int number;
    private int budget;
    private boolean isActive;
    private boolean isAssigned;
    private List<Role> roles;

    public Scene (String newName, int budg, String img, List<Role> sceneRoles, int num, String desc) {
      name = newName;
      budget = budg;
      roles = sceneRoles;
      number = num;
      description = desc;
      isActive = true;
      isAssigned = false;
    }

    public int getBudget() {
      return budget;
    }

    public String getName() {
      return name;
    }

    public List<Role> getRoles() {
      return roles;
    }

    public boolean checkIfRolesTaken() {
      for(int i = 0; i < roles.size(); i++) {
        if(roles.get(i).isTaken()) {
          return true;
        }
      }
      return false;
    }

    public int getNum() {
      return number;
    }

    public boolean getActive() {
      return isActive;
    }

    public boolean getAssigned() {
      return isAssigned;
    }

    public String getDesc() {
      return description;
    }

    public void wrap() {
      isActive = false;
      return;
    }

    public void assign() {
      isAssigned = true;
      return;
    }
}
