
INSERT INTO User_Entity(nickname,email,password,salt,img_Url) VALUES ('문공표','asdasd@gmail.com','asdasd','aaaaaaaaaa','sadasdasfxc');
INSERT INTO Crs_Entity (crs_Name,is_Accept,img_Url,usr) VALUES ('Crs1',1,'sadasd',1);
INSERT INTO Crs_Entity (crs_Name,is_Accept,img_Url,usr) VALUES ('Crs2',0,'sadasd',1);
INSERT INTO Day_Entity (dayx,crs) VALUES (1,1);
INSERT INTO Day_Entity (dayx,crs) VALUES (2,1);
INSERT INTO Day_Entity (dayx,crs) VALUES (1,2);
INSERT INTO Plc_Entity (plc_Name,lat,lng,img_Url,category,is_Accept,usr,cost) VALUES ('Plc1','123','123','sadasd','음식점',1,1,50000);
INSERT INTO Plc_Entity (plc_Name,lat,lng,img_Url,category,is_Accept,usr,cost) VALUES ('Plc2','321','321','sadasdss','도서관',1,1,5000);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-11T12:02:00',1,1);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-11T18:30:00',1,2);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-12T07:45:00',2,2);
INSERT INTO Plc_Cmt (usr,plc,content) VALUES (1,2,'ㅋㅋㅋㅋㅋㅋㅋ');
INSERT INTO Plc_Cmt (usr,plc,content) VALUES (1,2,'ㅎㅇ요');
INSERT INTO Plc_Cmt (usr,plc,content) VALUES (1,2,'ㄹㅈㄷ');
INSERT INTO Crs_Cmt (usr,crs,content) VALUES (1,2,'가');
INSERT INTO Crs_Cmt (usr,crs,content) VALUES (1,2,'나');
INSERT INTO Crs_Cmt (usr,crs,content) VALUES (1,2,'다');
