# DaDidada-Sport-Appointment



## 介绍

 [Shanxi University](http://english.sxu.edu.cn/) 19级计科数据库大作业的最终成品

## 项目资料

所有文档：https://www.yuque.com/qianlong-4oxpc/qvbyc9





## 前端



### 整体

* 注册/登录页面
* 发帖
* 主页（包括 帖子 list ）
* 帖子详情
* 一级评论详情
* 个人信息





### 权限管理

主要用 token + 动态路由进行















## 后端







## 数据库设计

```sql
use sport_homework;
show tables;


# 用户表

create table user
(
    user_id           int auto_increment,
    user_name         VARCHAR(20) NOT NULL default 'suger' unique,
    user_sex          VARCHAR(10) check ( user_sex in ('male', 'female') ),
    user_height       int check (user_height > 0),
    user_weight       int check (user_weight > 0),
    user_age          int check (user_age > 0),
    user_specialty    text comment '特长',
    user_introduction text comment '签名',
    user_identity     VARCHAR(20) check ( user_identity in ('teacher', 'student', 'other')),
    primary key (user_id)
);

# 用户密码表
create table userpassword
(
    user_id       int primary key,
    user_password varchar(100) not null,
    foreign key (user_id) references user (user_id)
);

create table joiner
(
    state      int comment '1:participant,2:applicant,3:initiator,4:readyparticipant',
    joiner_id  int not null,
    post_id    int not null,
    begin_time datetime comment '只有readyparticipant才有',
    end_time   datetime comment '只有readyparticipant才有',
    bat_offer  int check (bat_offer >= 0) comment '可提供拍的数量',
    ball_offer int check (ball_offer >= 0) comment '可提供球的数量',
    position   varchar(50),
    primary key (joiner_id, post_id),
    foreign key (joiner_id) references user (user_id),
    foreign key (post_id) references post (post_id)
);

# # 发起者表
# create table initiator
# (
#     initiator_id int not null,
#     post_id      int not null,
#     bat_offer    int check (bat_offer >= 0) comment '可提供拍的数量',
#     ball_offer   int check (ball_offer >= 0) comment '可提供球的数量',
#     position     varchar(50),
#     primary key (initiator_id, post_id),
#     foreign key (initiator_id) references user (user_id),
#     foreign key (post_id) references post (post_id)
# );

# # 申请者表
# create table applicant
# (
#     applicant_id int not null,
#     post_id      int not null,
#     bat_offer    int check (bat_offer >= 0) comment '可提供拍的数量',
#     ball_offer   int check (ball_offer >= 0) comment '可提供球的数量',
#     position     varchar(50),
#     foreign key (applicant_id) references user (user_id),
#     foreign key (post_id) references post (post_id),
#     primary key (applicant_id, post_id)
# );

# # 参与者表
# create table participant
# (
#     participant_id int not null,
#     post_id        int not null,
#     bat_offer      int check (bat_offer >= 0) comment '可提供拍的数量',
#     ball_offer     int check (ball_offer >= 0) comment '可提供球的数量',
#     position       varchar(50),
#     foreign key (participant_id) references user (user_id),
#     foreign key (post_id) references post (post_id),
#     primary key (participant_id, post_id)
# );

# # 待参与者表
# create table readyparticipant
# (
#     readyparticipant_id int      not null,
#     post_id             int      not null,
#     bat_offer           int check (bat_offer >= 0) comment '可提供拍的数量',
#     ball_offer          int check (ball_offer >= 0) comment '可提供球的数量',
#     position            varchar(50),
#     teammate_exist      bool default false,
#     begin_time          datetime not null,#待修改!!!
#     end_time            datetime not null,#待修改!!!
#     foreign key (readyparticipant_id) references user (user_id),
#     foreign key (post_id) references post (post_id),
#     primary key (readyparticipant_id, post_id)
# );

# 意向好友表
create table teammate
(
    readyparticipant_id int not null,
    post_id             int not null,
    teammate_id         int not null,
    foreign key (readyparticipant_id) references user (user_id),
    foreign key (post_id) references post (post_id),
    foreign key (teammate_id) references user (user_id),
    primary key (readyparticipant_id, post_id, teammate_id)
);
# ALTER TABLE teammate drop foreign key teammate_ibfk_1;
# 帖子表
create table post
(
    post_id                int auto_increment,
    initiator_id           int      not null,
    reverse_id             int comment '如果为null，则球场地点为其他',
    post_time              datetime not null comment '发帖时间',
    begin_time             datetime not null comment '开场时间',
    end_time               datetime not null comment '终场时间',
    post_img               VARCHAR(2000)     default 'http://qianlon.cn/upload/2021/11/image-c571dd25ab744ff0a954fae2cfe5b61a.png',
    ball_id                int, # 如果为空则说明是其他球类
    bat_need_number        int check ( bat_need_number >= 0 ),
    ball_need_number       int check ( ball_need_number >= 0 ),
    bat_owned_number       int check ( bat_owned_number >= 0 ),
    ball_owned_number      int check ( ball_owned_number >= 0 ),
    people_current_number  int check ( people_current_number >= 0 ),
    people_min_number      int check ( people_min_number >= 0 ),
    people_max_number      int check ( people_max_number >= 0 ),
    initiator_note         text comment '偏好，如果地点其他，请发起人填写具体地点',
    initiator_note_details text comment '补充描述',
    state                  int      not null default 0 comment '待开：0，已开可加入：1，已开不可加入：2，结束：3',
#     foreign key (post_id) references post (post_id),
    foreign key (initiator_id) references user (user_id),
    foreign key (reverse_id) references courtreserve (reserve_id),
    foreign key (ball_id) references ballrule (ball_id),
    primary key (post_id)
);

#  球类规则表
create table ballrule
(
    ball_id   int,
    ball_type varchar(30) not null,
    bat_need  bool,
    ball_need bool default true,
    primary key (ball_id)
);

# 球场表
create table court
(
    court_id  int auto_increment,
    location  text not null,
    court_img VARCHAR(2000) default 'http://qianlon.cn/upload/2021/11/image-c571dd25ab744ff0a954fae2cfe5b61a.png',
    primary key (court_id)
);

# 球场预约表
create table courtreserve
(
    reserve_id int primary key auto_increment,
    court_id   int      not null,
    begin_time datetime not null,
    end_time   datetime not null,
    last_time  datetime not null,
    foreign key (court_id) references court (court_id)
);

# 一级评论表
create table dadcomment
(
    dadcomment_id   int primary key auto_increment,
    post_time       datetime not null,
    post_id         int      not null,
    user_id         int      not null,
    comment_content text     not null,
    foreign key (post_id) references post (post_id),
    foreign key (user_id) references user (user_id)
);

# 二级评论表
create table soncomment
(
    soncomment_id   int primary key auto_increment,
    post_time       datetime not null,
    dadcomment_id   int      not null,
    user_id         int      not null,
    comment_content text     not null,
    foreign key (dadcomment_id) references dadcomment (dadcomment_id),
    foreign key (user_id) references user (user_id)
);



```













## 人员

* Sean 陈舜泽
* Daryel  蔡舰欧
* Jcheng 曹嘉成
* Cherish 陈薛西







## Refrence