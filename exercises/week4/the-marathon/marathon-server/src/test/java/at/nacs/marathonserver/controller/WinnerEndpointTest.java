package at.nacs.marathonserver.controller;

import at.nacs.marathonserver.persistence.Runner;
import at.nacs.marathonserver.persistence.RunnerRepository;
import at.nacs.marathonserver.util.TestRunners;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest({WinnerEndpoint.class, TestRunners.class})
class WinnerEndpointTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    RunnerRepository runnerRepository;

    @Autowired
    TestRunners testRunners;

    @Test
    void testWinner() throws Exception {
        Runner runner = testRunners.getOne();

        given(runnerRepository.findFastest())
                .willReturn(Optional.of(runner));

        mvc.perform(get("/winner"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(runner.getName()))
                .andExpect(jsonPath("$.time").value(runner.getTime().toString()));
    }

}