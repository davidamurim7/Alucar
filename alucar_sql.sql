PGDMP     9    &                y         	   bd_alucar    13.1    13.1     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16641 	   bd_alucar    DATABASE     i   CREATE DATABASE bd_alucar WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE bd_alucar;
                postgres    false            ?            1259    16644    tb_marca    TABLE     ?   CREATE TABLE public.tb_marca (
    id_marca integer NOT NULL,
    nome_marca character varying(20) NOT NULL,
    descricao_marca character varying(50) NOT NULL
);
    DROP TABLE public.tb_marca;
       public         heap    postgres    false            ?            1259    16642    tb_marca_id_marca_seq    SEQUENCE     ?   CREATE SEQUENCE public.tb_marca_id_marca_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.tb_marca_id_marca_seq;
       public          postgres    false    201            ?           0    0    tb_marca_id_marca_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.tb_marca_id_marca_seq OWNED BY public.tb_marca.id_marca;
          public          postgres    false    200            "           2604    16647    tb_marca id_marca    DEFAULT     v   ALTER TABLE ONLY public.tb_marca ALTER COLUMN id_marca SET DEFAULT nextval('public.tb_marca_id_marca_seq'::regclass);
 @   ALTER TABLE public.tb_marca ALTER COLUMN id_marca DROP DEFAULT;
       public          postgres    false    200    201    201            ?          0    16644    tb_marca 
   TABLE DATA           I   COPY public.tb_marca (id_marca, nome_marca, descricao_marca) FROM stdin;
    public          postgres    false    201   ?
       ?           0    0    tb_marca_id_marca_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.tb_marca_id_marca_seq', 2, true);
          public          postgres    false    200            $           2606    16649    tb_marca tb_marca_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tb_marca
    ADD CONSTRAINT tb_marca_pkey PRIMARY KEY (id_marca);
 @   ALTER TABLE ONLY public.tb_marca DROP CONSTRAINT tb_marca_pkey;
       public            postgres    false    201            ?   A   x?3?t?L,??W???+.)?WHI,VH??.#ΐ????D(?px?BR~?BJjnbf1W? ԉ?     