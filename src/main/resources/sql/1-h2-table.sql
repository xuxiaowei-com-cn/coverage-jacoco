
-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(500) NOT NULL,
  enabled TINYINT NOT NULL,
  PRIMARY KEY (username)
);
