/**
 * This Main program was written to sanity check the correctness of the Report and Project
 * classes. It creates three projects, p1, p2, and p3, and two reports, r1 and r2.
 * Projects p1 and p2 are added to report r1, and projects p2 and p3 are added to report r2.
 * The program then goes on to update the status of the projects in the following order:
 * 1) Set p1 to inProgress
 * 2) Set p3 to inProgress
 * 3) Set p1 to complete
 * 4) Set p2 to inProgress
 * 
 */
class Main {

  public static void printReportStats(Report report) {
    System.out.println(
      "In Progress: " +
      report.getTotalInProgress() +
      " Done: " +
      report.getTotalDone()
    );
  }

  public static void main(String args[]) {
    System.out.println("Main Program");

    System.out.println("Creating Projects");
    Project p1 = new Project();
    Project p2 = new Project();
    Project p3 = new Project();

    System.out.println("Creating Reports");
    Report r1 = new Report();
    Report r2 = new Report();

    System.out.println("Adding Projects to Reports");
    r1.addProject(p1);
    r1.addProject(p2);

    r2.addProject(p2);
    r2.addProject(p3);

    System.out.println("Getting Initial Stats");
    System.out.println("R1");
    printReportStats(r1);
    System.out.println("R2");
    printReportStats(r2);

    System.out.println("Starting Project 1");
    p1.setStatus(ProgressStatus.inProgress);

    System.out.println("Starting Project 3");
    p3.setStatus(ProgressStatus.inProgress);

    System.out.println("Getting Stats");
    System.out.println("R1");
    printReportStats(r1);
    System.out.println("R2");
    printReportStats(r2);

    System.out.println("Complete Project 1");
    p1.setStatus(ProgressStatus.done);

    System.out.println("Starting Project 2");
    p2.setStatus(ProgressStatus.inProgress);

    System.out.println("Getting Stats");
    System.out.println("R1");
    printReportStats(r1);
    System.out.println("R2");
    printReportStats(r2);
  }
}
