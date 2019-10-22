package seedu.address.storage;

/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
=======

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static seedu.address.testutil.Assert.assertThrows;
>>>>>>> origin/master

import java.nio.file.Path;
import java.nio.file.Paths;

//import org.junit.jupiter.api.Test;

<<<<<<< HEAD
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.Classroom;
import seedu.address.testutil.TypicalStudents;
=======
//import seedu.address.commons.exceptions.IllegalValueException;
//import seedu.address.commons.util.JsonUtil;
//import seedu.address.model.Classroom;
//import seedu.address.testutil.TypicalStudents;
>>>>>>> origin/master

public class JsonSerializableClassroomTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableClassroomTest");
    private static final Path TYPICAL_STUDENTS_FILE = TEST_DATA_FOLDER.resolve("typicalStudentsClassroom.json");
    private static final Path INVALID_STUDENT_FILE = TEST_DATA_FOLDER.resolve("invalidStudentClassroom.json");
    private static final Path DUPLICATE_STUDENT_FILE = TEST_DATA_FOLDER.resolve("duplicateStudentClassroom.json");

    @Test
    public void toModelType_typicalStudentsFile_success() throws Exception {
        JsonSerializableClassroom dataFromFile = JsonUtil.readJsonFile(TYPICAL_STUDENTS_FILE,
                JsonSerializableClassroom.class).get();
        Classroom classroomFromFile = dataFromFile.toModelType();
        Classroom typicalStudentsClassroom = TypicalStudents.getTypicalClassroom();
        assertEquals(classroomFromFile, typicalStudentsClassroom);
    }

    */
    /*
    @Test
    public void toModelType_invalidStudentFile_throwsIllegalValueException() throws Exception {
        JsonSerializableClassroom dataFromFile = JsonUtil.readJsonFile(INVALID_STUDENT_FILE,
                JsonSerializableClassroom.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

     */
    /*

    @Test
    public void toModelType_duplicateStudents_throwsIllegalValueException() throws Exception {
        JsonSerializableClassroom dataFromFile = JsonUtil.readJsonFile(DUPLICATE_STUDENT_FILE,
                JsonSerializableClassroom.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableClassroom.MESSAGE_DUPLICATE_STUDENT,
                dataFromFile::toModelType);
    }

}*/
