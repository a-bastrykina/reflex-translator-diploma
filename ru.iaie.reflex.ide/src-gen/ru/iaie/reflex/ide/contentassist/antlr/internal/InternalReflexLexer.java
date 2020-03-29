package ru.iaie.reflex.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReflexLexer extends Lexer {
    public static final int RULE_HEX=19;
    public static final int T__50=50;
    public static final int RULE_SIGN=28;
    public static final int RULE_DEC_SEQUENCE=26;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=18;
    public static final int RULE_HEX_FLOAT=25;
    public static final int RULE_INT_C_TYPE=5;
    public static final int RULE_INT=33;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=35;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__39=39;
    public static final int RULE_VOID_C_TYPE=15;
    public static final int RULE_HEX_SEQUENCE=30;
    public static final int RULE_UNSIGNED=23;
    public static final int RULE_DOUBLE_C_TYPE=17;
    public static final int RULE_BIN_EXPONENT=31;
    public static final int RULE_LOGICAL_AND=13;
    public static final int RULE_EXPONENT=27;
    public static final int T__48=48;
    public static final int RULE_DEC_FLOAT=24;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=9;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int RULE_BIT_AND=10;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int RULE_BOOL_TYPE=7;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_FLOAT_C_TYPE=16;
    public static final int RULE_OCTAL=20;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_SHORT_C_TYPE=4;
    public static final int RULE_DECIMAL=21;
    public static final int RULE_LOGICAL_OR=14;
    public static final int RULE_LONG_C_TYPE=6;
    public static final int RULE_FLOAT_SUFFIX=29;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=34;
    public static final int RULE_SL_COMMENT=36;
    public static final int RULE_HEX_PREFIX=32;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=37;
    public static final int RULE_ANY_OTHER=38;
    public static final int T__88=88;
    public static final int RULE_BIT_XOR=11;
    public static final int T__89=89;
    public static final int RULE_BIT_OR=12;
    public static final int RULE_LONG=22;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int RULE_INTEGER=8;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators

    public InternalReflexLexer() {;} 
    public InternalReflexLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalReflexLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalReflex.g"; }

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:11:7: ( 'input' )
            // InternalReflex.g:11:9: 'input'
            {
            match("input"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:12:7: ( 'output' )
            // InternalReflex.g:12:9: 'output'
            {
            match("output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:13:7: ( '++' )
            // InternalReflex.g:13:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:14:7: ( '--' )
            // InternalReflex.g:14:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:15:7: ( '=' )
            // InternalReflex.g:15:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:16:7: ( '*=' )
            // InternalReflex.g:16:9: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:17:7: ( '/=' )
            // InternalReflex.g:17:9: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:18:7: ( '+=' )
            // InternalReflex.g:18:9: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:19:7: ( '-=' )
            // InternalReflex.g:19:9: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:20:7: ( '<<=' )
            // InternalReflex.g:20:9: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:21:7: ( '>>=' )
            // InternalReflex.g:21:9: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:22:7: ( '&=' )
            // InternalReflex.g:22:9: '&='
            {
            match("&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:23:7: ( '^=' )
            // InternalReflex.g:23:9: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:24:7: ( '|=' )
            // InternalReflex.g:24:9: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:25:7: ( '+' )
            // InternalReflex.g:25:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:26:7: ( '-' )
            // InternalReflex.g:26:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:27:7: ( '~' )
            // InternalReflex.g:27:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:28:7: ( '!' )
            // InternalReflex.g:28:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:29:7: ( '<' )
            // InternalReflex.g:29:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:30:7: ( '>' )
            // InternalReflex.g:30:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:31:7: ( '=<' )
            // InternalReflex.g:31:9: '=<'
            {
            match("=<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:32:7: ( '>=' )
            // InternalReflex.g:32:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:33:7: ( '==' )
            // InternalReflex.g:33:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:34:7: ( '!=' )
            // InternalReflex.g:34:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:35:7: ( '>>' )
            // InternalReflex.g:35:9: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:36:7: ( '<<' )
            // InternalReflex.g:36:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:37:7: ( '*' )
            // InternalReflex.g:37:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:38:7: ( '/' )
            // InternalReflex.g:38:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:39:7: ( '%' )
            // InternalReflex.g:39:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:40:7: ( 'signed' )
            // InternalReflex.g:40:9: 'signed'
            {
            match("signed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:41:7: ( 'unsigned' )
            // InternalReflex.g:41:9: 'unsigned'
            {
            match("unsigned"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:42:7: ( 'program' )
            // InternalReflex.g:42:9: 'program'
            {
            match("program"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:43:7: ( '{' )
            // InternalReflex.g:43:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:44:7: ( '}' )
            // InternalReflex.g:44:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:45:7: ( 'proc' )
            // InternalReflex.g:45:9: 'proc'
            {
            match("proc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:46:7: ( ';' )
            // InternalReflex.g:46:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:47:7: ( 'from' )
            // InternalReflex.g:47:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:48:7: ( ',' )
            // InternalReflex.g:48:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:49:7: ( '[' )
            // InternalReflex.g:49:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:50:7: ( ']' )
            // InternalReflex.g:50:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:51:7: ( 'state' )
            // InternalReflex.g:51:9: 'state'
            {
            match("state"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:52:7: ( 'timeout' )
            // InternalReflex.g:52:9: 'timeout'
            {
            match("timeout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:53:7: ( 'if' )
            // InternalReflex.g:53:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:54:7: ( '(' )
            // InternalReflex.g:54:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:55:7: ( ')' )
            // InternalReflex.g:55:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:56:7: ( 'else' )
            // InternalReflex.g:56:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:57:7: ( 'switch' )
            // InternalReflex.g:57:9: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:58:7: ( 'case' )
            // InternalReflex.g:58:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:59:7: ( ':' )
            // InternalReflex.g:59:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:60:7: ( 'break' )
            // InternalReflex.g:60:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:61:7: ( 'start' )
            // InternalReflex.g:61:9: 'start'
            {
            match("start"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:62:7: ( 'stop' )
            // InternalReflex.g:62:9: 'stop'
            {
            match("stop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:63:7: ( 'error' )
            // InternalReflex.g:63:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:64:7: ( 'loop' )
            // InternalReflex.g:64:9: 'loop'
            {
            match("loop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:65:7: ( 'restart' )
            // InternalReflex.g:65:9: 'restart'
            {
            match("restart"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:66:7: ( 'reset' )
            // InternalReflex.g:66:9: 'reset'
            {
            match("reset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:67:7: ( 'set' )
            // InternalReflex.g:67:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:68:7: ( 'const' )
            // InternalReflex.g:68:9: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:69:7: ( 'enum' )
            // InternalReflex.g:69:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:70:7: ( 'tact' )
            // InternalReflex.g:70:9: 'tact'
            {
            match("tact"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:71:7: ( 'local' )
            // InternalReflex.g:71:9: 'local'
            {
            match("local"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:72:8: ( 'global' )
            // InternalReflex.g:72:10: 'global'
            {
            match("global"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:73:8: ( 'shared' )
            // InternalReflex.g:73:10: 'shared'
            {
            match("shared"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:74:8: ( 'next' )
            // InternalReflex.g:74:10: 'next'
            {
            match("next"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "RULE_LOGICAL_OR"
    public final void mRULE_LOGICAL_OR() throws RecognitionException {
        try {
            int _type = RULE_LOGICAL_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10053:17: ( '||' )
            // InternalReflex.g:10053:19: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LOGICAL_OR"

    // $ANTLR start "RULE_LOGICAL_AND"
    public final void mRULE_LOGICAL_AND() throws RecognitionException {
        try {
            int _type = RULE_LOGICAL_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10055:18: ( '&&' )
            // InternalReflex.g:10055:20: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LOGICAL_AND"

    // $ANTLR start "RULE_BIT_OR"
    public final void mRULE_BIT_OR() throws RecognitionException {
        try {
            int _type = RULE_BIT_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10057:13: ( '|' )
            // InternalReflex.g:10057:15: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIT_OR"

    // $ANTLR start "RULE_BIT_XOR"
    public final void mRULE_BIT_XOR() throws RecognitionException {
        try {
            int _type = RULE_BIT_XOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10059:14: ( '^' )
            // InternalReflex.g:10059:16: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIT_XOR"

    // $ANTLR start "RULE_BIT_AND"
    public final void mRULE_BIT_AND() throws RecognitionException {
        try {
            int _type = RULE_BIT_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10061:14: ( '&' )
            // InternalReflex.g:10061:16: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIT_AND"

    // $ANTLR start "RULE_VOID_C_TYPE"
    public final void mRULE_VOID_C_TYPE() throws RecognitionException {
        try {
            int _type = RULE_VOID_C_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10063:18: ( 'void' )
            // InternalReflex.g:10063:20: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VOID_C_TYPE"

    // $ANTLR start "RULE_FLOAT_C_TYPE"
    public final void mRULE_FLOAT_C_TYPE() throws RecognitionException {
        try {
            int _type = RULE_FLOAT_C_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10065:19: ( 'float' )
            // InternalReflex.g:10065:21: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT_C_TYPE"

    // $ANTLR start "RULE_DOUBLE_C_TYPE"
    public final void mRULE_DOUBLE_C_TYPE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_C_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10067:20: ( 'double' )
            // InternalReflex.g:10067:22: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE_C_TYPE"

    // $ANTLR start "RULE_SHORT_C_TYPE"
    public final void mRULE_SHORT_C_TYPE() throws RecognitionException {
        try {
            int _type = RULE_SHORT_C_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10069:19: ( 'short' )
            // InternalReflex.g:10069:21: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SHORT_C_TYPE"

    // $ANTLR start "RULE_INT_C_TYPE"
    public final void mRULE_INT_C_TYPE() throws RecognitionException {
        try {
            int _type = RULE_INT_C_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10071:17: ( 'int' )
            // InternalReflex.g:10071:19: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT_C_TYPE"

    // $ANTLR start "RULE_LONG_C_TYPE"
    public final void mRULE_LONG_C_TYPE() throws RecognitionException {
        try {
            int _type = RULE_LONG_C_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10073:18: ( 'long' )
            // InternalReflex.g:10073:20: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LONG_C_TYPE"

    // $ANTLR start "RULE_BOOL_TYPE"
    public final void mRULE_BOOL_TYPE() throws RecognitionException {
        try {
            int _type = RULE_BOOL_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10075:16: ( 'bool' )
            // InternalReflex.g:10075:18: 'bool'
            {
            match("bool"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOL_TYPE"

    // $ANTLR start "RULE_INTEGER"
    public final void mRULE_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10077:14: ( ( RULE_HEX | RULE_OCTAL | RULE_DECIMAL ) ( RULE_LONG | RULE_UNSIGNED )? )
            // InternalReflex.g:10077:16: ( RULE_HEX | RULE_OCTAL | RULE_DECIMAL ) ( RULE_LONG | RULE_UNSIGNED )?
            {
            // InternalReflex.g:10077:16: ( RULE_HEX | RULE_OCTAL | RULE_DECIMAL )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'X':
                case 'x':
                    {
                    alt1=1;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt1=2;
                    }
                    break;
                default:
                    alt1=3;}

            }
            else if ( ((LA1_0>='1' && LA1_0<='9')) ) {
                alt1=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalReflex.g:10077:17: RULE_HEX
                    {
                    mRULE_HEX(); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:10077:26: RULE_OCTAL
                    {
                    mRULE_OCTAL(); 

                    }
                    break;
                case 3 :
                    // InternalReflex.g:10077:37: RULE_DECIMAL
                    {
                    mRULE_DECIMAL(); 

                    }
                    break;

            }

            // InternalReflex.g:10077:51: ( RULE_LONG | RULE_UNSIGNED )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='U'||LA2_0=='l'||LA2_0=='u') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalReflex.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='U'||input.LA(1)=='l'||input.LA(1)=='u' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10079:12: ( ( RULE_DEC_FLOAT | RULE_HEX_FLOAT ) )
            // InternalReflex.g:10079:14: ( RULE_DEC_FLOAT | RULE_HEX_FLOAT )
            {
            // InternalReflex.g:10079:14: ( RULE_DEC_FLOAT | RULE_HEX_FLOAT )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalReflex.g:10079:15: RULE_DEC_FLOAT
                    {
                    mRULE_DEC_FLOAT(); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:10079:30: RULE_HEX_FLOAT
                    {
                    mRULE_HEX_FLOAT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_DEC_FLOAT"
    public final void mRULE_DEC_FLOAT() throws RecognitionException {
        try {
            // InternalReflex.g:10081:25: ( ( RULE_DEC_SEQUENCE )? '.' RULE_DEC_SEQUENCE ( RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )? )
            // InternalReflex.g:10081:27: ( RULE_DEC_SEQUENCE )? '.' RULE_DEC_SEQUENCE ( RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            {
            // InternalReflex.g:10081:27: ( RULE_DEC_SEQUENCE )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalReflex.g:10081:27: RULE_DEC_SEQUENCE
                    {
                    mRULE_DEC_SEQUENCE(); 

                    }
                    break;

            }

            match('.'); 
            mRULE_DEC_SEQUENCE(); 
            // InternalReflex.g:10081:68: ( RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='E'||LA5_0=='e') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalReflex.g:10081:69: RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE
                    {
                    mRULE_EXPONENT(); 
                    mRULE_SIGN(); 
                    mRULE_DEC_SEQUENCE(); 

                    }
                    break;

            }

            // InternalReflex.g:10081:113: ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='F'||LA6_0=='L'||LA6_0=='f'||LA6_0=='l') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalReflex.g:
                    {
                    if ( input.LA(1)=='F'||input.LA(1)=='L'||input.LA(1)=='f'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DEC_FLOAT"

    // $ANTLR start "RULE_HEX_FLOAT"
    public final void mRULE_HEX_FLOAT() throws RecognitionException {
        try {
            // InternalReflex.g:10083:25: ( ( RULE_HEX_SEQUENCE )? '.' RULE_HEX_SEQUENCE ( RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )? )
            // InternalReflex.g:10083:27: ( RULE_HEX_SEQUENCE )? '.' RULE_HEX_SEQUENCE ( RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            {
            // InternalReflex.g:10083:27: ( RULE_HEX_SEQUENCE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='F')||(LA7_0>='a' && LA7_0<='f')) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalReflex.g:10083:27: RULE_HEX_SEQUENCE
                    {
                    mRULE_HEX_SEQUENCE(); 

                    }
                    break;

            }

            match('.'); 
            mRULE_HEX_SEQUENCE(); 
            // InternalReflex.g:10083:68: ( RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='P'||LA8_0=='p') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalReflex.g:10083:69: RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE
                    {
                    mRULE_BIN_EXPONENT(); 
                    mRULE_SIGN(); 
                    mRULE_DEC_SEQUENCE(); 

                    }
                    break;

            }

            // InternalReflex.g:10083:117: ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='F'||LA9_0=='L'||LA9_0=='f'||LA9_0=='l') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalReflex.g:
                    {
                    if ( input.LA(1)=='F'||input.LA(1)=='L'||input.LA(1)=='f'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_FLOAT"

    // $ANTLR start "RULE_DEC_SEQUENCE"
    public final void mRULE_DEC_SEQUENCE() throws RecognitionException {
        try {
            // InternalReflex.g:10085:28: ( ( '0' .. '9' )+ )
            // InternalReflex.g:10085:30: ( '0' .. '9' )+
            {
            // InternalReflex.g:10085:30: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalReflex.g:10085:31: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DEC_SEQUENCE"

    // $ANTLR start "RULE_HEX_SEQUENCE"
    public final void mRULE_HEX_SEQUENCE() throws RecognitionException {
        try {
            // InternalReflex.g:10087:28: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalReflex.g:10087:30: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            // InternalReflex.g:10087:30: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='F')||(LA11_0>='a' && LA11_0<='f')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalReflex.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_SEQUENCE"

    // $ANTLR start "RULE_BIN_EXPONENT"
    public final void mRULE_BIN_EXPONENT() throws RecognitionException {
        try {
            // InternalReflex.g:10089:28: ( ( 'p' | 'P' ) )
            // InternalReflex.g:10089:30: ( 'p' | 'P' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIN_EXPONENT"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            // InternalReflex.g:10091:24: ( ( 'e' | 'E' ) )
            // InternalReflex.g:10091:26: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_SIGN"
    public final void mRULE_SIGN() throws RecognitionException {
        try {
            // InternalReflex.g:10093:20: ( ( '+' | '-' ) )
            // InternalReflex.g:10093:22: ( '+' | '-' )
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SIGN"

    // $ANTLR start "RULE_DECIMAL"
    public final void mRULE_DECIMAL() throws RecognitionException {
        try {
            // InternalReflex.g:10095:23: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) )
            // InternalReflex.g:10095:25: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            {
            // InternalReflex.g:10095:25: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='0') ) {
                alt13=1;
            }
            else if ( ((LA13_0>='1' && LA13_0<='9')) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalReflex.g:10095:26: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:10095:30: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // InternalReflex.g:10095:39: ( '0' .. '9' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalReflex.g:10095:40: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECIMAL"

    // $ANTLR start "RULE_OCTAL"
    public final void mRULE_OCTAL() throws RecognitionException {
        try {
            // InternalReflex.g:10097:21: ( '0' ( '0' .. '7' )+ )
            // InternalReflex.g:10097:23: '0' ( '0' .. '7' )+
            {
            match('0'); 
            // InternalReflex.g:10097:27: ( '0' .. '7' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='7')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalReflex.g:10097:28: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCTAL"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            // InternalReflex.g:10099:19: ( RULE_HEX_PREFIX RULE_HEX_SEQUENCE )
            // InternalReflex.g:10099:21: RULE_HEX_PREFIX RULE_HEX_SEQUENCE
            {
            mRULE_HEX_PREFIX(); 
            mRULE_HEX_SEQUENCE(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_HEX_PREFIX"
    public final void mRULE_HEX_PREFIX() throws RecognitionException {
        try {
            // InternalReflex.g:10101:26: ( '0' ( 'x' | 'X' ) )
            // InternalReflex.g:10101:28: '0' ( 'x' | 'X' )
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_PREFIX"

    // $ANTLR start "RULE_LONG"
    public final void mRULE_LONG() throws RecognitionException {
        try {
            // InternalReflex.g:10103:20: ( ( 'L' | 'l' ) )
            // InternalReflex.g:10103:22: ( 'L' | 'l' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LONG"

    // $ANTLR start "RULE_FLOAT_SUFFIX"
    public final void mRULE_FLOAT_SUFFIX() throws RecognitionException {
        try {
            // InternalReflex.g:10105:28: ( ( 'F' | 'f' ) )
            // InternalReflex.g:10105:30: ( 'F' | 'f' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT_SUFFIX"

    // $ANTLR start "RULE_UNSIGNED"
    public final void mRULE_UNSIGNED() throws RecognitionException {
        try {
            // InternalReflex.g:10107:24: ( ( 'U' | 'u' ) )
            // InternalReflex.g:10107:26: ( 'U' | 'u' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNSIGNED"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10109:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalReflex.g:10109:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalReflex.g:10109:11: ( '^' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='^') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalReflex.g:10109:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalReflex.g:10109:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalReflex.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10111:10: ( ( '0' .. '9' )+ )
            // InternalReflex.g:10111:12: ( '0' .. '9' )+
            {
            // InternalReflex.g:10111:12: ( '0' .. '9' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalReflex.g:10111:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10113:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalReflex.g:10113:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalReflex.g:10113:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\"') ) {
                alt20=1;
            }
            else if ( (LA20_0=='\'') ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalReflex.g:10113:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalReflex.g:10113:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop18:
                    do {
                        int alt18=3;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='\\') ) {
                            alt18=1;
                        }
                        else if ( ((LA18_0>='\u0000' && LA18_0<='!')||(LA18_0>='#' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='\uFFFF')) ) {
                            alt18=2;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalReflex.g:10113:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:10113:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:10113:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalReflex.g:10113:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop19:
                    do {
                        int alt19=3;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='\\') ) {
                            alt19=1;
                        }
                        else if ( ((LA19_0>='\u0000' && LA19_0<='&')||(LA19_0>='(' && LA19_0<='[')||(LA19_0>=']' && LA19_0<='\uFFFF')) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalReflex.g:10113:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:10113:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10115:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalReflex.g:10115:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalReflex.g:10115:24: ( options {greedy=false; } : . )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='*') ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1=='/') ) {
                        alt21=2;
                    }
                    else if ( ((LA21_1>='\u0000' && LA21_1<='.')||(LA21_1>='0' && LA21_1<='\uFFFF')) ) {
                        alt21=1;
                    }


                }
                else if ( ((LA21_0>='\u0000' && LA21_0<=')')||(LA21_0>='+' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalReflex.g:10115:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10117:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalReflex.g:10117:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalReflex.g:10117:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='\u0000' && LA22_0<='\t')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalReflex.g:10117:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // InternalReflex.g:10117:40: ( ( '\\r' )? '\\n' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\n'||LA24_0=='\r') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalReflex.g:10117:41: ( '\\r' )? '\\n'
                    {
                    // InternalReflex.g:10117:41: ( '\\r' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='\r') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalReflex.g:10117:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10119:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalReflex.g:10119:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalReflex.g:10119:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='\t' && LA25_0<='\n')||LA25_0=='\r'||LA25_0==' ') ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalReflex.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10121:16: ( . )
            // InternalReflex.g:10121:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalReflex.g:1:8: ( T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | RULE_LOGICAL_OR | RULE_LOGICAL_AND | RULE_BIT_OR | RULE_BIT_XOR | RULE_BIT_AND | RULE_VOID_C_TYPE | RULE_FLOAT_C_TYPE | RULE_DOUBLE_C_TYPE | RULE_SHORT_C_TYPE | RULE_INT_C_TYPE | RULE_LONG_C_TYPE | RULE_BOOL_TYPE | RULE_INTEGER | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt26=85;
        alt26 = dfa26.predict(input);
        switch (alt26) {
            case 1 :
                // InternalReflex.g:1:10: T__39
                {
                mT__39(); 

                }
                break;
            case 2 :
                // InternalReflex.g:1:16: T__40
                {
                mT__40(); 

                }
                break;
            case 3 :
                // InternalReflex.g:1:22: T__41
                {
                mT__41(); 

                }
                break;
            case 4 :
                // InternalReflex.g:1:28: T__42
                {
                mT__42(); 

                }
                break;
            case 5 :
                // InternalReflex.g:1:34: T__43
                {
                mT__43(); 

                }
                break;
            case 6 :
                // InternalReflex.g:1:40: T__44
                {
                mT__44(); 

                }
                break;
            case 7 :
                // InternalReflex.g:1:46: T__45
                {
                mT__45(); 

                }
                break;
            case 8 :
                // InternalReflex.g:1:52: T__46
                {
                mT__46(); 

                }
                break;
            case 9 :
                // InternalReflex.g:1:58: T__47
                {
                mT__47(); 

                }
                break;
            case 10 :
                // InternalReflex.g:1:64: T__48
                {
                mT__48(); 

                }
                break;
            case 11 :
                // InternalReflex.g:1:70: T__49
                {
                mT__49(); 

                }
                break;
            case 12 :
                // InternalReflex.g:1:76: T__50
                {
                mT__50(); 

                }
                break;
            case 13 :
                // InternalReflex.g:1:82: T__51
                {
                mT__51(); 

                }
                break;
            case 14 :
                // InternalReflex.g:1:88: T__52
                {
                mT__52(); 

                }
                break;
            case 15 :
                // InternalReflex.g:1:94: T__53
                {
                mT__53(); 

                }
                break;
            case 16 :
                // InternalReflex.g:1:100: T__54
                {
                mT__54(); 

                }
                break;
            case 17 :
                // InternalReflex.g:1:106: T__55
                {
                mT__55(); 

                }
                break;
            case 18 :
                // InternalReflex.g:1:112: T__56
                {
                mT__56(); 

                }
                break;
            case 19 :
                // InternalReflex.g:1:118: T__57
                {
                mT__57(); 

                }
                break;
            case 20 :
                // InternalReflex.g:1:124: T__58
                {
                mT__58(); 

                }
                break;
            case 21 :
                // InternalReflex.g:1:130: T__59
                {
                mT__59(); 

                }
                break;
            case 22 :
                // InternalReflex.g:1:136: T__60
                {
                mT__60(); 

                }
                break;
            case 23 :
                // InternalReflex.g:1:142: T__61
                {
                mT__61(); 

                }
                break;
            case 24 :
                // InternalReflex.g:1:148: T__62
                {
                mT__62(); 

                }
                break;
            case 25 :
                // InternalReflex.g:1:154: T__63
                {
                mT__63(); 

                }
                break;
            case 26 :
                // InternalReflex.g:1:160: T__64
                {
                mT__64(); 

                }
                break;
            case 27 :
                // InternalReflex.g:1:166: T__65
                {
                mT__65(); 

                }
                break;
            case 28 :
                // InternalReflex.g:1:172: T__66
                {
                mT__66(); 

                }
                break;
            case 29 :
                // InternalReflex.g:1:178: T__67
                {
                mT__67(); 

                }
                break;
            case 30 :
                // InternalReflex.g:1:184: T__68
                {
                mT__68(); 

                }
                break;
            case 31 :
                // InternalReflex.g:1:190: T__69
                {
                mT__69(); 

                }
                break;
            case 32 :
                // InternalReflex.g:1:196: T__70
                {
                mT__70(); 

                }
                break;
            case 33 :
                // InternalReflex.g:1:202: T__71
                {
                mT__71(); 

                }
                break;
            case 34 :
                // InternalReflex.g:1:208: T__72
                {
                mT__72(); 

                }
                break;
            case 35 :
                // InternalReflex.g:1:214: T__73
                {
                mT__73(); 

                }
                break;
            case 36 :
                // InternalReflex.g:1:220: T__74
                {
                mT__74(); 

                }
                break;
            case 37 :
                // InternalReflex.g:1:226: T__75
                {
                mT__75(); 

                }
                break;
            case 38 :
                // InternalReflex.g:1:232: T__76
                {
                mT__76(); 

                }
                break;
            case 39 :
                // InternalReflex.g:1:238: T__77
                {
                mT__77(); 

                }
                break;
            case 40 :
                // InternalReflex.g:1:244: T__78
                {
                mT__78(); 

                }
                break;
            case 41 :
                // InternalReflex.g:1:250: T__79
                {
                mT__79(); 

                }
                break;
            case 42 :
                // InternalReflex.g:1:256: T__80
                {
                mT__80(); 

                }
                break;
            case 43 :
                // InternalReflex.g:1:262: T__81
                {
                mT__81(); 

                }
                break;
            case 44 :
                // InternalReflex.g:1:268: T__82
                {
                mT__82(); 

                }
                break;
            case 45 :
                // InternalReflex.g:1:274: T__83
                {
                mT__83(); 

                }
                break;
            case 46 :
                // InternalReflex.g:1:280: T__84
                {
                mT__84(); 

                }
                break;
            case 47 :
                // InternalReflex.g:1:286: T__85
                {
                mT__85(); 

                }
                break;
            case 48 :
                // InternalReflex.g:1:292: T__86
                {
                mT__86(); 

                }
                break;
            case 49 :
                // InternalReflex.g:1:298: T__87
                {
                mT__87(); 

                }
                break;
            case 50 :
                // InternalReflex.g:1:304: T__88
                {
                mT__88(); 

                }
                break;
            case 51 :
                // InternalReflex.g:1:310: T__89
                {
                mT__89(); 

                }
                break;
            case 52 :
                // InternalReflex.g:1:316: T__90
                {
                mT__90(); 

                }
                break;
            case 53 :
                // InternalReflex.g:1:322: T__91
                {
                mT__91(); 

                }
                break;
            case 54 :
                // InternalReflex.g:1:328: T__92
                {
                mT__92(); 

                }
                break;
            case 55 :
                // InternalReflex.g:1:334: T__93
                {
                mT__93(); 

                }
                break;
            case 56 :
                // InternalReflex.g:1:340: T__94
                {
                mT__94(); 

                }
                break;
            case 57 :
                // InternalReflex.g:1:346: T__95
                {
                mT__95(); 

                }
                break;
            case 58 :
                // InternalReflex.g:1:352: T__96
                {
                mT__96(); 

                }
                break;
            case 59 :
                // InternalReflex.g:1:358: T__97
                {
                mT__97(); 

                }
                break;
            case 60 :
                // InternalReflex.g:1:364: T__98
                {
                mT__98(); 

                }
                break;
            case 61 :
                // InternalReflex.g:1:370: T__99
                {
                mT__99(); 

                }
                break;
            case 62 :
                // InternalReflex.g:1:376: T__100
                {
                mT__100(); 

                }
                break;
            case 63 :
                // InternalReflex.g:1:383: T__101
                {
                mT__101(); 

                }
                break;
            case 64 :
                // InternalReflex.g:1:390: T__102
                {
                mT__102(); 

                }
                break;
            case 65 :
                // InternalReflex.g:1:397: RULE_LOGICAL_OR
                {
                mRULE_LOGICAL_OR(); 

                }
                break;
            case 66 :
                // InternalReflex.g:1:413: RULE_LOGICAL_AND
                {
                mRULE_LOGICAL_AND(); 

                }
                break;
            case 67 :
                // InternalReflex.g:1:430: RULE_BIT_OR
                {
                mRULE_BIT_OR(); 

                }
                break;
            case 68 :
                // InternalReflex.g:1:442: RULE_BIT_XOR
                {
                mRULE_BIT_XOR(); 

                }
                break;
            case 69 :
                // InternalReflex.g:1:455: RULE_BIT_AND
                {
                mRULE_BIT_AND(); 

                }
                break;
            case 70 :
                // InternalReflex.g:1:468: RULE_VOID_C_TYPE
                {
                mRULE_VOID_C_TYPE(); 

                }
                break;
            case 71 :
                // InternalReflex.g:1:485: RULE_FLOAT_C_TYPE
                {
                mRULE_FLOAT_C_TYPE(); 

                }
                break;
            case 72 :
                // InternalReflex.g:1:503: RULE_DOUBLE_C_TYPE
                {
                mRULE_DOUBLE_C_TYPE(); 

                }
                break;
            case 73 :
                // InternalReflex.g:1:522: RULE_SHORT_C_TYPE
                {
                mRULE_SHORT_C_TYPE(); 

                }
                break;
            case 74 :
                // InternalReflex.g:1:540: RULE_INT_C_TYPE
                {
                mRULE_INT_C_TYPE(); 

                }
                break;
            case 75 :
                // InternalReflex.g:1:556: RULE_LONG_C_TYPE
                {
                mRULE_LONG_C_TYPE(); 

                }
                break;
            case 76 :
                // InternalReflex.g:1:573: RULE_BOOL_TYPE
                {
                mRULE_BOOL_TYPE(); 

                }
                break;
            case 77 :
                // InternalReflex.g:1:588: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 78 :
                // InternalReflex.g:1:601: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 79 :
                // InternalReflex.g:1:612: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 80 :
                // InternalReflex.g:1:620: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 81 :
                // InternalReflex.g:1:629: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 82 :
                // InternalReflex.g:1:641: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 83 :
                // InternalReflex.g:1:657: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 84 :
                // InternalReflex.g:1:673: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 85 :
                // InternalReflex.g:1:681: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA3_eotS =
        "\5\uffff";
    static final String DFA3_eofS =
        "\5\uffff";
    static final String DFA3_minS =
        "\2\56\1\60\2\uffff";
    static final String DFA3_maxS =
        "\3\146\2\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA3_specialS =
        "\5\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\1\uffff\12\1\7\uffff\6\3\32\uffff\6\3",
            "\1\2\1\uffff\12\1\7\uffff\6\3\32\uffff\6\3",
            "\12\4\7\uffff\6\3\32\uffff\6\3",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "10079:14: ( RULE_DEC_FLOAT | RULE_HEX_FLOAT )";
        }
    }
    static final String DFA26_eotS =
        "\1\uffff\2\62\1\66\1\71\1\74\1\76\1\102\1\104\1\107\1\112\1\114\1\117\1\uffff\1\122\1\uffff\3\62\3\uffff\1\62\3\uffff\1\62\2\uffff\2\62\1\uffff\7\62\2\167\1\57\1\62\1\uffff\2\57\2\uffff\1\62\1\177\1\uffff\1\62\17\uffff\1\u0082\1\uffff\1\u0084\16\uffff\7\62\3\uffff\2\62\1\uffff\1\62\3\uffff\2\62\2\uffff\5\62\1\uffff\10\62\1\uffff\1\167\1\u00a1\1\167\2\uffff\1\62\1\u00a3\1\uffff\1\62\4\uffff\4\62\1\u00aa\27\62\1\uffff\1\62\1\uffff\4\62\1\u00c9\1\62\1\uffff\4\62\1\u00cf\1\u00d0\2\62\1\u00d3\1\u00d4\1\62\1\u00d6\1\u00d7\2\62\1\u00da\1\u00db\1\62\1\u00dd\3\62\1\u00e1\1\u00e2\1\62\1\u00e4\2\62\1\u00e7\1\u00e8\1\uffff\2\62\1\u00eb\2\62\2\uffff\1\u00ee\1\62\2\uffff\1\u00f0\2\uffff\1\u00f1\1\u00f2\2\uffff\1\u00f3\1\uffff\1\62\1\u00f5\1\62\2\uffff\1\62\1\uffff\1\u00f8\1\u00f9\2\uffff\1\u00fa\1\u00fb\1\uffff\2\62\1\uffff\1\62\4\uffff\1\62\1\uffff\1\u0100\1\u0101\4\uffff\1\62\1\u0103\1\u0104\1\u0105\2\uffff\1\u0106\4\uffff";
    static final String DFA26_eofS =
        "\u0107\uffff";
    static final String DFA26_minS =
        "\1\0\1\146\1\165\1\53\1\55\1\74\1\75\1\52\1\74\1\75\1\46\2\75\1\uffff\1\75\1\uffff\1\145\1\156\1\162\3\uffff\1\56\3\uffff\1\141\2\uffff\2\56\1\uffff\1\56\1\157\1\145\1\154\1\145\1\157\3\56\1\60\1\56\1\uffff\2\0\2\uffff\1\160\1\60\1\uffff\1\164\17\uffff\1\75\1\uffff\1\75\16\uffff\1\147\1\141\1\151\1\164\1\141\1\163\1\157\3\uffff\2\157\1\uffff\1\56\3\uffff\1\155\1\143\2\uffff\1\163\1\162\1\165\1\56\1\156\1\uffff\1\145\1\157\1\143\1\163\1\157\1\170\1\151\1\165\1\uffff\3\56\2\uffff\1\165\1\60\1\uffff\1\160\4\uffff\1\156\1\162\1\160\1\164\1\60\2\162\1\151\1\143\1\155\1\141\1\145\1\164\1\145\1\157\1\155\1\145\1\163\1\141\1\154\1\160\1\141\1\147\1\145\1\142\1\164\1\144\1\142\1\uffff\1\164\1\uffff\1\165\2\145\1\164\1\60\1\143\1\uffff\1\145\1\164\1\147\1\162\2\60\1\164\1\157\2\60\1\162\2\60\1\164\1\153\2\60\1\154\1\60\1\141\1\164\1\141\2\60\1\154\1\60\1\164\1\144\2\60\1\uffff\1\150\1\144\1\60\1\156\1\141\2\uffff\1\60\1\165\2\uffff\1\60\2\uffff\2\60\2\uffff\1\60\1\uffff\1\162\1\60\1\154\2\uffff\1\145\1\uffff\2\60\2\uffff\2\60\1\uffff\1\145\1\155\1\uffff\1\164\4\uffff\1\164\1\uffff\2\60\4\uffff\1\144\3\60\2\uffff\1\60\4\uffff";
    static final String DFA26_maxS =
        "\1\uffff\1\156\1\165\5\75\1\74\1\76\1\75\1\172\1\174\1\uffff\1\75\1\uffff\1\167\1\156\1\162\3\uffff\1\162\3\uffff\1\151\2\uffff\1\162\1\157\1\uffff\1\162\1\157\1\145\1\154\1\145\2\157\4\146\1\uffff\2\uffff\2\uffff\1\164\1\172\1\uffff\1\164\17\uffff\1\75\1\uffff\1\75\16\uffff\1\147\1\157\1\151\1\164\1\157\1\163\1\157\3\uffff\2\157\1\uffff\1\146\3\uffff\1\155\1\143\2\uffff\1\163\1\162\1\165\1\163\1\156\1\uffff\1\145\2\157\1\163\1\157\1\170\1\151\1\165\1\uffff\3\146\2\uffff\1\165\1\172\1\uffff\1\160\4\uffff\1\156\1\164\1\160\1\164\1\172\2\162\1\151\1\147\1\155\1\141\1\145\1\164\1\145\1\157\1\155\1\145\1\163\1\141\1\154\1\160\1\141\1\147\1\164\1\142\1\164\1\144\1\142\1\uffff\1\164\1\uffff\1\165\2\145\1\164\1\172\1\143\1\uffff\1\145\1\164\1\147\1\162\2\172\1\164\1\157\2\172\1\162\2\172\1\164\1\153\2\172\1\154\1\172\1\141\1\164\1\141\2\172\1\154\1\172\1\164\1\144\2\172\1\uffff\1\150\1\144\1\172\1\156\1\141\2\uffff\1\172\1\165\2\uffff\1\172\2\uffff\2\172\2\uffff\1\172\1\uffff\1\162\1\172\1\154\2\uffff\1\145\1\uffff\2\172\2\uffff\2\172\1\uffff\1\145\1\155\1\uffff\1\164\4\uffff\1\164\1\uffff\2\172\4\uffff\1\144\3\172\2\uffff\1\172\4\uffff";
    static final String DFA26_acceptS =
        "\15\uffff\1\21\1\uffff\1\35\3\uffff\1\41\1\42\1\44\1\uffff\1\46\1\47\1\50\1\uffff\1\54\1\55\2\uffff\1\61\13\uffff\1\117\2\uffff\1\124\1\125\2\uffff\1\117\1\uffff\1\3\1\10\1\17\1\4\1\11\1\20\1\25\1\27\1\5\1\6\1\33\1\7\1\122\1\123\1\34\1\uffff\1\23\1\uffff\1\26\1\24\1\14\1\102\1\105\1\15\1\104\1\16\1\101\1\103\1\21\1\30\1\22\1\35\7\uffff\1\41\1\42\1\44\2\uffff\1\116\1\uffff\1\46\1\47\1\50\2\uffff\1\54\1\55\5\uffff\1\61\10\uffff\1\115\3\uffff\1\121\1\124\2\uffff\1\53\1\uffff\1\12\1\32\1\13\1\31\34\uffff\1\120\1\uffff\1\112\6\uffff\1\71\36\uffff\1\64\5\uffff\1\43\1\45\2\uffff\1\74\1\56\1\uffff\1\73\1\60\2\uffff\1\114\1\66\1\uffff\1\113\3\uffff\1\100\1\106\1\uffff\1\1\2\uffff\1\51\1\63\2\uffff\1\111\2\uffff\1\107\1\uffff\1\65\1\72\1\62\1\75\1\uffff\1\70\2\uffff\1\2\1\36\1\57\1\77\4\uffff\1\76\1\110\1\uffff\1\40\1\52\1\67\1\37";
    static final String DFA26_specialS =
        "\1\1\53\uffff\1\0\1\2\u00d9\uffff}>";
    static final String[] DFA26_transitionS = {
            "\11\57\2\56\2\57\1\56\22\57\1\56\1\16\1\54\2\57\1\17\1\12\1\55\1\33\1\34\1\6\1\3\1\27\1\4\1\51\1\7\1\47\11\50\1\37\1\25\1\10\1\5\1\11\2\57\6\52\24\53\1\30\1\57\1\31\1\13\1\53\1\57\1\52\1\40\1\36\1\46\1\35\1\26\1\43\1\53\1\1\2\53\1\41\1\53\1\44\1\2\1\22\1\53\1\42\1\20\1\32\1\21\1\45\4\53\1\23\1\14\1\24\1\15\uff81\57",
            "\1\61\7\uffff\1\60",
            "\1\63",
            "\1\64\21\uffff\1\65",
            "\1\67\17\uffff\1\70",
            "\1\72\1\73",
            "\1\75",
            "\1\100\4\uffff\1\101\15\uffff\1\77",
            "\1\103",
            "\1\106\1\105",
            "\1\111\26\uffff\1\110",
            "\1\113\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\115\76\uffff\1\116",
            "",
            "\1\121",
            "",
            "\1\127\2\uffff\1\130\1\124\12\uffff\1\125\2\uffff\1\126",
            "\1\131",
            "\1\132",
            "",
            "",
            "",
            "\1\140\1\uffff\12\141\7\uffff\6\141\32\uffff\6\141\5\uffff\1\137\5\uffff\1\136",
            "",
            "",
            "",
            "\1\146\7\uffff\1\145",
            "",
            "",
            "\1\140\1\uffff\12\141\7\uffff\6\141\32\uffff\6\141\5\uffff\1\151\1\uffff\1\153\3\uffff\1\152",
            "\1\140\1\uffff\12\141\7\uffff\6\141\32\uffff\1\154\5\141\10\uffff\1\155",
            "",
            "\1\140\1\uffff\12\141\7\uffff\6\141\32\uffff\6\141\10\uffff\1\160\2\uffff\1\157",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\140\1\uffff\12\141\7\uffff\6\141\32\uffff\6\141\10\uffff\1\166",
            "\1\140\1\uffff\10\170\2\171\7\uffff\6\140\32\uffff\6\140",
            "\1\140\1\uffff\12\172\7\uffff\6\140\32\uffff\6\140",
            "\12\140\7\uffff\6\140\32\uffff\6\140",
            "\1\140\1\uffff\12\141\7\uffff\6\141\32\uffff\6\141",
            "",
            "\0\173",
            "\0\173",
            "",
            "",
            "\1\175\3\uffff\1\176",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0080",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0081",
            "",
            "\1\u0083",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0085",
            "\1\u0086\15\uffff\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a\15\uffff\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "",
            "",
            "",
            "\1\u008e",
            "\1\u008f",
            "",
            "\1\140\1\uffff\12\141\7\uffff\6\141\32\uffff\6\141",
            "",
            "",
            "",
            "\1\u0090",
            "\1\u0091",
            "",
            "",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\140\1\uffff\12\141\7\uffff\6\141\32\uffff\6\141\14\uffff\1\u0095",
            "\1\u0096",
            "",
            "\1\u0097",
            "\1\u0098",
            "\1\u009a\12\uffff\1\u009b\1\u0099",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "",
            "\1\140\1\uffff\10\170\2\171\7\uffff\6\140\32\uffff\6\140",
            "\1\140\1\uffff\12\171\7\uffff\6\140\32\uffff\6\140",
            "\1\140\1\uffff\12\172\7\uffff\6\140\32\uffff\6\140",
            "",
            "",
            "\1\u00a2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u00a4",
            "",
            "",
            "",
            "",
            "\1\u00a5",
            "\1\u00a7\1\uffff\1\u00a6",
            "\1\u00a8",
            "\1\u00a9",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00af\3\uffff\1\u00ae",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00bf\16\uffff\1\u00be",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "",
            "\1\u00c4",
            "",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00ca",
            "",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00d1",
            "\1\u00d2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00d5",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00d8",
            "\1\u00d9",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00dc",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00e3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00e5",
            "\1\u00e6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u00e9",
            "\1\u00ea",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00ec",
            "\1\u00ed",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00ef",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u00f4",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00f6",
            "",
            "",
            "\1\u00f7",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u00fc",
            "\1\u00fd",
            "",
            "\1\u00fe",
            "",
            "",
            "",
            "",
            "\1\u00ff",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "\1\u0102",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | RULE_LOGICAL_OR | RULE_LOGICAL_AND | RULE_BIT_OR | RULE_BIT_XOR | RULE_BIT_AND | RULE_VOID_C_TYPE | RULE_FLOAT_C_TYPE | RULE_DOUBLE_C_TYPE | RULE_SHORT_C_TYPE | RULE_INT_C_TYPE | RULE_LONG_C_TYPE | RULE_BOOL_TYPE | RULE_INTEGER | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_44 = input.LA(1);

                        s = -1;
                        if ( ((LA26_44>='\u0000' && LA26_44<='\uFFFF')) ) {s = 123;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_0 = input.LA(1);

                        s = -1;
                        if ( (LA26_0=='i') ) {s = 1;}

                        else if ( (LA26_0=='o') ) {s = 2;}

                        else if ( (LA26_0=='+') ) {s = 3;}

                        else if ( (LA26_0=='-') ) {s = 4;}

                        else if ( (LA26_0=='=') ) {s = 5;}

                        else if ( (LA26_0=='*') ) {s = 6;}

                        else if ( (LA26_0=='/') ) {s = 7;}

                        else if ( (LA26_0=='<') ) {s = 8;}

                        else if ( (LA26_0=='>') ) {s = 9;}

                        else if ( (LA26_0=='&') ) {s = 10;}

                        else if ( (LA26_0=='^') ) {s = 11;}

                        else if ( (LA26_0=='|') ) {s = 12;}

                        else if ( (LA26_0=='~') ) {s = 13;}

                        else if ( (LA26_0=='!') ) {s = 14;}

                        else if ( (LA26_0=='%') ) {s = 15;}

                        else if ( (LA26_0=='s') ) {s = 16;}

                        else if ( (LA26_0=='u') ) {s = 17;}

                        else if ( (LA26_0=='p') ) {s = 18;}

                        else if ( (LA26_0=='{') ) {s = 19;}

                        else if ( (LA26_0=='}') ) {s = 20;}

                        else if ( (LA26_0==';') ) {s = 21;}

                        else if ( (LA26_0=='f') ) {s = 22;}

                        else if ( (LA26_0==',') ) {s = 23;}

                        else if ( (LA26_0=='[') ) {s = 24;}

                        else if ( (LA26_0==']') ) {s = 25;}

                        else if ( (LA26_0=='t') ) {s = 26;}

                        else if ( (LA26_0=='(') ) {s = 27;}

                        else if ( (LA26_0==')') ) {s = 28;}

                        else if ( (LA26_0=='e') ) {s = 29;}

                        else if ( (LA26_0=='c') ) {s = 30;}

                        else if ( (LA26_0==':') ) {s = 31;}

                        else if ( (LA26_0=='b') ) {s = 32;}

                        else if ( (LA26_0=='l') ) {s = 33;}

                        else if ( (LA26_0=='r') ) {s = 34;}

                        else if ( (LA26_0=='g') ) {s = 35;}

                        else if ( (LA26_0=='n') ) {s = 36;}

                        else if ( (LA26_0=='v') ) {s = 37;}

                        else if ( (LA26_0=='d') ) {s = 38;}

                        else if ( (LA26_0=='0') ) {s = 39;}

                        else if ( ((LA26_0>='1' && LA26_0<='9')) ) {s = 40;}

                        else if ( (LA26_0=='.') ) {s = 41;}

                        else if ( ((LA26_0>='A' && LA26_0<='F')||LA26_0=='a') ) {s = 42;}

                        else if ( ((LA26_0>='G' && LA26_0<='Z')||LA26_0=='_'||LA26_0=='h'||(LA26_0>='j' && LA26_0<='k')||LA26_0=='m'||LA26_0=='q'||(LA26_0>='w' && LA26_0<='z')) ) {s = 43;}

                        else if ( (LA26_0=='\"') ) {s = 44;}

                        else if ( (LA26_0=='\'') ) {s = 45;}

                        else if ( ((LA26_0>='\t' && LA26_0<='\n')||LA26_0=='\r'||LA26_0==' ') ) {s = 46;}

                        else if ( ((LA26_0>='\u0000' && LA26_0<='\b')||(LA26_0>='\u000B' && LA26_0<='\f')||(LA26_0>='\u000E' && LA26_0<='\u001F')||(LA26_0>='#' && LA26_0<='$')||(LA26_0>='?' && LA26_0<='@')||LA26_0=='\\'||LA26_0=='`'||(LA26_0>='\u007F' && LA26_0<='\uFFFF')) ) {s = 47;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_45 = input.LA(1);

                        s = -1;
                        if ( ((LA26_45>='\u0000' && LA26_45<='\uFFFF')) ) {s = 123;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}