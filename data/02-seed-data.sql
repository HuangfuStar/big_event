--
use big_event;

-- 插入用户表测试数据
INSERT INTO `user` (`username`, `password`, `nickname`, `email`, `user_pic`, `create_time`, `update_time`) VALUES
                                                                                                               ('admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', 'admin@bigevent.com', '/images/admin.jpg', NOW(), NOW()),
                                                                                                               ('zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '张三', 'zhangsan@example.com', '/images/zhangsan.jpg', NOW(), NOW()),
                                                                                                               ('lisi', 'e10adc3949ba59abbe56e057f20f883e', '李四', 'lisi@example.com', '/images/lisi.jpg', NOW(), NOW()),
                                                                                                               ('wangwu', 'e10adc3949ba59abbe56e057f20f883e', '王五', 'wangwu@example.com', '/images/wangwu.jpg', NOW(), NOW()),
                                                                                                               ('zhaoliu', 'e10adc3949ba59abbe56e057f20f883e', '赵六', 'zhaoliu@example.com', '/images/zhaoliu.jpg', NOW(), NOW());

-- 插入分类表测试数据
INSERT INTO `category` (`category_name`, `category_alias`, `create_user`, `create_time`, `update_time`) VALUES
                                                                                                            ('技术文章', 'tech', 1, NOW(), NOW()),
                                                                                                            ('生活随笔', 'life', 1, NOW(), NOW()),
                                                                                                            ('项目分享', 'project', 2, NOW(), NOW()),
                                                                                                            ('学习笔记', 'study', 2, NOW(), NOW()),
                                                                                                            ('行业资讯', 'news', 3, NOW(), NOW()),
                                                                                                            ('问题解答', 'qa', 3, NOW(), NOW()),
                                                                                                            ('资源推荐', 'resource', 4, NOW(), NOW()),
                                                                                                            ('经验总结', 'experience', 5, NOW(), NOW());

-- 插入文章表测试数据
INSERT INTO `article` (`title`, `content`, `cover_img`, `state`, `category_id`, `create_user`, `create_time`, `update_time`) VALUES
                                                                                                                                 ('Spring Boot 入门指南', 'Spring Boot 是一个用于简化 Spring 应用初始搭建以及开发过程的框架...', '/covers/springboot.jpg', '已发布', 1, 1, NOW(), NOW()),
                                                                                                                                 ('微服务架构设计实践', '微服务架构是一种将单个应用程序作为一套小型服务开发的方法...', '/covers/microservice.jpg', '已发布', 1, 1, NOW(), NOW()),
                                                                                                                                 ('我的编程学习之路', '从大学开始接触编程，到现在已经走过了五年的历程...', '/covers/learning.jpg', '草稿', 2, 2, NOW(), NOW()),
                                                                                                                                 ('如何提高代码质量', '代码质量是软件开发中非常重要的一个方面...', '/covers/codequality.jpg', '已发布', 4, 2, NOW(), NOW()),
                                                                                                                                 ('人工智能发展趋势', '近年来，人工智能技术在各个领域都取得了显著的进展...', '/covers/ai.jpg', '已发布', 5, 3, NOW(), NOW()),
                                                                                                                                 ('React Hooks 使用技巧', 'React Hooks 是 React 16.8 引入的新特性...', '/covers/react.jpg', '已发布', 1, 3, NOW(), NOW()),
                                                                                                                                 ('数据库优化实战', '在实际项目中，数据库性能优化是一个永恒的话题...', '/covers/database.jpg', '已发布', 4, 4, NOW(), NOW()),
                                                                                                                                 ('团队协作工具推荐', '在现代软件开发中，团队协作工具的选择至关重要...', '/covers/tools.jpg', '草稿', 7, 4, NOW(), NOW()),
                                                                                                                                 ('项目管理经验分享', '经过多个项目的历练，我总结了一些项目管理的经验...', '/covers/project.jpg', '已发布', 3, 5, NOW(), NOW()),
                                                                                                                                 ('前端性能优化方案', '前端性能直接影响用户体验，以下是一些优化方案...', '/covers/frontend.jpg', '已发布', 1, 5, NOW(), NOW()),
                                                                                                                                 ('移动端开发注意事项', '移动端开发与PC端开发有很多不同之处...', '/covers/mobile.jpg', '草稿', 1, 1, NOW(), NOW()),
                                                                                                                                 ('云计算技术解析', '云计算已经成为现代IT基础设施的重要组成部分...', '/covers/cloud.jpg', '已发布', 5, 2, NOW(), NOW());