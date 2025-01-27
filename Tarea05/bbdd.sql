PGDMP                         z           postgres    14.2    14.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            	           1262    13754    postgres    DATABASE     d   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE postgres;
                postgres    false            
           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3337                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false                       0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            >           1247    32909 	   fidelidad    TYPE     O   CREATE TYPE public.fidelidad AS ENUM (
    'ORO',
    'PLATA',
    'BRONCE'
);
    DROP TYPE public.fidelidad;
       public          postgres    false            ;           1247    32907    tlf    TYPE     \   CREATE TYPE public.tlf AS (
	tlfpri character varying(50),
	tlfsec character varying(50)
);
    DROP TYPE public.tlf;
       public          postgres    false            �            1255    32933 8   direccion(character varying, character varying, integer)    FUNCTION     �   CREATE FUNCTION public.direccion(character varying, character varying, integer) RETURNS text
    LANGUAGE sql
    AS $_$  SELECT  'La dirección de la empresa '|| $1 || ' es '|| $2 || ' numero '|| $3 ;
$_$;
 O   DROP FUNCTION public.direccion(character varying, character varying, integer);
       public          postgres    false            �            1259    41036    actor    TABLE     �   CREATE TABLE public.actor (
    nombre character varying(50) NOT NULL,
    nacionalidad character varying(50),
    fechanacimiento integer
);
    DROP TABLE public.actor;
       public         heap    postgres    false            �            1259    32915 
   empcliente    TABLE     �   CREATE TABLE public.empcliente (
    codemp integer NOT NULL,
    nombre character varying(50) NOT NULL,
    telefono public.tlf,
    calle character varying(50),
    num integer,
    fidel public.fidelidad
);
    DROP TABLE public.empcliente;
       public         heap    postgres    false    830    827            �            1259    32924    empproveedor    TABLE     �   CREATE TABLE public.empproveedor (
    codemp integer NOT NULL,
    nombre character varying(50) NOT NULL,
    telefono public.tlf,
    calle character varying(50),
    num integer,
    producto text
);
     DROP TABLE public.empproveedor;
       public         heap    postgres    false    827                      0    41036    actor 
   TABLE DATA           F   COPY public.actor (nombre, nacionalidad, fechanacimiento) FROM stdin;
    public          postgres    false    213   j                 0    32915 
   empcliente 
   TABLE DATA           Q   COPY public.empcliente (codemp, nombre, telefono, calle, num, fidel) FROM stdin;
    public          postgres    false    211   �                 0    32924    empproveedor 
   TABLE DATA           V   COPY public.empproveedor (codemp, nombre, telefono, calle, num, producto) FROM stdin;
    public          postgres    false    212   ^       u           2606    41040    actor actor_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.actor
    ADD CONSTRAINT actor_pkey PRIMARY KEY (nombre);
 :   ALTER TABLE ONLY public.actor DROP CONSTRAINT actor_pkey;
       public            postgres    false    213            m           2606    32923     empcliente empcliente_nombre_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.empcliente
    ADD CONSTRAINT empcliente_nombre_key UNIQUE (nombre);
 J   ALTER TABLE ONLY public.empcliente DROP CONSTRAINT empcliente_nombre_key;
       public            postgres    false    211            o           2606    32921    empcliente empcliente_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.empcliente
    ADD CONSTRAINT empcliente_pkey PRIMARY KEY (codemp);
 D   ALTER TABLE ONLY public.empcliente DROP CONSTRAINT empcliente_pkey;
       public            postgres    false    211            q           2606    32932 $   empproveedor empproveedor_nombre_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.empproveedor
    ADD CONSTRAINT empproveedor_nombre_key UNIQUE (nombre);
 N   ALTER TABLE ONLY public.empproveedor DROP CONSTRAINT empproveedor_nombre_key;
       public            postgres    false    212            s           2606    32930    empproveedor empproveedor_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.empproveedor
    ADD CONSTRAINT empproveedor_pkey PRIMARY KEY (codemp);
 H   ALTER TABLE ONLY public.empproveedor DROP CONSTRAINT empproveedor_pkey;
       public            postgres    false    212                  x�HM)��t���K�4��4����� L�x         �   x�Mͽ
�0@���)�S���MnF+v�FT�\R[�P[l���k���}�C1��uQ�t��v]�DA�&�3�H��BM��Q���;�Y�r������Vi-H�&��2��Ƕ�5� �3�?�w�A��Y*�[�Na?\��:H���Z@�ǟ.�e��%RE�~�.:�}�T]���i�{�_>�         �   x�=�1�0����+J'E�\L�Y�E���r`�JM ���z�Z���>|��s8����>��.k|,,��RU������[�ο	��g�yr�I��!ZS��D��Em�Vɺ�(g�������RM�����6����jJ�Bط������ᆺ����d�}x!@D     