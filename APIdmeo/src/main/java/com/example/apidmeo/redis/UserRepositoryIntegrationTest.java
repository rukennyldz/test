@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRedisConfiguration.class)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveUser_toRedis() {
        UUID id = UUID.randomUUID();
        User user = new User(id, "name");

        User saved = userRepository.save(user);

        assertNotNull(saved);
    }
}