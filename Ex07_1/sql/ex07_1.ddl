/**********************************/
/* テーブル名: 記事 */
/**********************************/
CREATE TABLE T_ARTICLE(
		article_num SERIAL,
		author VARCHAR(20) NOT NULL,
		title VARCHAR(256) NOT NULL,
		contents VARCHAR(2048) NOT NULL,
		create_timestamp TIMESTAMP NOT NULL
);


ALTER TABLE T_ARTICLE ADD CONSTRAINT IDX_T_ARTICLE_PK PRIMARY KEY (article_num);

