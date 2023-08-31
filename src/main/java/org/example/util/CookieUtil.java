package org.example.util;

import org.example.dto.position.PositionDTO;

public class CookieUtil {
    public static final String FROM_EMAIL = "taras.kushmyruk@epam.com";
    public static final String MAIL_SUBJECT = "Opportunities" ;
    public static String cookieTest ="_hjSessionUser_1638007=eyJpZCI6IjhjYzU1NzM0LWNhYWItNTMxZi05MWM5LTdjOTk4M2FmN2M1MSIsImNyZWF0ZWQiOjE2ODA2MTQ0NDQwMTcsImV4aXN0aW5nIjp0cnVlfQ==; _hjSessionUser_3178737=eyJpZCI6IjU0MThkNDg5LTU5ZWYtNTFhYS04MjA0LWI5ODUxMTg4MzZiNSIsImNyZWF0ZWQiOjE2ODc1MTk0MDUxMzAsImV4aXN0aW5nIjpmYWxzZX0=; _gcl_au=1.1.2099571392.1687773406; _uetvid=c2ef5640140711eebe4a3333154e9435; _mkto_trk=id:030-GZP-996&token:_mch-epam.com-1687773406306-66869; _ga_EYGYLWSTX2=GS1.1.1687944310.2.0.1687944310.60.0.0; _ga_SL8BJVGM3Y=GS1.1.1688645033.1.0.1688645033.60.0.0; _ga_93QK6GV0YH=GS1.1.1689941347.11.0.1689941348.0.0.0; _ga_QKL78T20SX=GS1.1.1689941347.12.1.1689941350.0.0.0; _ga_W1T3XZ3Z92=GS1.1.1690830183.25.0.1690830183.0.0.0; _ga_WBGDS7S6W6=GS1.1.1690830183.25.0.1690830184.59.0.0; _ga_7BL0YYR4HF=GS1.1.1690830184.24.0.1690830184.0.0.0; _ga_YEZPFNFWCW=GS1.2.1690883449.16.1.1690883466.0.0.0; amp_b11780=hQpn7RGZ1yeSJ83uy0Mkus.MENFRTU1RTkwREY2NTg0NEUzOTJFOTMyM0YwMURCRUFDOEVBQzMyOTU5RDA2NEJEMUIzRkNERUUzODM5RTNCNw==..1h6qlnt0t.1h6qlnvdt.r.0.r; _ga_BRWYXPQZ3C=GS1.1.1690972267.15.1.1690973491.0.0.0; _ga_BLQDLWJP23=GS1.1.1690972001.7.1.1690973492.0.0.0; _ga_R07PD53LNK=GS1.1.1690973508.2.0.1690973508.0.0.0; amp_35f65f=Xf9CNmtfxr2o6YWbPGWbY6.MGNlZTU1ZTkwZGY2NTg0NGUzOTJlOTMyM2YwMWRiZWFjOGVhYzMyOTU5ZDA2NGJkMWIzZmNkZWUzODM5ZTNiNw==..1h6r0ibjh.1h6r0ibtk.1.0.1; _ga_2JM48LP5QW=GS1.1.1691068203.4.0.1691068203.0.0.0; _ga_DQTQ4N5Y8Q=GS1.1.1691068203.3.0.1691068203.0.0.0; _ga_ELW640PTRM=GS1.1.1691068203.3.0.1691068203.0.0.0; _ga_S3VMY5TGJT=GS1.1.1691570695.20.1.1691570848.0.0.0; just_after_login=1; _hjHasCachedUserAttributes=true; amp_4ee2eb=oSvQ5aFCjr0f4VCu_cdbOo...1h7pu2nc4.1h7pu2nc7.6.6.c; _ga_DDNBLYBLTY=GS1.2.1692112547.29.0.1692112550.0.0.0; amp_aa3ab3=Jt0c0BAx1Fl_RDuBun9sxN.MENFRTU1RTkwREY2NTg0NEUzOTJFOTMyM0YwMURCRUFDOEVBQzMyOTU5RDA2NEJEMUIzRkNERUUzODM5RTNCNw==..1h7ss8rbj.1h7ss8uia.58.0.58; AMP_MKTG_44bfb4cc30=JTdCJTdE; amplitude_id_97364965512571fbbed0820e6055bee7epam.com=eyJkZXZpY2VJZCI6IjZkYzY4ZjI3LWRmMzktNDZhYy04NjMzLTI0ZDdiOGY0MGJlY1IiLCJ1c2VySWQiOm51bGwsIm9wdE91dCI6ZmFsc2UsInNlc3Npb25JZCI6MTY5MjI4NjgyOTQ0MywibGFzdEV2ZW50VGltZSI6MTY5MjI4NzIzNjEwNiwiZXZlbnRJZCI6MTAsImlkZW50aWZ5SWQiOjAsInNlcXVlbmNlTnVtYmVyIjoxMH0=; AMP_44bfb4cc30=JTdCJTIyZGV2aWNlSWQlMjIlM0ElMjJkYzJiNDBjZi1hOWUwLTRmZDUtYmI1OC01NmQ2ZWU5N2Q5MDIlMjIlMkMlMjJ1c2VySWQlMjIlM0ElMjIwY2VlNTVlOTBkZjY1ODQ0ZTM5MmU5MzIzZjAxZGJlYWM4ZWFjMzI5NTlkMDY0YmQxYjNmY2RlZTM4MzllM2I3JTIyJTJDJTIyc2Vzc2lvbklkJTIyJTNBMTY5MjI4Njc4OTQxMiUyQyUyMm9wdE91dCUyMiUzQWZhbHNlJTJDJTIybGFzdEV2ZW50VGltZSUyMiUzQTE2OTIyODgwMzY0MjIlMkMlMjJsYXN0RXZlbnRJZCUyMiUzQTIwJTdE; _ga_ZMJYZTWTVJ=GS1.1.1692689524.81.1.1692689528.0.0.0; _ga_PZLN70KVX8=GS1.1.1692689533.7.1.1692689533.0.0.0; _ga_R362KM4BZ0=GS1.1.1692689543.5.0.1692689543.0.0.0; access-token=eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIyUnRENVJLbGEyMVRIckdqT2FyOE52NFJOaExpS2g4OTIxa0NxVEg1NmtvIn0.eyJleHAiOjE2OTI3MTg0NTAsImlhdCI6MTY5MjY4OTY1MCwiYXV0aF90aW1lIjoxNjkyNjg5NjUwLCJqdGkiOiJhNjNiYmJiNS1mYWIxLTRmNWYtOTBlYi1jN2MxYjFlNWFlODgiLCJpc3MiOiJodHRwczovL2FjY2Vzcy5lcGFtLmNvbS9hdXRoL3JlYWxtcy9wbHVzeCIsInN1YiI6ImY6MzA4OGZlODUtNWEzZC00N2E4LWEwNWMtZjBmYzI1YWY3NGUxOjg3NjAwMDAwMDAwMDAyMTM3MTEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJvYXV0aC1jbGllbnQuZXBtLXNyZHIuc3RhZmZpbmctcmFkYXIiLCJzZXNzaW9uX3N0YXRlIjoiYWFjYjU5YmEtNTNlOS00MmMzLTgxZTAtZDkzOTVhY2NiMTFiIiwic2NvcGUiOiJiYXNpYyBvaWRjQ29tbW9uRmVkZXJhdGlvbiIsInNpZCI6ImFhY2I1OWJhLTUzZTktNDJjMy04MWUwLWQ5Mzk1YWNjYjExYiIsImNvdW50cnkiOiJVa3JhaW5lIiwiQ29tcGFueSI6IkVQQU0gU3lzdGVtcywgSW5jLiIsImh0dHA6Ly9lcGFtLmNvbS9jbGFpbXMvbGV2ZWwiOiJTb2Z0d2FyZSBFbmdpbmVlcmluZyBMZXZlbCAyIiwiaHR0cDovL2VwYW0uY29tL2NsYWltcy9wbWNpZCI6Ijg3NjAwMDAwMDAwMDAyMTM3MTEiLCJjb3VudHJ5Q29kZUFscGhhIjoiVUEiLCJnbG9iYWxfaWQiOiI4NzYwMDAwMDAwMDAwMjEzNzExIiwicHJlZmVycmVkX3VzZXJuYW1lIjoidGFyYXNfa3VzaG15cnVrQGVwYW0uY29tIiwiZ2l2ZW5fbmFtZSI6IlRhcmFzIiwidGl0bGUiOiJTb2Z0d2FyZSBFbmdpbmVlciIsInVwbiI6IlRhcmFzX0t1c2hteXJ1a0BlcGFtLmNvbSIsIlBoeXNpY2FsZGVsaXZlcnlvZmZpY2VuYW1lIjoiVWtyYWluZVxcS3lpdlxcU2ltaSBQcmFraG92eWtoIDU0IiwidW5pcXVlX25hbWUiOiJUYXJhcyBLdXNobXlydWsiLCJjb21tb25uYW1lIjoiVGFyYXMgS3VzaG15cnVrIiwibG9jYXRpb24iOiJLeWl2IiwiZmFtaWx5X25hbWUiOiJLdXNobXlydWsiLCJlbWFpbCI6IlRhcmFzX0t1c2hteXJ1a0BlcGFtLmNvbSJ9.FvS4OtoE9lVu4owRwhP4BNZIKK8yKSu5sN0C9i5GGKLI2vtXt8poluwDRmw1oELli0HbwIdYsA0xVPOOjxzHe8tix2n5wnezcZ1-mS4C3JC-cGvFLhKBUrEGg-ASYflJFaoW_GsfKn78UG7AKLCybBGkCy8VyiudeGGBA74zU5COMWDgIS4lDvhIrYZbZhcRcvVN1ZUPGlOLc8jcjmqZ9-humynoNQSPGP4QfRFfxHp2eKgHNxhrQCv7daBkMjrsJjZ_rInDLntMIpgMuLKenJZKtQHnCuAWH-q0-0y9F2Mkni8BLhduOOieTwbGQaw-Q9gOeoHgLTTWV4ZDqvEX-w; refresh-token=eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJlNWQ1ZWJmYy1hYWE3LTRkZTItYWYxMC1jYTM0NDc5NzczYWQifQ.eyJleHAiOjE2OTI3MTg0NTAsImlhdCI6MTY5MjY4OTY1MCwianRpIjoiMzhhZGYzN2UtNDVkNC00ZDFkLTlmYmEtZGY4OWFkM2I3ZmI4IiwiaXNzIjoiaHR0cHM6Ly9hY2Nlc3MuZXBhbS5jb20vYXV0aC9yZWFsbXMvcGx1c3giLCJhdWQiOiJodHRwczovL2FjY2Vzcy5lcGFtLmNvbS9hdXRoL3JlYWxtcy9wbHVzeCIsInN1YiI6ImY6MzA4OGZlODUtNWEzZC00N2E4LWEwNWMtZjBmYzI1YWY3NGUxOjg3NjAwMDAwMDAwMDAyMTM3MTEiLCJ0eXAiOiJSZWZyZXNoIiwiYXpwIjoib2F1dGgtY2xpZW50LmVwbS1zcmRyLnN0YWZmaW5nLXJhZGFyIiwic2Vzc2lvbl9zdGF0ZSI6ImFhY2I1OWJhLTUzZTktNDJjMy04MWUwLWQ5Mzk1YWNjYjExYiIsInNjb3BlIjoiYmFzaWMgb2lkY0NvbW1vbkZlZGVyYXRpb24iLCJzaWQiOiJhYWNiNTliYS01M2U5LTQyYzMtODFlMC1kOTM5NWFjY2IxMWIifQ.lPHEUL3c62yC9eJ35SDMDiqXQGi2qxJpiQx6RXb2tws; ztna-verification-token=NdOuRZZu7q_2JurMGcqkaJvi88WP1qpbpiUdV-o3b7FBH-NA7n1HHJYSncxc1lekeev13gOyxrChGe0ZW-wqz1-mJzkaxg6tzn9w2P8ucMqsYimJVpWrZFxZpVAoagCNDycjejeKuwo5-FVWK7d_5oCVChosQC1qJHTQR-ks-L4vHNSxwsvNCZHJ; ztna-user=0c6fee3bc8f5ec6901e03594bff73cdf56fbb5ae91253900d4ff90f3d71af2f6; connect.sid=s%3A8760000000000213711%3A0f345232-5dcb-4713-923a-285bf982e7a7.pdQDIbc57SLhrgkSv1lH2Tm1UF79oE1iZID65cSFUJE; _gid=GA1.2.1721774506.1692689651; _gat_UA-12345-1=1; _hjIncludedInSessionSample_1638007=0; _hjSession_1638007=eyJpZCI6IjdkODdjNzFmLTI4MTUtNDk0Yi05MzRjLTExNTkxODZkMjE1OCIsImNyZWF0ZWQiOjE2OTI2ODk2NTA4ODIsImluU2FtcGxlIjpmYWxzZX0=; _hjAbsoluteSessionInProgress=0; _ga_YK1S0HFX1L=GS1.1.1692689543.16.1.1692689668.0.0.0; _ga_4KH6066E1W=GS1.1.1692689543.19.0.1692689668.0.0.0; _ga_GD6GJ1R3D3=GS1.1.1692689543.29.1.1692689668.0.0.0; _ga=GA1.2.8760000000000213711";
}