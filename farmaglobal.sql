--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-12-19 20:46:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 28313)
-- Name: barang; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.barang (
    id_barang bigint NOT NULL,
    harga_barang integer,
    nama_barang character varying(255),
    stok_barang integer
);


ALTER TABLE public.barang OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 28311)
-- Name: barang_id_barang_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.barang_id_barang_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.barang_id_barang_seq OWNER TO postgres;

--
-- TOC entry 3009 (class 0 OID 0)
-- Dependencies: 200
-- Name: barang_id_barang_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.barang_id_barang_seq OWNED BY public.barang.id_barang;


--
-- TOC entry 203 (class 1259 OID 28321)
-- Name: detail_penjualan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detail_penjualan (
    id_detail_penjualan bigint NOT NULL,
    jumlah_barang integer,
    total_penjualan integer,
    penjualan_id bigint
);


ALTER TABLE public.detail_penjualan OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 28319)
-- Name: detail_penjualan_id_detail_penjualan_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detail_penjualan_id_detail_penjualan_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detail_penjualan_id_detail_penjualan_seq OWNER TO postgres;

--
-- TOC entry 3010 (class 0 OID 0)
-- Dependencies: 202
-- Name: detail_penjualan_id_detail_penjualan_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detail_penjualan_id_detail_penjualan_seq OWNED BY public.detail_penjualan.id_detail_penjualan;


--
-- TOC entry 205 (class 1259 OID 28329)
-- Name: penjualan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.penjualan (
    id_penjualan bigint NOT NULL,
    banyak_barang integer,
    harga_barang integer,
    jumlah_uang_pembeli integer,
    nama_pembeli character varying(255),
    no_hp_pembeli character varying(255),
    tanggal_penjualan timestamp without time zone,
    barang_id bigint
);


ALTER TABLE public.penjualan OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 28327)
-- Name: penjualan_id_penjualan_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.penjualan_id_penjualan_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.penjualan_id_penjualan_seq OWNER TO postgres;

--
-- TOC entry 3011 (class 0 OID 0)
-- Dependencies: 204
-- Name: penjualan_id_penjualan_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.penjualan_id_penjualan_seq OWNED BY public.penjualan.id_penjualan;


--
-- TOC entry 2863 (class 2604 OID 28316)
-- Name: barang id_barang; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.barang ALTER COLUMN id_barang SET DEFAULT nextval('public.barang_id_barang_seq'::regclass);


--
-- TOC entry 2864 (class 2604 OID 28324)
-- Name: detail_penjualan id_detail_penjualan; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_penjualan ALTER COLUMN id_detail_penjualan SET DEFAULT nextval('public.detail_penjualan_id_detail_penjualan_seq'::regclass);


--
-- TOC entry 2865 (class 2604 OID 28332)
-- Name: penjualan id_penjualan; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.penjualan ALTER COLUMN id_penjualan SET DEFAULT nextval('public.penjualan_id_penjualan_seq'::regclass);


--
-- TOC entry 2867 (class 2606 OID 28318)
-- Name: barang barang_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.barang
    ADD CONSTRAINT barang_pkey PRIMARY KEY (id_barang);


--
-- TOC entry 2869 (class 2606 OID 28326)
-- Name: detail_penjualan detail_penjualan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_penjualan
    ADD CONSTRAINT detail_penjualan_pkey PRIMARY KEY (id_detail_penjualan);


--
-- TOC entry 2871 (class 2606 OID 28337)
-- Name: penjualan penjualan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.penjualan
    ADD CONSTRAINT penjualan_pkey PRIMARY KEY (id_penjualan);


--
-- TOC entry 2872 (class 2606 OID 28338)
-- Name: detail_penjualan fkf5ajk00x01xcgls7hgx4ve6tj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detail_penjualan
    ADD CONSTRAINT fkf5ajk00x01xcgls7hgx4ve6tj FOREIGN KEY (penjualan_id) REFERENCES public.penjualan(id_penjualan);


--
-- TOC entry 2873 (class 2606 OID 28343)
-- Name: penjualan fkqw82a5cpf7jgr5ha9hobepri3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.penjualan
    ADD CONSTRAINT fkqw82a5cpf7jgr5ha9hobepri3 FOREIGN KEY (barang_id) REFERENCES public.barang(id_barang);


-- Completed on 2021-12-19 20:46:23

--
-- PostgreSQL database dump complete
--

