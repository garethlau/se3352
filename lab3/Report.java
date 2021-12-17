import java.util.ArrayList;

public class Report extends Observer {

  ArrayList<Project> projects; // Keep an array of all projects that this report reports on
  int totalDone;
  int totalInProgress;

  public Report() {
    // Initialize the array of projects as an empty array list
    this.projects = new ArrayList<Project>();
  }

  public void update() {
    // Reset the totals
    this.totalDone = 0;
    this.totalInProgress = 0;

    // Iterate through each project
    this.projects.forEach(
        project -> {
          // For each project, get the status
          ProgressStatus status = project.getStatus();
          if (status == ProgressStatus.inProgress) {
            // If the project is in progress, increment the inProgress count
            this.totalInProgress++;
          } else if (status == ProgressStatus.done) {
            // If the project is completed (done), increment the done count
            this.totalDone++;
          }
        }
      );
  }

  public void addProject(Project p) {
    // Keep track of the project by adding it to the array list
    this.projects.add(p);
    // Attach this report as a subscriber of changes by calling the attach() method
    // of the project
    p.attach(this);
  }

  public int getTotalDone() {
    return this.totalDone;
  }

  public int getTotalInProgress() {
    return this.totalInProgress;
  }
  // other stats

}
