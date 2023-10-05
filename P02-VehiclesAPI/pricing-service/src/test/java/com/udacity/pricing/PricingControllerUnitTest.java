package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPriceWithValidId() throws Exception{
        mockMvc.perform(get(new URI("/services/price?vehicleId=19"))
                        .contentType(String.valueOf(StandardCharsets.UTF_8))
                        .accept(String.valueOf(StandardCharsets.UTF_8)))
                        .andExpect(status().isOk());
    }

    @Test
    public void getPriceWithInvalidId() throws Exception {
        mockMvc.perform(get(new URI("/services/price?vehicleId=20"))
                        .contentType(String.valueOf(StandardCharsets.UTF_8))
                        .accept(String.valueOf(StandardCharsets.UTF_8)))
                        .andExpect(status().isNotFound());
    }
}
