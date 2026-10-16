package com.otterclothes.api;

import com.otterclothes.api.models.Color;
import com.otterclothes.api.models.Product;
import com.otterclothes.api.models.Size;
import com.otterclothes.api.repository.ColorRepository;
import com.otterclothes.api.repository.ProductRepository;
import com.otterclothes.api.repository.SizeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SizeRepository sizeRepository;

	@Autowired
	private ColorRepository colorRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createsUserFromSnakeCaseJson() throws Exception {
		String email = "bruno-" + UUID.randomUUID() + "@example.com";
		String requestBody = """
				{
				  "user_id": 99,
				  "user_full_name": "Brian Enrique Pineda Martinez",
				  "user_email": "%s",
				  "user_phone": "5512345678",
				  "user_password": "test-password"
				}
				""".formatted(email);

		mockMvc.perform(post("/api/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.user_id").value(not(99)))
				.andExpect(jsonPath("$.user_full_name").value("Brian Enrique Pineda Martinez"))
				.andExpect(jsonPath("$.user_email").value(email))
				.andExpect(jsonPath("$.user_password").doesNotExist());
	}

	@Test
	void createsProductFromSnakeCaseJson() throws Exception {
		String requestBody = """
				{
				  "product_name": "Test product",
				  "description": "API test product",
				  "price": 199.50,
				  "model": "TEST-001",
				  "style": "casual"
				}
				""";

		mockMvc.perform(post("/api/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.product_id").exists())
				.andExpect(jsonPath("$.product_name").value("Test product"))
				.andExpect(jsonPath("$.price").value(199.50));
	}

	@Test
	void createsStockWithSnakeCaseRelationshipIds() throws Exception {
		String uniqueId = UUID.randomUUID().toString();
		Product product = new Product();
		product.setProductName("Stock test " + uniqueId);
		product.setPrice(new BigDecimal("199.50"));
		product = productRepository.save(product);

		Size size = new Size();
		size.setSizeName("T" + uniqueId.substring(0, 7));
		size = sizeRepository.save(size);

		Color color = new Color();
		color.setColorName("test-" + uniqueId);
		color = colorRepository.save(color);

		String requestBody = """
				{
				  "stock_id": 999,
				  "quant": 6,
				  "product": { "product_id": %d },
				  "size": { "size_id": %d },
				  "color": { "color_id": %d }
				}
				""".formatted(product.getProductId(), size.getSizeId(), color.getColorId());

		mockMvc.perform(post("/api/stock")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.stock_id").value(not(999)))
				.andExpect(jsonPath("$.quant").value(6))
				.andExpect(jsonPath("$.product.product_id").value(product.getProductId()))
				.andExpect(jsonPath("$.size.size_id").value(size.getSizeId()))
				.andExpect(jsonPath("$.color.color_id").value(color.getColorId()));
	}

}
