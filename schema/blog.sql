DROP TABLE IF EXISTS SurrogateKeys;
DROP TABLE IF EXISTS RPostTag;
DROP TABLE IF EXISTS RCommentUser;
DROP TABLE IF EXISTS RCommentPost;
DROP TABLE IF EXISTS RPostUser;
DROP TABLE IF EXISTS Tags;
DROP TABLE IF EXISTS Comments;
DROP TABLE IF EXISTS Posts;
DROP TABLE IF EXISTS Users;

CREATE TABLE SurrogateKeys(
  TableName VARCHAR(50) NOT NULL PRIMARY KEY,
  KeyValue BIGINT NOT NULL DEFAULT 0
) Engine = InnoDB;

CREATE TABLE Users(
  ID INTEGER NOT NULL PRIMARY KEY,
  UserName VARCHAR(255) NOT NULL,
  Password VARCHAR(255) NOT NULL,
  Email VARCHAR(255) NOT NULL,  /* Should be unique */
  Profile TEXT NOT NULL,
  UserType VARCHAR(20) NOT NULL DEFAULT 'ANONYMOUS'
) Engine = InnoDB;

CREATE TABLE Posts(
  ID INTEGER NOT NULL PRIMARY KEY,
  Title TEXT NOT NULL,
  Content TEXT NOT NULL,
  Status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
  CreatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  ModifiedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) Engine = InnoDB;

CREATE TABLE Comments(
  ID INTEGER NOT NULL PRIMARY KEY,
  Content TEXT NOT NULL,
  Status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
  CreatedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) Engine = InnoDB;

CREATE TABLE Tags(
  ID INTEGER NOT NULL PRIMARY KEY,
  Name TEXT NOT NULL
) Engine = InnoDB;

CREATE TABLE RPostUser(
  ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  UserID INTEGER NOT NULL,
  PostID INTEGER NOT NULL
) Engine = InnoDB;

CREATE TABLE RCommentPost(
  ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  CommentID INTEGER NOT NULL,
  PostID INTEGER NOT NULL
) Engine = InnoDB;

CREATE TABLE RCommentUser(
  ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  CommentID INTEGER NOT NULL,
  UserID INTEGER NOT NULL
) Engine = InnoDB;

/* Many-to-many */
CREATE TABLE RPostTag(
  ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  TagID INTEGER NOT NULL,
  PostID INTEGER NOT NULL
) Engine = InnoDB;

/* Uniqueness */
ALTER TABLE Users
  ADD CONSTRAINT UQ_Users_Email UNIQUE (Email);
ALTER TABLE RPostUser
  ADD CONSTRAINT UQ_RPU_UserPost UNIQUE (PostID, UserID);
ALTER TABLE RCommentUser
  ADD CONSTRAINT UQ_RCU_CommentUser UNIQUE (CommentID, UserID);
ALTER TABLE RCommentPost
  ADD CONSTRAINT UQ_RCP_CommentPost UNIQUE (CommentID, PostID);
ALTER TABLE RPostTag
  ADD CONSTRAINT UQ_RPT_PostTag UNIQUE (TagID, PostID);

/* Foreign Keys */
ALTER TABLE RPostUser
  ADD CONSTRAINT FK_RPA_PostID FOREIGN KEY (PostID) REFERENCES Posts(ID),
  ADD CONSTRAINT FK_RPA_UserID FOREIGN KEY (UserID) REFERENCES Users(ID);
ALTER TABLE RCommentUser
  ADD CONSTRAINT FK_RCU_CommentID FOREIGN KEY (CommentID) REFERENCES Comments(ID),
  ADD CONSTRAINT FK_RCU_UserID FOREIGN KEY (UserID) REFERENCES Users(ID);
ALTER TABLE RCommentPost
  ADD CONSTRAINT FK_RCP_CommentID FOREIGN KEY (CommentID) REFERENCES Comments(ID),
  ADD CONSTRAINT FK_RCP_PostID FOREIGN KEY (PostID) REFERENCES Posts(ID);
ALTER TABLE RPostTag
  ADD CONSTRAINT FK_RPT_TagID FOREIGN KEY (TagID) REFERENCES Tags(ID),
  ADD CONSTRAINT FK_RPT_PostID FOREIGN KEY (PostID) REFERENCES Posts(ID);