insert into User (id,username) values (1,'test');
insert into productorder (id,orderCompleted,purchaseDate,purchaseTime,totalPrice,user_id)
values (1,false,null,null,null,1);
insert into productorder (id,orderCompleted,purchaseDate,purchaseTime,totalPrice,user_id)
values (2,true,null,null,null,1);
insert into productorder (id,orderCompleted,purchaseDate,purchaseTime,totalPrice,user_id)
values (3,true,current_date,null,null,1);
insert into productorder (id,orderCompleted,purchaseDate,purchaseTime,totalPrice,user_id)
values (4,true,TIMESTAMPADD(DAY,1,current_date),null,null,1);