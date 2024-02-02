import com.workintech.enums.Priority;
import com.workintech.enums.Status;
import com.workintech.models.Task;
import com.workintech.models.TaskData;
import com.workintech.util.SetUtils;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.workintech.util.SetUtils.printSet;

public class Main {
    public static void main(String[] args) {

        Task taskForBob = new Task("S15G2", "Set Challenge Bob", "bob", Priority.HIGH, Status.ASSIGNED);
        Task taskForBob2 = new Task("S15G2", "Set Challenge Bob2", "bob", Priority.MEDIUM, Status.IN_PROGRESS);

        Task taskForAnn = new Task("S15G2", "Set Challenge Ann", "ann", Priority.MEDIUM, Status.IN_PROGRESS);
        Task taskForAnn2 = new Task("S15G2", "Set Challenge Ann2", "ann", Priority.LOW, Status.IN_QUEUE);

        Task taskForCarol = new Task("S15G2", "Set Challenge Carol", "carol", Priority.LOW, Status.IN_QUEUE);
        Task taskForCarol2 = new Task("S15G2", "Set Challenge Carol2", "carol", Priority.HIGH, Status.IN_PROGRESS);

        Task taskForUnassigned = new Task("S15G2", "Set Challenge Unassigned", null, Priority.LOW, Status.IN_QUEUE);
        Task taskForUnassigned2 = new Task("S15G2", "Set Challenge Unassigned2", null, Priority.HIGH, Status.IN_PROGRESS);

        Set<Task> unassignedTasks = new LinkedHashSet<>();
        unassignedTasks.add(taskForUnassigned);
        unassignedTasks.add(taskForUnassigned2);

        Set<Task> annsTasks = new LinkedHashSet<>();
        annsTasks.add(taskForAnn);
        annsTasks.add(taskForAnn2);

        Set<Task> bobsTasks = new LinkedHashSet<>();
        bobsTasks.add(taskForBob);
        bobsTasks.add(taskForBob2);
        bobsTasks.add(taskForAnn);

        Set<Task> carolsTasks = new LinkedHashSet<>();
        carolsTasks.add(taskForCarol);
        carolsTasks.add(taskForCarol2);

        Set<Task> allTasks = new LinkedHashSet<>();
        allTasks.addAll(bobsTasks);
        allTasks.addAll(carolsTasks);
        allTasks.addAll(annsTasks);
        allTasks.addAll(unassignedTasks);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        //Tüm çalışanlarının üzerindeki tasklar nelerdir?

        System.out.println("******** 1 ***********");

        SetUtils.printSet(taskData.getTasks("all"));  //Daha okunaklı bir console cıktısı elde ettik
        //System.out.println(taskData.getTasks("all").toString());


        //Her bir çalışanın üzerindeki tasklar nelerdir ?

        System.out.println("******* 2 ********");

        SetUtils.printSet(taskData.getTasks("ann"));
        SetUtils.printSet(taskData.getTasks("bob"));
        SetUtils.printSet(taskData.getTasks("carol"));

        //Herhangi bir çalışana atanması yapılmamış olan tasklar nelerdir ?

        System.out.println("******* 3 *********");

        SetUtils.printSet(taskData.getDifferences(allTasks, taskData.getTasks("all")));

        //Birden fazla çalışana atanmış task var mı ? Varsa bunlar hangileri ?

        System.out.println("******* 4 *********");

        SetUtils.printSet(taskData.getIntersection(bobsTasks, annsTasks));




    }
}