----------------------------------------------------Video

insert INTO video values(video_seq.nextval, 'a');

select * FROM VIDEO ;

select * FROM VIDEO where no=6;


delete FROM VIDEO;

commit;


drop sequence video_seq;

create sequence video_seq
start WITH 1 
increment by 1
maxvalue 9999999999;

