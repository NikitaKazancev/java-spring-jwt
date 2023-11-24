package ru.nk.rschir.configuration;

//@EnableRedisRepositories
public class RedisConfig {
//    @Bean
//    private JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName("localhost");
//        redisStandaloneConfiguration.setPort(6379);
//        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration);
//        return factory;
//    }
//    @Bean
//    private LettuceConnectionFactory lettuceConnectionFactory() {
////        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//        LettucePoolingClientConfiguration clientConfiguration = LettucePoolingClientConfiguration
//                .builder()
//                .clientResources(DefaultClientResources.create())
//                .commandTimeout(Duration.ofMillis(2000))
//                .poolConfig(new GenericObjectPoolConfig())
//                .clientOptions(ClientOptions.create())
//                .build();
//        return new LettuceConnectionFactory(configuration, clientConfiguration);
//    }
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//
//        redisTemplate.setConnectionFactory(jedisConnectionFactory()); // redis/clients/jedis/JedisClientConfig
////        redisTemplate.setConnectionFactory(lettuceConnectionFactory()); // non null || redis/clients/jedis/JedisClientConfig
//
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setEnableTransactionSupport(true);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
}

