INSERT INTO ROLE(name)
VALUES
    ('Admin'),
    ('User');

INSERT INTO USER(date_of-birth, username, first_name, last_name, password, phone, sex)
VALUES
    ('14/09/1999', 'gautier.cou@gmail.com', 'Gautier', 'Couture', '123456', '0601020304','1'),
	('12/07/1998', 'tristan.cou@gmail.com', 'Tristan', 'Coussaert', '78910', '0607080910','1'),
	('22/06/1949', 'meryl.streep@gmail.com', 'Meryl', 'Streep', 'mammamia!', '0720082006','0');

INSERT INTO POST(content, title, user_creator)
VALUES
    ('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent imperdiet lorem bibendum purus condimentum malesuada. Morbi in finibus lorem. Integer dignissim tempus vulputate. Cras dictum velit non pharetra pulvinar. Proin finibus augue ut rhoncus consectetur. Duis nunc turpis, varius eget pretium ut, volutpat ac augue. Vestibulum in sodales sapien, vitae semper justo. Ut tempor nisl ac leo pellentesque bibendum.', 'L\'essort des petits bains en France', 'tristan.cou@gmail.com'),
	('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent imperdiet lorem bibendum purus condimentum malesuada. Morbi in finibus lorem. Integer dignissim tempus vulputate. Cras dictum velit non pharetra pulvinar. Proin finibus augue ut rhoncus consectetur. Duis nunc turpis, varius eget pretium ut, volutpat ac augue. Vestibulum in sodales sapien, vitae semper justo. Ut tempor nisl ac leo pellentesque bibendum.', 'League of Legends, le pire jeu', 'tristan.cou@gmail.com'),
	('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent imperdiet lorem bibendum purus condimentum malesuada. Morbi in finibus lorem. Integer dignissim tempus vulputate. Cras dictum velit non pharetra pulvinar. Proin finibus augue ut rhoncus consectetur. Duis nunc turpis, varius eget pretium ut, volutpat ac augue. Vestibulum in sodales sapien, vitae semper justo. Ut tempor nisl ac leo pellentesque bibendum.', 'Mamma mia! : Mon film préféré', 'meryl.streep@gmail.com');
	
	/* INSERT INTO FRIEND(id, accepted, friend_name, user_receiver, user_sender)
VALUES
    (1, 'Alpha Romeo'),
    (2, 'Honda'),
    (3, 'Jeep'),
    (4, 'Nissan'),
    (5, 'Subaru');
 */