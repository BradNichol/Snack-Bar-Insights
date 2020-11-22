create table brands
(
    id        varchar(50) NOT NULL PRIMARY KEY,
    name      varchar(50) NOT NULL
);

create table products
(
    id        varchar(50) NOT NULL PRIMARY KEY,
    brand_id  varchar(50) NOT NULL,
    name      varchar(50) NOT NULL,
    type      varchar(50) NOT NULL,
    pack_size integer,
    CONSTRAINT fk_brand_id
        FOREIGN KEY(brand_id)
        REFERENCES brands(id)
);

create table nutritional_information
(
    id            varchar(50) NOT NULL PRIMARY KEY,
    product_id    varchar(50) NOT NULL,
    energy        double precision,
    fat           double precision,
    saturates     double precision,
    carbohydrates double precision,
    sugars        double precision,
    polyols       double precision,
    fibre         double precision,
    protein       double precision,
    salt          double precision,
    CONSTRAINT fk_product_id
        FOREIGN KEY(product_id)
        REFERENCES products(id)
);

create table price_tracking
(
    id            varchar(50) NOT NULL PRIMARY KEY,
    product_id    varchar(50) NOT NULL,
    date          timestamp NOT NULL,
    price         double precision,
    CONSTRAINT fk_product_id
        FOREIGN KEY(product_id)
        REFERENCES products(id)
);

create table scraper_resources
(
    id          varchar(50) NOT NULL PRIMARY KEY,
    product_id  varchar(50) NOT NULL,
    url         text NOT NULL,
    xpath       text NOT NULL,
    CONSTRAINT fk_product_id
        FOREIGN KEY(product_id)
        REFERENCES products(id)
);
