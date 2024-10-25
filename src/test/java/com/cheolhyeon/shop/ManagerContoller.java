package com.cheolhyeon.shop;

public class ManagerContoller {
    /*
    * @SpringBootTest
@AutoConfigureMockMvc
class BlogControllerTest {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    WebApplicationContext context;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUpMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @DisplayName("addArticle : 블로그 글 추가에 성공")
    @Test
    void addArticle() throws Exception {
        // given
        final String url = "/api/articles";
        final String title = "이것은 제목입니다";
        final String content = "이것은 내용입니다";
        final AddArticleRequest userRequest = new AddArticleRequest(title, content);

        final String requestBody = mapper.writeValueAsString(userRequest);
        // when
        final ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));
        // then
        result.andExpect(status().isCreated());

        List<Article> articles = blogRepository.findAll();

        Assertions.assertThat(articles.size()).isEqualTo(1);
        Assertions.assertThat(articles.get(0).getTitle()).isEqualTo(userRequest.getTitle());
        Assertions.assertThat(articles.get(0).getContent()).isEqualTo(userRequest.getContent());
    }*/
}
