-- Adminer 5.2.1 PostgreSQL 17.4 dump

DROP TABLE IF EXISTS "product";
DROP SEQUENCE IF EXISTS product_id_seq;
CREATE SEQUENCE product_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."product" (
    "id" bigint DEFAULT nextval('product_id_seq') NOT NULL,
    "name" character varying(255) NOT NULL,
    "price" double precision NOT NULL,
    "quantity" integer NOT NULL,
    CONSTRAINT "product_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

CREATE UNIQUE INDEX uk_jmivyxk9rmgysrmsqw15lqr5b ON public.product USING btree (name);

INSERT INTO "product" ("id", "name", "price", "quantity") VALUES
(2,	'Soupline concentrée',	4500,	60),
(3,	'Détachant Textile',	3000,	2),
(7,	'Baume François',	500,	120),
(8,	'Jus de Moringa',	500,	1),
(9,	'Cigarette',	650,	10);

-- 2025-05-28 12:36:47 UTC
