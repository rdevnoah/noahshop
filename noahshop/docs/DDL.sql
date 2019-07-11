delete type dp_main;
delete type member_role;
delete type is_sell;
delete type is_member;
delete type order_payment;
delete type order_status;
delete type delivery_status;

-- product enum 'dp_main'
create type dp_main as enum('Y', 'N');

-- member enum 'member_role'
create type member_role as enum('USER','ADMIN');

-- product enum 'is_sell'
create type is_sell as enum('Y','N');

-- order enum 'is_member'
create type is_member as enum('Y','N');

-- order enum 'order_payment'
create type order_payment as enum('무통장입금','카드결제');

-- order enum 'order_status'
create type order_status as enum('결제대기', '결제완료');

-- delivery enum 'delivery_status'
create type delivery_status as enum('배송준비중', '배송중', '배송완료');

-- 회원
CREATE TABLE "member"
(
	"no"        serial8     NOT NULL, -- 회원번호
	"id"        varchar(20) NOT NULL, -- 아이디
	"password"  text        NOT NULL, -- 비밀번호
	"name"      varchar(10) NOT NULL, -- 이름
	"tel"       varchar(20) NOT NULL, -- 연락처
	"address"   text        NOT NULL, -- 주소
	"email"     varchar(50) NOT NULL, -- 이메일
	"join_date" timestamp   NOT NULL, -- 가입일
	"role"      member_role NOT NULL
);

-- 회원 기본키
CREATE UNIQUE INDEX "PK_member"
	ON "member"
	( -- 회원
		"no" ASC -- 회원번호
	)
;
-- 회원
ALTER TABLE "member"
	ADD CONSTRAINT "PK_member"
		 -- 회원 기본키
	PRIMARY KEY 
	USING INDEX "PK_member";

-- 상품
CREATE TABLE "product"
(
	"no"          serial8      NOT NULL, -- 상품번호	
	"category_no" serial8      NOT NULL, -- 카테고리번호
	"code"        varchar(30)  NOT NULL, -- 상품코드
	"name"        varchar(100) NOT NULL,     -- 상품명
	"price"       integer      NOT NULL,     -- 가격
	"description" text         NOT NULL,     -- 상품설명
	"reg_date"    timestamp    NOT NULL,     -- 등록일
	"dp_main"     dp_main      NOT NULL,      -- 메인표시유무
	"is_sell"     is_sell      NOT NULL,      -- 판매여부
);

-- 상품 기본키
CREATE UNIQUE INDEX "PK_product"
	ON "product"
	( -- 상품
		"no" ASC -- 상품번호
	)
;
-- 상품
ALTER TABLE "product"
	ADD CONSTRAINT "PK_product"
		 -- 상품 기본키
	PRIMARY KEY 
	USING INDEX "PK_product";

-- 장바구니
CREATE TABLE "cart"
(
	"no"       serial8 NOT NULL, -- 진열상품번호
	"no2"      serial8 NOT NULL, -- 회원번호
	"quantity" integer NOT NULL  -- 주문수량
);

-- 장바구니 기본키
CREATE UNIQUE INDEX "PK_cart"
	ON "cart"
	( -- 장바구니
		"no" ASC, -- 진열상품번호
		"no2" ASC -- 회원번호
	)
;
-- 장바구니
ALTER TABLE "cart"
	ADD CONSTRAINT "PK_cart"
		 -- 장바구니 기본키
	PRIMARY KEY 
	USING INDEX "PK_cart";

-- 주문
CREATE TABLE "order"
(
	"no"         serial8       NOT NULL, -- 주문번호
	"member_no"  integer       NULL,     -- 회원번호
	"order_no"   varchar(30)   NOT NULL, -- 고객주문번호
	"order_date" timestamp     NOT NULL, -- 주문일
	"address"    text          NOT NULL, -- 주문자주소
	"is_member"  is_member     NOT NULL, -- 회원여부
	"password"   text          NULL,     -- 주문비밀번호
	"payment"    order_payment NOT NULL, -- 결제방식
	"price"      integer       NOT NULL, -- 주문금액
	"buyer_name" varchar(10)   NOT NULL, -- 주문자명
	"email"      varchar(50)   NOT NULL, -- 주문자 이메일
	"status"     order_status  NOT NULL, -- 주문상태
	"buyer_tel"  varchar(20)   NULL      -- 주문자 연락처
);

-- 주문 기본키
CREATE UNIQUE INDEX "PK_order"
	ON "order"
	( -- 주문
		"no" ASC -- 주문번호
	)
;
-- 주문
ALTER TABLE "order"
	ADD CONSTRAINT "PK_order"
		 -- 주문 기본키
	PRIMARY KEY 
	USING INDEX "PK_order";

-- 상품상세
CREATE TABLE "product_detail"
(
	"option_child_no" serial8 NOT NULL, -- 하위옵션번호
	"no"              serial8 NOT NULL, -- 상품번호
	"stock"           integer NULL      -- 재고수량
);

-- 상품상세 기본키
CREATE UNIQUE INDEX "PK_product_detail"
	ON "product_detail"
	( -- 상품상세
		"option_child_no" ASC, -- 하위옵션번호
		"no" ASC -- 상품번호
	)
;
-- 상품상세
ALTER TABLE "product_detail"
	ADD CONSTRAINT "PK_product_detail"
		 -- 상품상세 기본키
	PRIMARY KEY 
	USING INDEX "PK_product_detail";

-- 이미지
CREATE TABLE "product_image"
(
	"no"         serial8 NOT NULL, -- 이미지번호
	"product_no" serial8 NOT NULL, -- 상품번호
	"url"        text    NOT NULL  -- URL
);

-- 이미지 기본키
CREATE UNIQUE INDEX "PK_product_image"
	ON "product_image"
	( -- 이미지
		"no" ASC -- 이미지번호
	)
;
-- 이미지
ALTER TABLE "product_image"
	ADD CONSTRAINT "PK_product_image"
		 -- 이미지 기본키
	PRIMARY KEY 
	USING INDEX "PK_product_image";

-- 카테고리
CREATE TABLE "category"
(
	"no"   serial8     NOT NULL, -- 카테고리번호
	"name" varchar(50) NOT NULL  -- 카테고리명
);

-- 카테고리 기본키
CREATE UNIQUE INDEX "PK_category"
	ON "category"
	( -- 카테고리
		"no" ASC -- 카테고리번호
	)
;
-- 카테고리
ALTER TABLE "category"
	ADD CONSTRAINT "PK_category"
		 -- 카테고리 기본키
	PRIMARY KEY 
	USING INDEX "PK_category";

-- 주문상품
CREATE TABLE "order_product"
(
	"no"       serial8 NOT NULL, -- 주문번호
	"id"       serial8 NOT NULL, -- 진열상품번호
	"quantity" integer NOT NULL  -- 주문수량
);

-- 주문상품 기본키
CREATE UNIQUE INDEX "PK_order_product"
	ON "order_product"
	( -- 주문상품
		"no" ASC, -- 주문번호
		"id" ASC -- 진열상품번호
	)
;
-- 주문상품
ALTER TABLE "order_product"
	ADD CONSTRAINT "PK_order_product"
		 -- 주문상품 기본키
	PRIMARY KEY 
	USING INDEX "PK_order_product";

-- 패스워드 salt
CREATE TABLE "salt"
(
	"member_id" varchar(20) NOT NULL, -- 아이디
	"key"       text        NOT NULL  -- 식별키
);

-- 패스워드 salt 기본키
CREATE UNIQUE INDEX "PK_salt"
	ON "salt"
	( -- 패스워드 salt
		"member_id" ASC -- 아이디
	)
;
-- 패스워드 salt
ALTER TABLE "salt"
	ADD CONSTRAINT "PK_salt"
		 -- 패스워드 salt 기본키
	PRIMARY KEY 
	USING INDEX "PK_salt";

-- 진열상품
CREATE TABLE "display_product"
(
	"no"              serial8 NOT NULL, -- 진열상품번호
	"quantity"        integer NOT NULL, -- 진열수량
	"option_child_no" serial8 NOT NULL, -- 하위옵션번호
	"product_no"      serial8 NOT NULL  -- 상품번호
);

-- 진열상품 기본키
CREATE UNIQUE INDEX "PK_display_product"
	ON "display_product"
	( -- 진열상품
		"no" ASC -- 진열상품번호
	)
;
-- 진열상품
ALTER TABLE "display_product"
	ADD CONSTRAINT "PK_display_product"
		 -- 진열상품 기본키
	PRIMARY KEY 
	USING INDEX "PK_display_product";

-- 배송
CREATE TABLE "delivery"
(
	"no"      serial8         NOT NULL, -- 주문번호
	"status"  delivery_status NOT NULL, -- 배송여부
	"name"    varchar(10)     NOT NULL, -- 수신자명
	"address" text            NOT NULL, -- 배송주소
	"tel"     varchar(20)     NOT NULL, -- 수신자연락처
	"message" text            NOT NULL  -- 배송메세지
);

-- 배송 기본키
CREATE UNIQUE INDEX "PK_delivery"
	ON "delivery"
	( -- 배송
		"no" ASC -- 주문번호
	)
;
-- 배송
ALTER TABLE "delivery"
	ADD CONSTRAINT "PK_delivery"
		 -- 배송 기본키
	PRIMARY KEY 
	USING INDEX "PK_delivery";

-- 상위옵션
CREATE TABLE "option_parent"
(
	"no"   serial8     NOT NULL, -- 상위옵션번호
	"name" varchar(30) NOT NULL  -- 상위옵션명
);

-- 상위옵션 기본키
CREATE UNIQUE INDEX "PK_option_parent"
	ON "option_parent"
	( -- 상위옵션
		"no" ASC -- 상위옵션번호
	)
;
-- 상위옵션
ALTER TABLE "option_parent"
	ADD CONSTRAINT "PK_option_parent"
		 -- 상위옵션 기본키
	PRIMARY KEY 
	USING INDEX "PK_option_parent";

-- 하위옵션
CREATE TABLE "option_child"
(
	"no"               serial8     NOT NULL, -- 하위옵션번호
	"name"             varchar(30) NOT NULL, -- 하위옵션명
	"option_parent_no" serial8     NOT NULL  -- 상위옵션번호
);

-- 하위옵션 기본키
CREATE UNIQUE INDEX "PK_option_child"
	ON "option_child"
	( -- 하위옵션
		"no" ASC -- 하위옵션번호
	)
;
-- 하위옵션
ALTER TABLE "option_child"
	ADD CONSTRAINT "PK_option_child"
		 -- 하위옵션 기본키
	PRIMARY KEY 
	USING INDEX "PK_option_child";

-- 개인정보 식별키
CREATE TABLE "key"
(
	"member_id" varchar(20) NOT NULL, -- 아이디
	"key"       text        NOT NULL  -- 식별키
);

-- 개인정보 식별키 기본키
CREATE UNIQUE INDEX "PK_key"
	ON "key"
	( -- 개인정보 식별키
		"member_id" ASC -- 아이디
	)
;
-- 개인정보 식별키
ALTER TABLE "key"
	ADD CONSTRAINT "PK_key"
		 -- 개인정보 식별키 기본키
	PRIMARY KEY 
	USING INDEX "PK_key";

-- 상품
ALTER TABLE "product"
	ADD CONSTRAINT "FK_category_TO_product"
	 -- 카테고리 -> 상품
		FOREIGN KEY (
			"category_no" -- 카테고리번호
		)
		REFERENCES "category" ( -- 카테고리
			"no" -- 카테고리번호
		);

-- 장바구니
ALTER TABLE "cart"
	ADD CONSTRAINT "FK_member_TO_cart"
	 -- 회원 -> 장바구니
		FOREIGN KEY (
			"no2" -- 회원번호
		)
		REFERENCES "member" ( -- 회원
			"no" -- 회원번호
		);

-- 장바구니
ALTER TABLE "cart"
	ADD CONSTRAINT "FK_display_product_TO_cart"
	 -- 진열상품 -> 장바구니
		FOREIGN KEY (
			"no" -- 진열상품번호
		)
		REFERENCES "display_product" ( -- 진열상품
			"no" -- 진열상품번호
		);

-- 주문
ALTER TABLE "order"
	ADD CONSTRAINT "FK_member_TO_order"
	 -- 회원 -> 주문
		FOREIGN KEY (
			"member_no" -- 회원번호
		)
		REFERENCES "member" ( -- 회원
			"no" -- 회원번호
		);

-- 상품상세
ALTER TABLE "product_detail"
	ADD CONSTRAINT "FK_product_TO_product_detail"
	 -- 상품 -> 상품상세
		FOREIGN KEY (
			"no" -- 상품번호
		)
		REFERENCES "product" ( -- 상품
			"no" -- 상품번호
		);

-- 상품상세
ALTER TABLE "product_detail"
	ADD CONSTRAINT "FK_option_child_TO_product_detail"
	 -- 하위옵션 -> 상품상세
		FOREIGN KEY (
			"option_child_no" -- 하위옵션번호
		)
		REFERENCES "option_child" ( -- 하위옵션
			"no" -- 하위옵션번호
		);

-- 이미지
ALTER TABLE "product_image"
	ADD CONSTRAINT "FK_product_TO_product_image"
	 -- 상품 -> 이미지
		FOREIGN KEY (
			"product_no" -- 상품번호
		)
		REFERENCES "product" ( -- 상품
			"no" -- 상품번호
		);

-- 주문상품
ALTER TABLE "order_product"
	ADD CONSTRAINT "FK_order_TO_order_product"
	 -- 주문 -> 주문상품
		FOREIGN KEY (
			"no" -- 주문번호
		)
		REFERENCES "order" ( -- 주문
			"no" -- 주문번호
		);

-- 주문상품
ALTER TABLE "order_product"
	ADD CONSTRAINT "FK_display_product_TO_order_product"
	 -- 진열상품 -> 주문상품
		FOREIGN KEY (
			"id" -- 진열상품번호
		)
		REFERENCES "display_product" ( -- 진열상품
			"no" -- 진열상품번호
		);

-- 진열상품
ALTER TABLE "display_product"
	ADD CONSTRAINT "FK_product_detail_TO_display_product"
	 -- 상품상세 -> 진열상품
		FOREIGN KEY (
			"option_child_no", -- 하위옵션번호
			"product_no"       -- 상품번호
		)
		REFERENCES "product_detail" ( -- 상품상세
			"option_child_no", -- 하위옵션번호
			"no"               -- 상품번호
		);

-- 배송
ALTER TABLE "delivery"
	ADD CONSTRAINT "FK_order_TO_delivery"
	 -- 주문 -> 배송
		FOREIGN KEY (
			"no" -- 주문번호
		)
		REFERENCES "order" ( -- 주문
			"no" -- 주문번호
		);

-- 하위옵션
ALTER TABLE "option_child"
	ADD CONSTRAINT "FK_option_parent_TO_option_child"
	 -- 상위옵션 -> 하위옵션
		FOREIGN KEY (
			"option_parent_no" -- 상위옵션번호
		)
		REFERENCES "option_parent" ( -- 상위옵션
			"no" -- 상위옵션번호
		);