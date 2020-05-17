CREATE SCHEMA IF NOT EXISTS public;
--CREATING DATABASE
CREATE DATABASE online_store WITH OWNER postgres;
ALTER SCHEMA public OWNER TO postgres;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
--SCHEMA


CREATE TABLE "users" (
                      id     uuid DEFAULT uuid_generate_v4(),
                      username VARCHAR NOT NULL UNIQUE,
                      password  VARCHAR NOT NULL,
                      email  VARCHAR NOT NULL,
                      first_name  VARCHAR NOT NULL,
                      last_name  VARCHAR NOT NULL,
                      user_role VARCHAR NOT NULL DEFAULT 'ROLE_CUSTOMER',
                      status VARCHAR NOT NULL DEFAULT 'ACTIVE',
                      PRIMARY KEY (id)
);



CREATE TABLE "manufacturer" (
                                id     uuid DEFAULT uuid_generate_v4(),
                                name  VARCHAR NOT NULL UNIQUE,
                                PRIMARY KEY (id)
);

CREATE TABLE "product" (
                                id     uuid DEFAULT uuid_generate_v4(),
                                name  VARCHAR NOT NULL,
                                price FLOAT NOT NULL,
                                manufacturer_id uuid,
                                PRIMARY KEY (id),
                                FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id)
);

;
