public class Project extends Subject {

  // Array list to keep track of all observers observing
  // this project
  private String projectID;
  private String projectDesc;
  private ProgressStatus status;

  String getProjectID() {
    return projectID;
  }

  void setTaskID(String taskID) {
    this.projectID = taskID;
  }

  String getTaskDesc() {
    return projectDesc;
  }

  void setTaskDesc(String taskDesc) {
    this.projectDesc = taskDesc;
  }

  ProgressStatus getStatus() {
    return this.status;
  }

  void setStatus(ProgressStatus status) {
    // Update this project's status
    this.status = status;

    // Call the notify function which notifies all observers observing
    // this project that changes have occured
    this.not();
  }
}
