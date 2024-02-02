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

        Task taskForCarol = new Task("S15G2", "Set Challenge Carol", "bob", Priority.LOW, Status.IN_QUEUE);
        Task taskForCarol2 = new Task("S15G2", "Set Challenge Carol2", "bob", Priority.HIGH, Status.IN_PROGRESS);

        Set<Task> annsTasks = new LinkedHashSet<>();
        annsTasks.add(taskForAnn);
        annsTasks.add(taskForAnn2);

        Set<Task> bobsTasks = new LinkedHashSet<>();
        bobsTasks.add(taskForBob);
        bobsTasks.add(taskForBob2);

        Set<Task> carolsTasks = new LinkedHashSet<>();
        carolsTasks.add(taskForCarol);
        carolsTasks.add(taskForCarol2);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, null);

        SetUtils.printSet(taskData.getTasks("all"));  //Daha okunaklı bir console cıktısı elde ettik
        //System.out.println(taskData.getTasks("all").toString());
    }

    public static void printTasks(Set<Task> all) {


    }
}