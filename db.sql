use ftt_homework;

# User Table : base table + extend table
create table user_base
(
    user_id       Bigint primary key,
    user_password VARCHAR(200)
);

create table user_extension
(
    user_id     Bigint primary key,
    user_name   VARCHAR(30) NOT NULL,
    user_avatar TEXT,
    sex         VARCHAR(30) check ( sex in ('female', 'male') ),
    birthday    DATE,
    foreign key (user_id) references user_base (user_id)
);

create table user_address
(
    user_id      Bigint primary key,
    phone        VARCHAR(20)  NOT NULL,
    address      VARCHAR(200) NOT NULL,
    default_flag BOOL DEFAULT false,
    foreign key (user_id) references user_base (user_id)
);

# 这里价格表示全部分类的最低价格
# 分类表非具体商品
create table goods
(
    goods_id          BIGINT primary key,
    goods_price       INT,
    goods_img         TEXT,
    goods_description TEXT,
    goods_remains     INT
);

# 具体商品，公共属性表
create table goods_product_base
(
    product_id          BIGINT primary key,
    goods_id            BIGINT,
    product_price       INT,
    product_remains     INT,
    product_description TEXT,
    foreign key (goods_id) references goods (goods_id)
);

create table goods_product_extension_electron
(
    product_id BIGINT primary key,
    cpu        VARCHAR(50),
    memory     VARCHAR(20),
    foreign key (product_id) references goods_product_base (product_id)
);

create table goods_product_extension_cloth
(
    product_id BIGINT primary key,
    size       VARCHAR(50),
    color      VARCHAR(20),
    foreign key (product_id) references goods_product_base (product_id)
);

create table goods_product_extension_beverage
(
    product_id BIGINT primary key,
    taste      VARCHAR(50),
    volume     VARCHAR(20),
    foreign key (product_id) references goods_product_base (product_id)
);

create table order_taking
(
    order_id   BIGINT primary key,
    product_id BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    foreign key (user_id) references user_base (user_id),
    foreign key (product_id) references goods_product_base (product_id)
);

create table order_transportation
(
    order_id      BIGINT primary key,
    product_id    BIGINT NOT NULL,
    user_id       BIGINT NOT NULL,
    product_state VARCHAR(10) check (product_state in ('发货', '到货')),
    foreign key (user_id) references user_base (user_id),
    foreign key (product_id) references goods_product_base (product_id)
);
create table order_done_1
(
    order_id   BIGINT primary key,
    product_id BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    foreign key (user_id) references user_base (user_id),
    foreign key (product_id) references goods_product_base (product_id)
);
create table order_done_2
(
    order_id   BIGINT primary key,
    product_id BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    foreign key (user_id) references user_base (user_id),
    foreign key (product_id) references goods_product_base (product_id)
);

create table comment_primary
(
    comment_id  BIGINT primary key,
    product_id  BIGINT NOT NULL,
    user_id     Bigint,
    comment_msg TEXT,
    foreign key (user_id) references user_base (user_id),
    foreign key (product_id) references goods_product_base (product_id)
);

create table comment_senior
(
    comment_id  BIGINT primary key,
    product_id  BIGINT NOT NULL,
    user_id     Bigint NOT NULL,
    parent_id   BIGINT NOT NULL,
    comment_msg TEXT,
    foreign key (user_id) references user_base (user_id),
    foreign key (product_id) references goods_product_base (product_id),
    foreign key (parent_id) references comment_primary (comment_id)
);
