lexer grammar  Lexerp;
INCLUDE:
SEA_WS* '@include' SEA_WS*
;
VALIDATION: SEA_WS*'validation' SEA_WS*;
LINK:
'link'
 ;
 DATA:
 'data'
  ;
  ELSEIF1:'else';
  ELSE11:'else' SEA_WS*;
  GOTO_OPEN
  :
  TAG_WHITESPACE*  'goto'  TAG_WHITESPACE*  ->pushMode(GOTO)
  ;
  SWITCH_OPENP
  :
'@switch'TAG_WHITESPACE*'('->pushMode(SWITCH)
  ;
SWITCH_OPENC
  :
'switch'TAG_WHITESPACE*'('->pushMode(SWITCH)
  ;

CASE:
 TAG_WHITESPACE* 'case'TAG_WHITESPACE*':' TAG_WHITESPACE*
;
PREAK:
 TAG_WHITESPACE*'break'TAG_WHITESPACE* CLOSE TAG_WHITESPACE*
;

ENDSWITCH: TAG_WHITESPACE* 'endswitch' TAG_WHITESPACE*;
CONTROLLER:
TAG_WHITESPACE* 'controller' SEA_WS*
;
TO:TAG_WHITESPACE* '->'TAG_WHITESPACE* 'val'TAG_WHITESPACE*->pushMode(ARROW);
REQUIREDV:TAG_WHITESPACE* 'required' TAG_WHITESPACE*;
STRINGV:TAG_WHITESPACE* 'string' TAG_WHITESPACE*;
EMAILV:TAG_WHITESPACE* 'email' TAG_WHITESPACE*;
MINV:TAG_WHITESPACE* 'min' TAG_WHITESPACE*;
MAXV:TAG_WHITESPACE* 'max' TAG_WHITESPACE*;
OR:TAG_WHITESPACE* '|' TAG_WHITESPACE*;
OR1:TAG_WHITESPACE* '|' TAG_WHITESPACE*;
CONTROLS:
'controls'SEA_WS*->pushMode(CN)
;
PAGE:
 TAG_WHITESPACE* 'page'SEA_WS*
;
EXTENDS:
'extends'SEA_WS*
;
HEADER:
'header'SEA_WS*
;

PRINTNAME:TAG_WHITESPACE*'print'TAG_WHITESPACE*;


REQUEST:
TAG_WHITESPACE*'request'TAG_WHITESPACE*
;
GO:
'->'TAG_WHITESPACE*
;
IFNAME:TAG_WHITESPACE*'if'TAG_WHITESPACE*;

PR:
REQUEST GO TAG_NAME
;

EQUAL:
' '*'=' ' '*
;
OPENBRACKET:
TAG_WHITESPACE* '{' TAG_WHITESPACE*
;
CLOSEBRACKET:
TAG_WHITESPACE* '}' TAG_WHITESPACE*
;
OPENC:
 TAG_WHITESPACE* '(' TAG_WHITESPACE*
 ;
CLOSEC:
TAG_WHITESPACE*')' TAG_WHITESPACE*
;
STRINGARR:
TAG_WHITESPACE*'"' .*? '"'TAG_WHITESPACE*
;
VALID:TAG_WHITESPACE*'=>'TAG_WHITESPACE*;
NUM:DIGIT;
NUM1:DIGIT;
HTML_COMMENT
    : '<!--' .*? '-->'
    ;
CLOSE:
TAG_WHITESPACE*';'TAG_WHITESPACE*
;
COMMA:
SEA_WS*','SEA_WS*
;
SWAN:'\n'
;

SEA_WS
    :  (' '|'\t'|'\r'? '\n')+
    ;

TAG_WHITESPACE
    : [ \t\r\n] -> channel(HIDDEN)
    ;
SINGLE_QOUTE:TAG_WHITESPACE* '\\'TAG_WHITESPACE*;
TAG_NAME
    : TAG_WHITESPACE* TAG_NameStartChar TAG_NameChar*  TAG_WHITESPACE*
    ;

fragment
HEXDIGIT
    : [a-fA-F0-9]
    ;

fragment
DIGIT
    : [0-9]
    ;

fragment
TAG_NameChar
    : TAG_NameStartChar
    | '-'
    | '_'
    | '.'
    | DIGIT
    | '\u00B7'
    | '\u0300'..'\u036F'
    | '\u203F'..'\u2040'
    ;

fragment
TAG_NameStartChar
    : [a-zA-Z]
    | '\u2070'..'\u218F'
    | '\u2C00'..'\u2FEF'
    | '\u3001'..'\uD7FF'
    | '\uF900'..'\uFDCF'
    | '\uFDF0'..'\uFFFD'
    ;


 IF_OPENC
        :IFNAME'('->pushMode(IF)
        ;
 IF_OPENP
        :'@' IFNAME'('->pushMode(IF)
        ;
 FOR_OPENC
         :'for'TAG_WHITESPACE*'('->pushMode(FOR_M)
         ;
  FOR_OPENP
          :'@for'TAG_WHITESPACE*'('->pushMode(FOR_M)
          ;
 ARRAY_OPEN
             :TAG_WHITESPACE*'array'TAG_WHITESPACE*'['->pushMode(ARRAY)
             ;

FOREACHC_OPEN
:
'foreach'TAG_WHITESPACE*'('->pushMode(FOREACH_M)
;
FOREACHP_OPEN
:
'foreach'TAG_WHITESPACE*'('->pushMode(FOREACH_M)
;

PRINT_OPEN
:
PRINTNAME TAG_WHITESPACE*'('TAG_WHITESPACE*->pushMode(PRINT_M)
;

VAREQUAL_OPEN
:
 TAG_WHITESPACE*'$'TAG_WHITESPACE*->pushMode(VAREQUAL)
;

IN_OPEN
:
 TAG_WHITESPACE*('in') TAG_WHITESPACE*':'TAG_WHITESPACE*->pushMode(IN)
;

OUT_OPEN
:
 TAG_WHITESPACE*('out') TAG_WHITESPACE*':'TAG_WHITESPACE*->pushMode(OUT)
;


mode GOTO;
GOTON:TAG_NAME;
GOTOP:TAG_WHITESPACE*'('TAG_WHITESPACE*;
GOTOC:TAG_WHITESPACE*')'TAG_WHITESPACE*;
GOTOVAR:TAG_WHITESPACE* VAAR TAG_WHITESPACE*;
GOTOCOMMA:TAG_WHITESPACE* ','TAG_WHITESPACE*;
GOTO_CLOSE:
      TAG_WHITESPACE*  ';'    TAG_WHITESPACE*-> popMode
        ;
mode OUT;
TEXT:TAG_WHITESPACE*'text'TAG_WHITESPACE*;
IMAGEOUT:TAG_WHITESPACE*'image'TAG_WHITESPACE*;
OPENPOUT: TAG_WHITESPACE*'('TAG_WHITESPACE*;
CLOSEPOUT:TAG_WHITESPACE* ')'TAG_WHITESPACE*;
NOUT:TAG_NAME;
PATHOUT :  TAG_WHITESPACE*(TAG_NAME ':' (SINGLE_QOUTE (TAG_NAME|(TAG_NAME SINGLE_QOUTE))*)?TAG_WHITESPACE*)TAG_WHITESPACE*;
COMMAMOUT:',';
TOOUT:TO;
OUT_CLOSE:
      TAG_WHITESPACE*  ';'    TAG_WHITESPACE*-> popMode
        ;
AA:TAG_WHITESPACE* '@';

mode IN;
NUMBER:'number';
FILE:'file';
IMAGEIN:'image';
EMAIL:'email';
COLOR:'color';

NUAMIN:TAG_WHITESPACE*
('field'|'radio'| 'checkbox' |'password'|'text'
)TAG_WHITESPACE*
;
NU:  DIGIT+ (COMMA DIGIT+ )* ;
OPENP: '('TAG_WHITESPACE*;
CLOSEP:TAG_WHITESPACE* ')'TAG_WHITESPACE*;
TOIN:TO;
N:TAG_NAME;
PATH : TAG_WHITESPACE*(TAG_NAME ':' (SINGLE_QOUTE (TAG_NAME|(TAG_NAME SINGLE_QOUTE))*)?TAG_WHITESPACE*)TAG_WHITESPACE*;
H:HEXDIGIT;
COMMAM:COMMA-> pushMode(NAWAR);
E : TAG_NAME '@' TAG_NAME+ '.' TAG_NAME+ TAG_WHITESPACE*;
IN_CLOSE:
      TAG_WHITESPACE*  ';'TAG_WHITESPACE* -> popMode
        ;

BODY_CLOSE:
        TAG_WHITESPACE*'}' -> popMode
        ;
////controller mode
mode FOREACH_M;
VAREACH:VAAR;
BDYFOREACH: TAG_WHITESPACE* 'as'TAG_WHITESPACE* ;
FOREACHN:TAG_NAME;
FOREACH_CLOSE:
        TAG_WHITESPACE*')' -> popMode
        ;
mode FOR_M;
BDYFOR: TAG_WHITESPACE* 'in' TAG_WHITESPACE* ;
FORNA:TAG_NAME;
VARF:VAAR;

FOR_CLOSE:
        TAG_WHITESPACE*')' -> popMode
        ;
mode SWITCH;
PRSWITCH:PR ;
VARSWITCH:VAAR;
TN:TAG_NAME;
SWITCH_CLOSEC:
       TAG_WHITESPACE* ')'TAG_WHITESPACE*  -> popMode
        ;

SWITCH_CLOSEP:
        TAG_WHITESPACE* '@endswitch' TAG_WHITESPACE*-> popMode
        ;
mode VAREQUAL;

OPENARRV:
  TAG_WHITESPACE*'array'TAG_WHITESPACE*'['->pushMode(ARRAY)
;
NUME:DIGIT;
FUNCTIONE:FUNCTON
;
EQUALVAR: TAG_WHITESPACE*'=' TAG_WHITESPACE*;
W:TAG_WHITESPACE;
STRINGG:TAG_NAME;
ST:STRINGARR;
VAREQUAL_CLOSE:
     TAG_WHITESPACE*   CLOSE -> popMode
        ;

mode PRINT_M;
STRINGP:'"' .*? '"';
NUMP:DIGIT;
VARP:SEA_WS* '$'TAG_NAME;
PRP:REQUEST GO TAG_NAME;
F:FUNCTON;
PRINT_CLOSE:
        TAG_WHITESPACE*')' -> popMode
        ;

mode ARRAY;
NUMarr:TAG_WHITESPACE* DIGIT+ TAG_WHITESPACE*;
COMMAARR:SEA_WS*','SEA_WS*->pushMode(STARR)
         ;
STRINGARR1:STRINGARR;
VARARR:VAAR;
ARRN:TAG_NAME;
 ARRAY_CLOSE:
        TAG_WHITESPACE*']' -> popMode
        ;


   //////if mode
mode FUNCTION;

 FUNCTION_CLOSE:
        TAG_WHITESPACE*')' -> popMode
        ;

mode IF;
//valid(name1,name2,...)
ELSEIF:'else';
ELSE:'else' SEA_WS*;
/*CHECKED:'checked' TAG_WHITESPACE*'('TAG_NAME  ')';
//requirde(name) must be there
REQUIRDE:'requirde' TAG_WHITESPACE*'('TAG_NAME  ')';
///novalied
NOVALIED:'novalied';
VALIDMM:'valeid('TAG_WHITESPACE* DIGIT TAG_WHITESPACE* COMMA TAG_WHITESPACE* DIGIT+ TAG_WHITESPACE* COMMA TAG_WHITESPACE* DIGIT+ TAG_WHITESPACE*')';
VALIEDPASSDIGIT:'valpasswordmm''(' TAG_NAME COMMA TAG_WHITESPACE* DIGIT+ TAG_WHITESPACE* COMMA TAG_WHITESPACE* DIGIT+ TAG_WHITESPACE*')';
VALIEDPASSinputmode:'valpasswordinmode'TAG_WHITESPACE*'(' TAG_NAME COMMA TAG_NAME ')';
VALIDEMAIL: 'valemail' TAG_WHITESPACE*'(' TAG_NAME')';
*/
FIF:
FUNCTON
;
REQ:PR;
STR:STRINGARR;
VAREQ:EQUAL ;
VIF:VAAR ;
IFN:TAG_NAME;
TAG_OPERATOR
:'<' TAG_WHITESPACE* DIGIT+
|'>' TAG_WHITESPACE* DIGIT+
|'='TAG_WHITESPACE* DIGIT+
|'<='TAG_WHITESPACE* DIGIT+
|'>='TAG_WHITESPACE* DIGIT+
;
   IF_CLOSE:
    TAG_WHITESPACE*    ')' TAG_WHITESPACE*-> popMode
        ;
VAAR:    TAG_WHITESPACE* '$'    TAG_WHITESPACE*;

FUNCTON:
TAG_NAME OPENC (((VAAR IFN)|DIGIT+) (COMMA  ((VAAR IFN)|DIGIT+))* )* CLOSEC
;


mode ARROW;

COMMA1:
SEA_WS*','SEA_WS*
;
OPENC1:
 TAG_WHITESPACE* '(' TAG_WHITESPACE*
 ;
 TAG_NAME1
        : TAG_WHITESPACE* TAG_NameStartChar TAG_NameChar*  TAG_WHITESPACE*
        ;
TAG_NAME2
    : TAG_WHITESPACE* TAG_NameStartChar TAG_NameChar*  TAG_WHITESPACE*
    ;
    CLOSEC1:
    TAG_WHITESPACE*')' TAG_WHITESPACE*->popMode
    ;

mode CN;
COMMA4:
SEA_WS*','SEA_WS*->pushMode(CN1)
;

TAG_NAME4
        : TAG_WHITESPACE* TAG_NameStartChar TAG_NameChar*  TAG_WHITESPACE*
        ;

OPENBRACKET4:
TAG_WHITESPACE* '{' TAG_WHITESPACE*->popMode
;
mode CN1;
TAG_NAME5
            : TAG_WHITESPACE* TAG_NameStartChar TAG_NameChar*  TAG_WHITESPACE*->popMode
            ;

mode STARR;
VARARR1:TAG_WHITESPACE* '$'    TAG_WHITESPACE*;
NUMarr1:TAG_WHITESPACE* DIGIT+ TAG_WHITESPACE*->popMode;
STRINGARR2:TAG_WHITESPACE*'"' .*? '"'TAG_WHITESPACE*->popMode
           ;
ARRN1: TAG_WHITESPACE* TAG_NameStartChar TAG_NameChar*  TAG_WHITESPACE*->popMode
         ;

mode NAWAR;
N1:TAG_NAME ->popMode;


