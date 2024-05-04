package dev.kevalkanpariya.educo

import com.google.firebase.firestore.FirebaseFirestore
import dev.kevalkanpariya.educo.feature_course.data.repoImpl.CourseRepoImpl
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */



class ExampleUnitTest  {


    @Mock
    lateinit var mockFirestore: FirebaseFirestore



    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
//        Dispatchers.setMain(mainThreadSurrogate)
    }

//    @After
//    fun tearDown() {
//        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
//        mainThreadSurrogate.close()
//    }



    @Test
    fun testExampleBackgroundJob() = runTest {

        //val db = mock(FirebaseFirestore::class.java)
        val repo = CourseRepoImpl(mockFirestore)


        val courses = repo.fetchCourses("Demo Course 1")

        val data = courses.data
        assert(data?.isEmpty() == false)

    }
}

