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
    public static final int RULE_HEX=8;
    public static final int T__50=50;
    public static final int RULE_SIGN=29;
    public static final int RULE_DEC_SEQUENCE=27;
    public static final int RULE_MINUTE=34;
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
    public static final int RULE_ID=23;
    public static final int RULE_HEX_FLOAT=14;
    public static final int RULE_TACT=24;
    public static final int RULE_INT_C_TYPE=5;
    public static final int RULE_INT=39;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=41;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_MICROSECOND=37;
    public static final int RULE_VOID_C_TYPE=20;
    public static final int RULE_HEX_SEQUENCE=31;
    public static final int RULE_HOUR=26;
    public static final int RULE_UNSIGNED=12;
    public static final int RULE_DOUBLE_C_TYPE=22;
    public static final int RULE_BIN_EXPONENT=32;
    public static final int RULE_LOGICAL_AND=18;
    public static final int RULE_EXPONENT=28;
    public static final int T__48=48;
    public static final int RULE_DEC_FLOAT=13;
    public static final int T__49=49;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_BIT_AND=15;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int RULE_BOOL_TYPE=7;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int RULE_DAY=25;
    public static final int T__90=90;
    public static final int RULE_FLOAT_C_TYPE=21;
    public static final int RULE_OCTAL=9;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_SHORT_C_TYPE=4;
    public static final int RULE_DECIMAL=10;
    public static final int RULE_SECOND=35;
    public static final int RULE_LOGICAL_OR=19;
    public static final int RULE_LONG_C_TYPE=6;
    public static final int RULE_FLOAT_SUFFIX=30;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_NANOSECOND=38;
    public static final int RULE_MILISECOND=36;
    public static final int RULE_STRING=40;
    public static final int RULE_SL_COMMENT=42;
    public static final int RULE_HEX_PREFIX=33;
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
    public static final int RULE_WS=43;
    public static final int RULE_ANY_OTHER=44;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int RULE_BIT_XOR=16;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_LONG=11;
    public static final int RULE_BIT_OR=17;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

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

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:11:7: ( '0t' )
            // InternalReflex.g:11:9: '0t'
            {
            match("0t"); 


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
            // InternalReflex.g:12:7: ( '0T' )
            // InternalReflex.g:12:9: '0T'
            {
            match("0T"); 


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
            // InternalReflex.g:13:7: ( 'input' )
            // InternalReflex.g:13:9: 'input'
            {
            match("input"); 


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
            // InternalReflex.g:14:7: ( 'output' )
            // InternalReflex.g:14:9: 'output'
            {
            match("output"); 


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
            // InternalReflex.g:15:7: ( '++' )
            // InternalReflex.g:15:9: '++'
            {
            match("++"); 


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
            // InternalReflex.g:16:7: ( '--' )
            // InternalReflex.g:16:9: '--'
            {
            match("--"); 


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
            // InternalReflex.g:17:7: ( '=' )
            // InternalReflex.g:17:9: '='
            {
            match('='); 

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
            // InternalReflex.g:18:7: ( '*=' )
            // InternalReflex.g:18:9: '*='
            {
            match("*="); 


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
            // InternalReflex.g:19:7: ( '/=' )
            // InternalReflex.g:19:9: '/='
            {
            match("/="); 


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
            // InternalReflex.g:20:7: ( '+=' )
            // InternalReflex.g:20:9: '+='
            {
            match("+="); 


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
            // InternalReflex.g:21:7: ( '-=' )
            // InternalReflex.g:21:9: '-='
            {
            match("-="); 


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
            // InternalReflex.g:22:7: ( '<<=' )
            // InternalReflex.g:22:9: '<<='
            {
            match("<<="); 


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
            // InternalReflex.g:23:7: ( '>>=' )
            // InternalReflex.g:23:9: '>>='
            {
            match(">>="); 


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
            // InternalReflex.g:24:7: ( '&=' )
            // InternalReflex.g:24:9: '&='
            {
            match("&="); 


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
            // InternalReflex.g:25:7: ( '^=' )
            // InternalReflex.g:25:9: '^='
            {
            match("^="); 


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
            // InternalReflex.g:26:7: ( '|=' )
            // InternalReflex.g:26:9: '|='
            {
            match("|="); 


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
            // InternalReflex.g:27:7: ( '+' )
            // InternalReflex.g:27:9: '+'
            {
            match('+'); 

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
            // InternalReflex.g:28:7: ( '-' )
            // InternalReflex.g:28:9: '-'
            {
            match('-'); 

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
            // InternalReflex.g:29:7: ( '~' )
            // InternalReflex.g:29:9: '~'
            {
            match('~'); 

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
            // InternalReflex.g:30:7: ( '!' )
            // InternalReflex.g:30:9: '!'
            {
            match('!'); 

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
            // InternalReflex.g:31:7: ( '<' )
            // InternalReflex.g:31:9: '<'
            {
            match('<'); 

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
            // InternalReflex.g:32:7: ( '>' )
            // InternalReflex.g:32:9: '>'
            {
            match('>'); 

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
            // InternalReflex.g:33:7: ( '=<' )
            // InternalReflex.g:33:9: '=<'
            {
            match("=<"); 


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
            // InternalReflex.g:34:7: ( '>=' )
            // InternalReflex.g:34:9: '>='
            {
            match(">="); 


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
            // InternalReflex.g:35:7: ( '==' )
            // InternalReflex.g:35:9: '=='
            {
            match("=="); 


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
            // InternalReflex.g:36:7: ( '!=' )
            // InternalReflex.g:36:9: '!='
            {
            match("!="); 


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
            // InternalReflex.g:37:7: ( '>>' )
            // InternalReflex.g:37:9: '>>'
            {
            match(">>"); 


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
            // InternalReflex.g:38:7: ( '<<' )
            // InternalReflex.g:38:9: '<<'
            {
            match("<<"); 


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
            // InternalReflex.g:39:7: ( '*' )
            // InternalReflex.g:39:9: '*'
            {
            match('*'); 

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
            // InternalReflex.g:40:7: ( '/' )
            // InternalReflex.g:40:9: '/'
            {
            match('/'); 

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
            // InternalReflex.g:41:7: ( '%' )
            // InternalReflex.g:41:9: '%'
            {
            match('%'); 

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
            // InternalReflex.g:42:7: ( 'signed' )
            // InternalReflex.g:42:9: 'signed'
            {
            match("signed"); 


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
            // InternalReflex.g:43:7: ( 'unsigned' )
            // InternalReflex.g:43:9: 'unsigned'
            {
            match("unsigned"); 


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
            // InternalReflex.g:44:7: ( 'program' )
            // InternalReflex.g:44:9: 'program'
            {
            match("program"); 


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
            // InternalReflex.g:45:7: ( '{' )
            // InternalReflex.g:45:9: '{'
            {
            match('{'); 

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
            // InternalReflex.g:46:7: ( '}' )
            // InternalReflex.g:46:9: '}'
            {
            match('}'); 

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
            // InternalReflex.g:47:7: ( 'proc' )
            // InternalReflex.g:47:9: 'proc'
            {
            match("proc"); 


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
            // InternalReflex.g:48:7: ( ';' )
            // InternalReflex.g:48:9: ';'
            {
            match(';'); 

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
            // InternalReflex.g:49:7: ( 'from' )
            // InternalReflex.g:49:9: 'from'
            {
            match("from"); 


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
            // InternalReflex.g:50:7: ( ',' )
            // InternalReflex.g:50:9: ','
            {
            match(','); 

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
            // InternalReflex.g:51:7: ( '[' )
            // InternalReflex.g:51:9: '['
            {
            match('['); 

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
            // InternalReflex.g:52:7: ( ']' )
            // InternalReflex.g:52:9: ']'
            {
            match(']'); 

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
            // InternalReflex.g:53:7: ( 'state' )
            // InternalReflex.g:53:9: 'state'
            {
            match("state"); 


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
            // InternalReflex.g:54:7: ( 'timeout' )
            // InternalReflex.g:54:9: 'timeout'
            {
            match("timeout"); 


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
            // InternalReflex.g:55:7: ( 'if' )
            // InternalReflex.g:55:9: 'if'
            {
            match("if"); 


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
            // InternalReflex.g:56:7: ( '(' )
            // InternalReflex.g:56:9: '('
            {
            match('('); 

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
            // InternalReflex.g:57:7: ( ')' )
            // InternalReflex.g:57:9: ')'
            {
            match(')'); 

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
            // InternalReflex.g:58:7: ( 'else' )
            // InternalReflex.g:58:9: 'else'
            {
            match("else"); 


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
            // InternalReflex.g:59:7: ( 'switch' )
            // InternalReflex.g:59:9: 'switch'
            {
            match("switch"); 


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
            // InternalReflex.g:60:7: ( 'case' )
            // InternalReflex.g:60:9: 'case'
            {
            match("case"); 


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
            // InternalReflex.g:61:7: ( ':' )
            // InternalReflex.g:61:9: ':'
            {
            match(':'); 

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
            // InternalReflex.g:62:7: ( 'break' )
            // InternalReflex.g:62:9: 'break'
            {
            match("break"); 


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
            // InternalReflex.g:63:7: ( 'start' )
            // InternalReflex.g:63:9: 'start'
            {
            match("start"); 


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
            // InternalReflex.g:64:7: ( 'stop' )
            // InternalReflex.g:64:9: 'stop'
            {
            match("stop"); 


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
            // InternalReflex.g:65:7: ( 'error' )
            // InternalReflex.g:65:9: 'error'
            {
            match("error"); 


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
            // InternalReflex.g:66:8: ( 'loop' )
            // InternalReflex.g:66:10: 'loop'
            {
            match("loop"); 


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
            // InternalReflex.g:67:8: ( 'restart' )
            // InternalReflex.g:67:10: 'restart'
            {
            match("restart"); 


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
            // InternalReflex.g:68:8: ( 'reset' )
            // InternalReflex.g:68:10: 'reset'
            {
            match("reset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:69:8: ( 'set' )
            // InternalReflex.g:69:10: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:70:8: ( 'const' )
            // InternalReflex.g:70:10: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:71:8: ( 'enum' )
            // InternalReflex.g:71:10: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:72:8: ( 'local' )
            // InternalReflex.g:72:10: 'local'
            {
            match("local"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:73:8: ( 'global' )
            // InternalReflex.g:73:10: 'global'
            {
            match("global"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:74:8: ( 'shared' )
            // InternalReflex.g:74:10: 'shared'
            {
            match("shared"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:75:8: ( 'next' )
            // InternalReflex.g:75:10: 'next'
            {
            match("next"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "RULE_LOGICAL_OR"
    public final void mRULE_LOGICAL_OR() throws RecognitionException {
        try {
            int _type = RULE_LOGICAL_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10363:17: ( '||' )
            // InternalReflex.g:10363:19: '||'
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
            // InternalReflex.g:10365:18: ( '&&' )
            // InternalReflex.g:10365:20: '&&'
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
            // InternalReflex.g:10367:13: ( '|' )
            // InternalReflex.g:10367:15: '|'
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
            // InternalReflex.g:10369:14: ( '^' )
            // InternalReflex.g:10369:16: '^'
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
            // InternalReflex.g:10371:14: ( '&' )
            // InternalReflex.g:10371:16: '&'
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
            // InternalReflex.g:10373:18: ( 'void' )
            // InternalReflex.g:10373:20: 'void'
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
            // InternalReflex.g:10375:19: ( 'float' )
            // InternalReflex.g:10375:21: 'float'
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
            // InternalReflex.g:10377:20: ( 'double' )
            // InternalReflex.g:10377:22: 'double'
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
            // InternalReflex.g:10379:19: ( 'short' )
            // InternalReflex.g:10379:21: 'short'
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
            // InternalReflex.g:10381:17: ( 'int' )
            // InternalReflex.g:10381:19: 'int'
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
            // InternalReflex.g:10383:18: ( 'long' )
            // InternalReflex.g:10383:20: 'long'
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
            // InternalReflex.g:10385:16: ( 'bool' )
            // InternalReflex.g:10385:18: 'bool'
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

    // $ANTLR start "RULE_TACT"
    public final void mRULE_TACT() throws RecognitionException {
        try {
            int _type = RULE_TACT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10387:11: ( 'tact' )
            // InternalReflex.g:10387:13: 'tact'
            {
            match("tact"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TACT"

    // $ANTLR start "RULE_DEC_FLOAT"
    public final void mRULE_DEC_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_DEC_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10389:16: ( ( RULE_DEC_SEQUENCE )? '.' RULE_DEC_SEQUENCE ( RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )? )
            // InternalReflex.g:10389:18: ( RULE_DEC_SEQUENCE )? '.' RULE_DEC_SEQUENCE ( RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            {
            // InternalReflex.g:10389:18: ( RULE_DEC_SEQUENCE )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalReflex.g:10389:18: RULE_DEC_SEQUENCE
                    {
                    mRULE_DEC_SEQUENCE(); 

                    }
                    break;

            }

            match('.'); 
            mRULE_DEC_SEQUENCE(); 
            // InternalReflex.g:10389:59: ( RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='E'||LA2_0=='e') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalReflex.g:10389:60: RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE
                    {
                    mRULE_EXPONENT(); 
                    mRULE_SIGN(); 
                    mRULE_DEC_SEQUENCE(); 

                    }
                    break;

            }

            // InternalReflex.g:10389:104: ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='F'||LA3_0=='L'||LA3_0=='f'||LA3_0=='l') ) {
                alt3=1;
            }
            switch (alt3) {
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DEC_FLOAT"

    // $ANTLR start "RULE_HEX_FLOAT"
    public final void mRULE_HEX_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_HEX_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10391:16: ( ( RULE_HEX_SEQUENCE )? '.' RULE_HEX_SEQUENCE ( RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )? )
            // InternalReflex.g:10391:18: ( RULE_HEX_SEQUENCE )? '.' RULE_HEX_SEQUENCE ( RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            {
            // InternalReflex.g:10391:18: ( RULE_HEX_SEQUENCE )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='F')||(LA4_0>='a' && LA4_0<='f')) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalReflex.g:10391:18: RULE_HEX_SEQUENCE
                    {
                    mRULE_HEX_SEQUENCE(); 

                    }
                    break;

            }

            match('.'); 
            mRULE_HEX_SEQUENCE(); 
            // InternalReflex.g:10391:59: ( RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='P'||LA5_0=='p') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalReflex.g:10391:60: RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE
                    {
                    mRULE_BIN_EXPONENT(); 
                    mRULE_SIGN(); 
                    mRULE_DEC_SEQUENCE(); 

                    }
                    break;

            }

            // InternalReflex.g:10391:108: ( RULE_LONG | RULE_FLOAT_SUFFIX )?
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_FLOAT"

    // $ANTLR start "RULE_DEC_SEQUENCE"
    public final void mRULE_DEC_SEQUENCE() throws RecognitionException {
        try {
            // InternalReflex.g:10393:28: ( ( '0' .. '9' )+ )
            // InternalReflex.g:10393:30: ( '0' .. '9' )+
            {
            // InternalReflex.g:10393:30: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalReflex.g:10393:31: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
            // InternalReflex.g:10395:28: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalReflex.g:10395:30: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            // InternalReflex.g:10395:30: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='F')||(LA8_0>='a' && LA8_0<='f')) ) {
                    alt8=1;
                }


                switch (alt8) {
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // InternalReflex.g:10397:28: ( ( 'p' | 'P' ) )
            // InternalReflex.g:10397:30: ( 'p' | 'P' )
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
            // InternalReflex.g:10399:24: ( ( 'e' | 'E' ) )
            // InternalReflex.g:10399:26: ( 'e' | 'E' )
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
            // InternalReflex.g:10401:20: ( ( '+' | '-' ) )
            // InternalReflex.g:10401:22: ( '+' | '-' )
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
            int _type = RULE_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10403:14: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) )
            // InternalReflex.g:10403:16: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            {
            // InternalReflex.g:10403:16: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='0') ) {
                alt10=1;
            }
            else if ( ((LA10_0>='1' && LA10_0<='9')) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalReflex.g:10403:17: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:10403:21: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // InternalReflex.g:10403:30: ( '0' .. '9' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalReflex.g:10403:31: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


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
    // $ANTLR end "RULE_DECIMAL"

    // $ANTLR start "RULE_OCTAL"
    public final void mRULE_OCTAL() throws RecognitionException {
        try {
            int _type = RULE_OCTAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10405:12: ( '0' ( '0' .. '7' )+ )
            // InternalReflex.g:10405:14: '0' ( '0' .. '7' )+
            {
            match('0'); 
            // InternalReflex.g:10405:18: ( '0' .. '7' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalReflex.g:10405:19: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCTAL"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10407:10: ( RULE_HEX_PREFIX RULE_HEX_SEQUENCE )
            // InternalReflex.g:10407:12: RULE_HEX_PREFIX RULE_HEX_SEQUENCE
            {
            mRULE_HEX_PREFIX(); 
            mRULE_HEX_SEQUENCE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_HEX_PREFIX"
    public final void mRULE_HEX_PREFIX() throws RecognitionException {
        try {
            // InternalReflex.g:10409:26: ( '0' ( 'x' | 'X' ) )
            // InternalReflex.g:10409:28: '0' ( 'x' | 'X' )
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
            int _type = RULE_LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10411:11: ( ( 'L' | 'l' ) )
            // InternalReflex.g:10411:13: ( 'L' | 'l' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LONG"

    // $ANTLR start "RULE_FLOAT_SUFFIX"
    public final void mRULE_FLOAT_SUFFIX() throws RecognitionException {
        try {
            // InternalReflex.g:10413:28: ( ( 'F' | 'f' ) )
            // InternalReflex.g:10413:30: ( 'F' | 'f' )
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
            int _type = RULE_UNSIGNED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10415:15: ( ( 'U' | 'u' ) )
            // InternalReflex.g:10415:17: ( 'U' | 'u' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNSIGNED"

    // $ANTLR start "RULE_DAY"
    public final void mRULE_DAY() throws RecognitionException {
        try {
            int _type = RULE_DAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10417:10: ( ( 'D' | 'd' ) )
            // InternalReflex.g:10417:12: ( 'D' | 'd' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DAY"

    // $ANTLR start "RULE_HOUR"
    public final void mRULE_HOUR() throws RecognitionException {
        try {
            int _type = RULE_HOUR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10419:11: ( ( 'H' | 'h' ) )
            // InternalReflex.g:10419:13: ( 'H' | 'h' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HOUR"

    // $ANTLR start "RULE_MINUTE"
    public final void mRULE_MINUTE() throws RecognitionException {
        try {
            int _type = RULE_MINUTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10421:13: ( ( 'M' | 'm' ) )
            // InternalReflex.g:10421:15: ( 'M' | 'm' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MINUTE"

    // $ANTLR start "RULE_SECOND"
    public final void mRULE_SECOND() throws RecognitionException {
        try {
            int _type = RULE_SECOND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10423:13: ( ( 'S' | 's' ) )
            // InternalReflex.g:10423:15: ( 'S' | 's' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SECOND"

    // $ANTLR start "RULE_MILISECOND"
    public final void mRULE_MILISECOND() throws RecognitionException {
        try {
            int _type = RULE_MILISECOND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10425:17: ( ( 'MS' | 'ms' ) )
            // InternalReflex.g:10425:19: ( 'MS' | 'ms' )
            {
            // InternalReflex.g:10425:19: ( 'MS' | 'ms' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='M') ) {
                alt12=1;
            }
            else if ( (LA12_0=='m') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalReflex.g:10425:20: 'MS'
                    {
                    match("MS"); 


                    }
                    break;
                case 2 :
                    // InternalReflex.g:10425:25: 'ms'
                    {
                    match("ms"); 


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
    // $ANTLR end "RULE_MILISECOND"

    // $ANTLR start "RULE_MICROSECOND"
    public final void mRULE_MICROSECOND() throws RecognitionException {
        try {
            int _type = RULE_MICROSECOND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10427:18: ( ( 'US' | 'us' ) )
            // InternalReflex.g:10427:20: ( 'US' | 'us' )
            {
            // InternalReflex.g:10427:20: ( 'US' | 'us' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='U') ) {
                alt13=1;
            }
            else if ( (LA13_0=='u') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalReflex.g:10427:21: 'US'
                    {
                    match("US"); 


                    }
                    break;
                case 2 :
                    // InternalReflex.g:10427:26: 'us'
                    {
                    match("us"); 


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
    // $ANTLR end "RULE_MICROSECOND"

    // $ANTLR start "RULE_NANOSECOND"
    public final void mRULE_NANOSECOND() throws RecognitionException {
        try {
            int _type = RULE_NANOSECOND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10429:17: ( ( 'NS' | 'ns' ) )
            // InternalReflex.g:10429:19: ( 'NS' | 'ns' )
            {
            // InternalReflex.g:10429:19: ( 'NS' | 'ns' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='N') ) {
                alt14=1;
            }
            else if ( (LA14_0=='n') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalReflex.g:10429:20: 'NS'
                    {
                    match("NS"); 


                    }
                    break;
                case 2 :
                    // InternalReflex.g:10429:25: 'ns'
                    {
                    match("ns"); 


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
    // $ANTLR end "RULE_NANOSECOND"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:10431:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalReflex.g:10431:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalReflex.g:10431:11: ( '^' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='^') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalReflex.g:10431:11: '^'
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

            // InternalReflex.g:10431:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // InternalReflex.g:10433:10: ( ( '0' .. '9' )+ )
            // InternalReflex.g:10433:12: ( '0' .. '9' )+
            {
            // InternalReflex.g:10433:12: ( '0' .. '9' )+
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
            	    // InternalReflex.g:10433:13: '0' .. '9'
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
            // InternalReflex.g:10435:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalReflex.g:10435:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalReflex.g:10435:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalReflex.g:10435:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalReflex.g:10435:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalReflex.g:10435:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:10435:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalReflex.g:10435:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalReflex.g:10435:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalReflex.g:10435:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:10435:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalReflex.g:10437:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalReflex.g:10437:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalReflex.g:10437:24: ( options {greedy=false; } : . )*
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
            	    // InternalReflex.g:10437:52: .
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
            // InternalReflex.g:10439:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalReflex.g:10439:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalReflex.g:10439:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='\u0000' && LA22_0<='\t')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalReflex.g:10439:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalReflex.g:10439:40: ( ( '\\r' )? '\\n' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\n'||LA24_0=='\r') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalReflex.g:10439:41: ( '\\r' )? '\\n'
                    {
                    // InternalReflex.g:10439:41: ( '\\r' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='\r') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalReflex.g:10439:41: '\\r'
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
            // InternalReflex.g:10441:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalReflex.g:10441:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalReflex.g:10441:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // InternalReflex.g:10443:16: ( . )
            // InternalReflex.g:10443:18: .
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
        // InternalReflex.g:1:8: ( T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | RULE_LOGICAL_OR | RULE_LOGICAL_AND | RULE_BIT_OR | RULE_BIT_XOR | RULE_BIT_AND | RULE_VOID_C_TYPE | RULE_FLOAT_C_TYPE | RULE_DOUBLE_C_TYPE | RULE_SHORT_C_TYPE | RULE_INT_C_TYPE | RULE_LONG_C_TYPE | RULE_BOOL_TYPE | RULE_TACT | RULE_DEC_FLOAT | RULE_HEX_FLOAT | RULE_DECIMAL | RULE_OCTAL | RULE_HEX | RULE_LONG | RULE_UNSIGNED | RULE_DAY | RULE_HOUR | RULE_MINUTE | RULE_SECOND | RULE_MILISECOND | RULE_MICROSECOND | RULE_NANOSECOND | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt26=99;
        alt26 = dfa26.predict(input);
        switch (alt26) {
            case 1 :
                // InternalReflex.g:1:10: T__45
                {
                mT__45(); 

                }
                break;
            case 2 :
                // InternalReflex.g:1:16: T__46
                {
                mT__46(); 

                }
                break;
            case 3 :
                // InternalReflex.g:1:22: T__47
                {
                mT__47(); 

                }
                break;
            case 4 :
                // InternalReflex.g:1:28: T__48
                {
                mT__48(); 

                }
                break;
            case 5 :
                // InternalReflex.g:1:34: T__49
                {
                mT__49(); 

                }
                break;
            case 6 :
                // InternalReflex.g:1:40: T__50
                {
                mT__50(); 

                }
                break;
            case 7 :
                // InternalReflex.g:1:46: T__51
                {
                mT__51(); 

                }
                break;
            case 8 :
                // InternalReflex.g:1:52: T__52
                {
                mT__52(); 

                }
                break;
            case 9 :
                // InternalReflex.g:1:58: T__53
                {
                mT__53(); 

                }
                break;
            case 10 :
                // InternalReflex.g:1:64: T__54
                {
                mT__54(); 

                }
                break;
            case 11 :
                // InternalReflex.g:1:70: T__55
                {
                mT__55(); 

                }
                break;
            case 12 :
                // InternalReflex.g:1:76: T__56
                {
                mT__56(); 

                }
                break;
            case 13 :
                // InternalReflex.g:1:82: T__57
                {
                mT__57(); 

                }
                break;
            case 14 :
                // InternalReflex.g:1:88: T__58
                {
                mT__58(); 

                }
                break;
            case 15 :
                // InternalReflex.g:1:94: T__59
                {
                mT__59(); 

                }
                break;
            case 16 :
                // InternalReflex.g:1:100: T__60
                {
                mT__60(); 

                }
                break;
            case 17 :
                // InternalReflex.g:1:106: T__61
                {
                mT__61(); 

                }
                break;
            case 18 :
                // InternalReflex.g:1:112: T__62
                {
                mT__62(); 

                }
                break;
            case 19 :
                // InternalReflex.g:1:118: T__63
                {
                mT__63(); 

                }
                break;
            case 20 :
                // InternalReflex.g:1:124: T__64
                {
                mT__64(); 

                }
                break;
            case 21 :
                // InternalReflex.g:1:130: T__65
                {
                mT__65(); 

                }
                break;
            case 22 :
                // InternalReflex.g:1:136: T__66
                {
                mT__66(); 

                }
                break;
            case 23 :
                // InternalReflex.g:1:142: T__67
                {
                mT__67(); 

                }
                break;
            case 24 :
                // InternalReflex.g:1:148: T__68
                {
                mT__68(); 

                }
                break;
            case 25 :
                // InternalReflex.g:1:154: T__69
                {
                mT__69(); 

                }
                break;
            case 26 :
                // InternalReflex.g:1:160: T__70
                {
                mT__70(); 

                }
                break;
            case 27 :
                // InternalReflex.g:1:166: T__71
                {
                mT__71(); 

                }
                break;
            case 28 :
                // InternalReflex.g:1:172: T__72
                {
                mT__72(); 

                }
                break;
            case 29 :
                // InternalReflex.g:1:178: T__73
                {
                mT__73(); 

                }
                break;
            case 30 :
                // InternalReflex.g:1:184: T__74
                {
                mT__74(); 

                }
                break;
            case 31 :
                // InternalReflex.g:1:190: T__75
                {
                mT__75(); 

                }
                break;
            case 32 :
                // InternalReflex.g:1:196: T__76
                {
                mT__76(); 

                }
                break;
            case 33 :
                // InternalReflex.g:1:202: T__77
                {
                mT__77(); 

                }
                break;
            case 34 :
                // InternalReflex.g:1:208: T__78
                {
                mT__78(); 

                }
                break;
            case 35 :
                // InternalReflex.g:1:214: T__79
                {
                mT__79(); 

                }
                break;
            case 36 :
                // InternalReflex.g:1:220: T__80
                {
                mT__80(); 

                }
                break;
            case 37 :
                // InternalReflex.g:1:226: T__81
                {
                mT__81(); 

                }
                break;
            case 38 :
                // InternalReflex.g:1:232: T__82
                {
                mT__82(); 

                }
                break;
            case 39 :
                // InternalReflex.g:1:238: T__83
                {
                mT__83(); 

                }
                break;
            case 40 :
                // InternalReflex.g:1:244: T__84
                {
                mT__84(); 

                }
                break;
            case 41 :
                // InternalReflex.g:1:250: T__85
                {
                mT__85(); 

                }
                break;
            case 42 :
                // InternalReflex.g:1:256: T__86
                {
                mT__86(); 

                }
                break;
            case 43 :
                // InternalReflex.g:1:262: T__87
                {
                mT__87(); 

                }
                break;
            case 44 :
                // InternalReflex.g:1:268: T__88
                {
                mT__88(); 

                }
                break;
            case 45 :
                // InternalReflex.g:1:274: T__89
                {
                mT__89(); 

                }
                break;
            case 46 :
                // InternalReflex.g:1:280: T__90
                {
                mT__90(); 

                }
                break;
            case 47 :
                // InternalReflex.g:1:286: T__91
                {
                mT__91(); 

                }
                break;
            case 48 :
                // InternalReflex.g:1:292: T__92
                {
                mT__92(); 

                }
                break;
            case 49 :
                // InternalReflex.g:1:298: T__93
                {
                mT__93(); 

                }
                break;
            case 50 :
                // InternalReflex.g:1:304: T__94
                {
                mT__94(); 

                }
                break;
            case 51 :
                // InternalReflex.g:1:310: T__95
                {
                mT__95(); 

                }
                break;
            case 52 :
                // InternalReflex.g:1:316: T__96
                {
                mT__96(); 

                }
                break;
            case 53 :
                // InternalReflex.g:1:322: T__97
                {
                mT__97(); 

                }
                break;
            case 54 :
                // InternalReflex.g:1:328: T__98
                {
                mT__98(); 

                }
                break;
            case 55 :
                // InternalReflex.g:1:334: T__99
                {
                mT__99(); 

                }
                break;
            case 56 :
                // InternalReflex.g:1:340: T__100
                {
                mT__100(); 

                }
                break;
            case 57 :
                // InternalReflex.g:1:347: T__101
                {
                mT__101(); 

                }
                break;
            case 58 :
                // InternalReflex.g:1:354: T__102
                {
                mT__102(); 

                }
                break;
            case 59 :
                // InternalReflex.g:1:361: T__103
                {
                mT__103(); 

                }
                break;
            case 60 :
                // InternalReflex.g:1:368: T__104
                {
                mT__104(); 

                }
                break;
            case 61 :
                // InternalReflex.g:1:375: T__105
                {
                mT__105(); 

                }
                break;
            case 62 :
                // InternalReflex.g:1:382: T__106
                {
                mT__106(); 

                }
                break;
            case 63 :
                // InternalReflex.g:1:389: T__107
                {
                mT__107(); 

                }
                break;
            case 64 :
                // InternalReflex.g:1:396: T__108
                {
                mT__108(); 

                }
                break;
            case 65 :
                // InternalReflex.g:1:403: T__109
                {
                mT__109(); 

                }
                break;
            case 66 :
                // InternalReflex.g:1:410: RULE_LOGICAL_OR
                {
                mRULE_LOGICAL_OR(); 

                }
                break;
            case 67 :
                // InternalReflex.g:1:426: RULE_LOGICAL_AND
                {
                mRULE_LOGICAL_AND(); 

                }
                break;
            case 68 :
                // InternalReflex.g:1:443: RULE_BIT_OR
                {
                mRULE_BIT_OR(); 

                }
                break;
            case 69 :
                // InternalReflex.g:1:455: RULE_BIT_XOR
                {
                mRULE_BIT_XOR(); 

                }
                break;
            case 70 :
                // InternalReflex.g:1:468: RULE_BIT_AND
                {
                mRULE_BIT_AND(); 

                }
                break;
            case 71 :
                // InternalReflex.g:1:481: RULE_VOID_C_TYPE
                {
                mRULE_VOID_C_TYPE(); 

                }
                break;
            case 72 :
                // InternalReflex.g:1:498: RULE_FLOAT_C_TYPE
                {
                mRULE_FLOAT_C_TYPE(); 

                }
                break;
            case 73 :
                // InternalReflex.g:1:516: RULE_DOUBLE_C_TYPE
                {
                mRULE_DOUBLE_C_TYPE(); 

                }
                break;
            case 74 :
                // InternalReflex.g:1:535: RULE_SHORT_C_TYPE
                {
                mRULE_SHORT_C_TYPE(); 

                }
                break;
            case 75 :
                // InternalReflex.g:1:553: RULE_INT_C_TYPE
                {
                mRULE_INT_C_TYPE(); 

                }
                break;
            case 76 :
                // InternalReflex.g:1:569: RULE_LONG_C_TYPE
                {
                mRULE_LONG_C_TYPE(); 

                }
                break;
            case 77 :
                // InternalReflex.g:1:586: RULE_BOOL_TYPE
                {
                mRULE_BOOL_TYPE(); 

                }
                break;
            case 78 :
                // InternalReflex.g:1:601: RULE_TACT
                {
                mRULE_TACT(); 

                }
                break;
            case 79 :
                // InternalReflex.g:1:611: RULE_DEC_FLOAT
                {
                mRULE_DEC_FLOAT(); 

                }
                break;
            case 80 :
                // InternalReflex.g:1:626: RULE_HEX_FLOAT
                {
                mRULE_HEX_FLOAT(); 

                }
                break;
            case 81 :
                // InternalReflex.g:1:641: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 82 :
                // InternalReflex.g:1:654: RULE_OCTAL
                {
                mRULE_OCTAL(); 

                }
                break;
            case 83 :
                // InternalReflex.g:1:665: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 84 :
                // InternalReflex.g:1:674: RULE_LONG
                {
                mRULE_LONG(); 

                }
                break;
            case 85 :
                // InternalReflex.g:1:684: RULE_UNSIGNED
                {
                mRULE_UNSIGNED(); 

                }
                break;
            case 86 :
                // InternalReflex.g:1:698: RULE_DAY
                {
                mRULE_DAY(); 

                }
                break;
            case 87 :
                // InternalReflex.g:1:707: RULE_HOUR
                {
                mRULE_HOUR(); 

                }
                break;
            case 88 :
                // InternalReflex.g:1:717: RULE_MINUTE
                {
                mRULE_MINUTE(); 

                }
                break;
            case 89 :
                // InternalReflex.g:1:729: RULE_SECOND
                {
                mRULE_SECOND(); 

                }
                break;
            case 90 :
                // InternalReflex.g:1:741: RULE_MILISECOND
                {
                mRULE_MILISECOND(); 

                }
                break;
            case 91 :
                // InternalReflex.g:1:757: RULE_MICROSECOND
                {
                mRULE_MICROSECOND(); 

                }
                break;
            case 92 :
                // InternalReflex.g:1:774: RULE_NANOSECOND
                {
                mRULE_NANOSECOND(); 

                }
                break;
            case 93 :
                // InternalReflex.g:1:790: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 94 :
                // InternalReflex.g:1:798: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 95 :
                // InternalReflex.g:1:807: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 96 :
                // InternalReflex.g:1:819: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 97 :
                // InternalReflex.g:1:835: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 98 :
                // InternalReflex.g:1:851: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 99 :
                // InternalReflex.g:1:859: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA26_eotS =
        "\1\uffff\1\73\2\102\1\106\1\111\1\114\1\116\1\122\1\124\1\127\1\132\1\134\1\137\1\uffff\1\142\1\uffff\1\151\1\154\1\102\3\uffff\1\102\3\uffff\1\102\2\uffff\2\102\1\uffff\1\102\1\u0084\4\102\1\u008b\1\73\1\67\1\u008b\1\u0084\1\154\1\102\1\u008f\1\u0091\1\151\1\u0091\1\102\1\uffff\2\67\6\uffff\1\u0096\2\uffff\1\u0097\1\102\1\u009a\1\uffff\1\102\17\uffff\1\u009d\1\uffff\1\u009f\16\uffff\5\102\1\uffff\1\102\1\u00a8\1\uffff\1\102\3\uffff\3\102\3\uffff\2\102\2\uffff\5\102\1\uffff\3\102\1\uffff\3\102\1\u00bb\2\102\1\uffff\1\73\1\u00be\1\u00a8\1\uffff\1\u00c2\1\uffff\1\u00c2\1\u00bb\4\uffff\1\102\1\u00c4\1\uffff\1\102\4\uffff\4\102\1\u00cb\3\102\1\uffff\22\102\1\uffff\2\102\1\uffff\1\76\1\u00be\2\uffff\1\102\1\uffff\4\102\1\u00ea\1\102\1\uffff\4\102\1\u00f0\1\u00f1\2\102\1\u00f4\1\u00f5\1\102\1\u00f7\1\u00f8\2\102\1\u00fb\1\u00fc\1\102\1\u00fe\3\102\1\u0102\1\u0103\1\102\1\u0105\2\102\1\u0108\1\u0109\1\uffff\2\102\1\u010c\2\102\2\uffff\1\u010f\1\102\2\uffff\1\u0111\2\uffff\1\u0112\1\u0113\2\uffff\1\u0114\1\uffff\1\102\1\u0116\1\102\2\uffff\1\102\1\uffff\1\u0119\1\u011a\2\uffff\1\u011b\1\u011c\1\uffff\2\102\1\uffff\1\102\4\uffff\1\102\1\uffff\1\u0121\1\u0122\4\uffff\1\102\1\u0124\1\u0125\1\u0126\2\uffff\1\u0127\4\uffff";
    static final String DFA26_eofS =
        "\u0128\uffff";
    static final String DFA26_minS =
        "\1\0\1\56\1\146\1\165\1\53\1\55\1\74\1\75\1\52\1\74\1\75\1\46\2\75\1\uffff\1\75\1\uffff\2\60\1\162\3\uffff\1\56\3\uffff\1\141\2\uffff\2\56\1\uffff\1\56\1\60\1\145\1\154\1\145\1\157\2\56\1\60\1\56\2\60\1\56\4\60\1\123\1\uffff\2\0\6\uffff\1\56\1\60\1\uffff\1\56\1\160\1\60\1\uffff\1\164\17\uffff\1\75\1\uffff\1\75\16\uffff\1\147\1\141\1\151\1\164\1\141\1\uffff\1\163\1\60\1\uffff\1\157\3\uffff\2\157\1\56\3\uffff\1\155\1\143\2\uffff\1\163\1\162\1\165\1\56\1\156\1\uffff\1\145\1\157\1\143\1\uffff\1\163\1\157\1\170\1\60\1\151\1\165\1\uffff\1\56\2\60\1\uffff\1\60\1\uffff\2\60\4\uffff\1\165\1\60\1\uffff\1\160\4\uffff\1\156\1\162\1\160\1\164\1\60\2\162\1\151\1\uffff\1\143\1\155\1\141\1\145\1\164\1\145\1\157\1\155\1\145\1\163\1\141\1\154\1\160\1\141\1\147\1\145\1\142\1\164\1\uffff\1\144\1\142\1\uffff\1\53\1\60\2\uffff\1\164\1\uffff\1\165\2\145\1\164\1\60\1\143\1\uffff\1\145\1\164\1\147\1\162\2\60\1\164\1\157\2\60\1\162\2\60\1\164\1\153\2\60\1\154\1\60\1\141\1\164\1\141\2\60\1\154\1\60\1\164\1\144\2\60\1\uffff\1\150\1\144\1\60\1\156\1\141\2\uffff\1\60\1\165\2\uffff\1\60\2\uffff\2\60\2\uffff\1\60\1\uffff\1\162\1\60\1\154\2\uffff\1\145\1\uffff\2\60\2\uffff\2\60\1\uffff\1\145\1\155\1\uffff\1\164\4\uffff\1\164\1\uffff\2\60\4\uffff\1\144\3\60\2\uffff\1\60\4\uffff";
    static final String DFA26_maxS =
        "\1\uffff\1\170\1\156\1\165\5\75\1\74\1\76\1\75\1\172\1\174\1\uffff\1\75\1\uffff\2\172\1\162\3\uffff\1\162\3\uffff\1\151\2\uffff\1\162\1\157\1\uffff\1\162\1\172\1\145\1\154\1\163\1\157\1\172\2\146\3\172\1\146\4\172\1\123\1\uffff\2\uffff\6\uffff\2\146\1\uffff\1\146\1\164\1\172\1\uffff\1\164\17\uffff\1\75\1\uffff\1\75\16\uffff\1\147\1\157\1\151\1\164\1\157\1\uffff\1\163\1\172\1\uffff\1\157\3\uffff\2\157\1\146\3\uffff\1\155\1\143\2\uffff\1\163\1\162\1\165\1\163\1\156\1\uffff\1\145\2\157\1\uffff\1\163\1\157\1\170\1\172\1\151\1\165\1\uffff\1\146\1\160\1\172\1\uffff\1\172\1\uffff\2\172\4\uffff\1\165\1\172\1\uffff\1\160\4\uffff\1\156\1\164\1\160\1\164\1\172\2\162\1\151\1\uffff\1\147\1\155\1\141\1\145\1\164\1\145\1\157\1\155\1\145\1\163\1\141\1\154\1\160\1\141\1\147\1\164\1\142\1\164\1\uffff\1\144\1\142\1\uffff\1\55\1\160\2\uffff\1\164\1\uffff\1\165\2\145\1\164\1\172\1\143\1\uffff\1\145\1\164\1\147\1\162\2\172\1\164\1\157\2\172\1\162\2\172\1\164\1\153\2\172\1\154\1\172\1\141\1\164\1\141\2\172\1\154\1\172\1\164\1\144\2\172\1\uffff\1\150\1\144\1\172\1\156\1\141\2\uffff\1\172\1\165\2\uffff\1\172\2\uffff\2\172\2\uffff\1\172\1\uffff\1\162\1\172\1\154\2\uffff\1\145\1\uffff\2\172\2\uffff\2\172\1\uffff\1\145\1\155\1\uffff\1\164\4\uffff\1\164\1\uffff\2\172\4\uffff\1\144\3\172\2\uffff\1\172\4\uffff";
    static final String DFA26_acceptS =
        "\16\uffff\1\23\1\uffff\1\37\3\uffff\1\43\1\44\1\46\1\uffff\1\50\1\51\1\52\1\uffff\1\56\1\57\2\uffff\1\63\22\uffff\1\135\2\uffff\1\142\1\143\1\1\1\2\1\123\1\121\2\uffff\1\120\3\uffff\1\135\1\uffff\1\5\1\12\1\21\1\6\1\13\1\22\1\27\1\31\1\7\1\10\1\35\1\11\1\140\1\141\1\36\1\uffff\1\25\1\uffff\1\30\1\26\1\16\1\103\1\106\1\17\1\105\1\20\1\102\1\104\1\23\1\32\1\24\1\37\5\uffff\1\131\2\uffff\1\125\1\uffff\1\43\1\44\1\46\3\uffff\1\50\1\51\1\52\2\uffff\1\56\1\57\5\uffff\1\63\3\uffff\1\124\6\uffff\1\126\3\uffff\1\127\1\uffff\1\130\2\uffff\1\137\1\142\1\122\1\136\2\uffff\1\55\1\uffff\1\14\1\34\1\15\1\33\10\uffff\1\133\22\uffff\1\134\2\uffff\1\117\2\uffff\1\117\1\132\1\uffff\1\113\6\uffff\1\73\36\uffff\1\66\5\uffff\1\45\1\47\2\uffff\1\116\1\60\1\uffff\1\75\1\62\2\uffff\1\115\1\70\1\uffff\1\114\3\uffff\1\101\1\107\1\uffff\1\3\2\uffff\1\53\1\65\2\uffff\1\112\2\uffff\1\110\1\uffff\1\67\1\74\1\64\1\76\1\uffff\1\72\2\uffff\1\4\1\40\1\61\1\100\4\uffff\1\77\1\111\1\uffff\1\42\1\54\1\71\1\41";
    static final String DFA26_specialS =
        "\1\0\63\uffff\1\1\1\2\u00f2\uffff}>";
    static final String[] DFA26_transitionS = {
            "\11\67\2\66\2\67\1\66\22\67\1\66\1\17\1\64\2\67\1\20\1\13\1\65\1\34\1\35\1\7\1\4\1\30\1\5\1\51\1\10\1\1\11\50\1\40\1\26\1\11\1\6\1\12\2\67\3\55\1\52\2\55\1\63\1\56\3\63\1\53\1\57\1\62\4\63\1\60\1\63\1\54\5\63\1\31\1\67\1\32\1\14\1\63\1\67\1\55\1\41\1\37\1\47\1\36\1\27\1\44\1\56\1\2\2\63\1\42\1\61\1\45\1\3\1\23\1\63\1\43\1\21\1\33\1\22\1\46\4\63\1\24\1\15\1\25\1\16\uff81\67",
            "\1\75\1\uffff\10\74\2\77\7\uffff\6\76\15\uffff\1\71\3\uffff\1\72\10\uffff\6\76\15\uffff\1\70\3\uffff\1\72",
            "\1\101\7\uffff\1\100",
            "\1\103",
            "\1\104\21\uffff\1\105",
            "\1\107\17\uffff\1\110",
            "\1\112\1\113",
            "\1\115",
            "\1\120\4\uffff\1\121\15\uffff\1\117",
            "\1\123",
            "\1\126\1\125",
            "\1\131\26\uffff\1\130",
            "\1\133\3\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\135\76\uffff\1\136",
            "",
            "\1\141",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\4\102\1\147\2\102\1\150\1\144\12\102\1\145\2\102\1\146\3\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\15\102\1\152\4\102\1\153\7\102",
            "\1\155",
            "",
            "",
            "",
            "\1\76\1\uffff\12\163\7\uffff\6\163\32\uffff\6\163\5\uffff\1\162\5\uffff\1\161",
            "",
            "",
            "",
            "\1\170\7\uffff\1\167",
            "",
            "",
            "\1\76\1\uffff\12\163\7\uffff\6\163\32\uffff\6\163\5\uffff\1\173\1\uffff\1\175\3\uffff\1\174",
            "\1\76\1\uffff\12\163\7\uffff\6\163\32\uffff\1\176\5\163\10\uffff\1\177",
            "",
            "\1\76\1\uffff\12\163\7\uffff\6\163\32\uffff\6\163\10\uffff\1\u0082\2\uffff\1\u0081",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\16\102\1\u0083\13\102",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087\15\uffff\1\u0088",
            "\1\u0089",
            "\1\76\1\uffff\12\163\7\uffff\6\163\24\102\4\uffff\1\102\1\uffff\6\163\10\102\1\u008a\13\102",
            "\1\75\1\uffff\12\u008c\7\uffff\6\76\32\uffff\6\76",
            "\12\u008d\7\uffff\6\76\32\uffff\6\76",
            "\1\76\1\uffff\12\163\7\uffff\6\163\24\102\4\uffff\1\102\1\uffff\6\163\24\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\22\102\1\u008e\7\102\4\uffff\1\102\1\uffff\32\102",
            "\1\76\1\uffff\12\163\7\uffff\6\163\32\uffff\6\163",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\22\102\1\u0090\7\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\22\102\1\u0092\7\102",
            "\1\u0093",
            "",
            "\0\u0094",
            "\0\u0094",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\75\1\uffff\10\74\2\77\7\uffff\6\76\32\uffff\6\76",
            "\12\u008d\7\uffff\6\76\32\uffff\6\76",
            "",
            "\1\75\1\uffff\12\77\7\uffff\6\76\32\uffff\6\76",
            "\1\u0098\3\uffff\1\u0099",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u009b",
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
            "\1\u009c",
            "",
            "\1\u009e",
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
            "\1\u00a0",
            "\1\u00a1\15\uffff\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5\15\uffff\1\u00a6",
            "",
            "\1\u00a7",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u00a9",
            "",
            "",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "\1\76\1\uffff\12\163\7\uffff\6\163\32\uffff\6\163",
            "",
            "",
            "",
            "\1\u00ac",
            "\1\u00ad",
            "",
            "",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\76\1\uffff\12\163\7\uffff\6\163\32\uffff\6\163\14\uffff\1\u00b1",
            "\1\u00b2",
            "",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b6\12\uffff\1\u00b7\1\u00b5",
            "",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "\1\75\1\uffff\12\u008c\7\uffff\6\76\32\uffff\6\76",
            "\12\u008d\7\uffff\4\76\1\u00bf\1\u00c0\5\uffff\1\u00c1\3\uffff\1\76\20\uffff\4\76\1\u00bf\1\u00c0\5\uffff\1\u00c1\3\uffff\1\76",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "",
            "",
            "\1\u00c3",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u00c5",
            "",
            "",
            "",
            "",
            "\1\u00c6",
            "\1\u00c8\1\uffff\1\u00c7",
            "\1\u00c9",
            "\1\u00ca",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "\1\u00d0\3\uffff\1\u00cf",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00e0\16\uffff\1\u00df",
            "\1\u00e1",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "\1\u00e4",
            "",
            "\1\u00be\1\uffff\1\u00be",
            "\12\76\7\uffff\6\76\5\uffff\1\76\3\uffff\1\76\20\uffff\6\76\5\uffff\1\76\3\uffff\1\76",
            "",
            "",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00eb",
            "",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00f2",
            "\1\u00f3",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00f6",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00f9",
            "\1\u00fa",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00fd",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0104",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0106",
            "\1\u0107",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u010a",
            "\1\u010b",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u010d",
            "\1\u010e",
            "",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0110",
            "",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u0115",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\1\u0117",
            "",
            "",
            "\1\u0118",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "\1\u011d",
            "\1\u011e",
            "",
            "\1\u011f",
            "",
            "",
            "",
            "",
            "\1\u0120",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "",
            "",
            "\1\u0123",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
            "",
            "",
            "\12\102\7\uffff\32\102\4\uffff\1\102\1\uffff\32\102",
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
            return "1:1: Tokens : ( T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | RULE_LOGICAL_OR | RULE_LOGICAL_AND | RULE_BIT_OR | RULE_BIT_XOR | RULE_BIT_AND | RULE_VOID_C_TYPE | RULE_FLOAT_C_TYPE | RULE_DOUBLE_C_TYPE | RULE_SHORT_C_TYPE | RULE_INT_C_TYPE | RULE_LONG_C_TYPE | RULE_BOOL_TYPE | RULE_TACT | RULE_DEC_FLOAT | RULE_HEX_FLOAT | RULE_DECIMAL | RULE_OCTAL | RULE_HEX | RULE_LONG | RULE_UNSIGNED | RULE_DAY | RULE_HOUR | RULE_MINUTE | RULE_SECOND | RULE_MILISECOND | RULE_MICROSECOND | RULE_NANOSECOND | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_0 = input.LA(1);

                        s = -1;
                        if ( (LA26_0=='0') ) {s = 1;}

                        else if ( (LA26_0=='i') ) {s = 2;}

                        else if ( (LA26_0=='o') ) {s = 3;}

                        else if ( (LA26_0=='+') ) {s = 4;}

                        else if ( (LA26_0=='-') ) {s = 5;}

                        else if ( (LA26_0=='=') ) {s = 6;}

                        else if ( (LA26_0=='*') ) {s = 7;}

                        else if ( (LA26_0=='/') ) {s = 8;}

                        else if ( (LA26_0=='<') ) {s = 9;}

                        else if ( (LA26_0=='>') ) {s = 10;}

                        else if ( (LA26_0=='&') ) {s = 11;}

                        else if ( (LA26_0=='^') ) {s = 12;}

                        else if ( (LA26_0=='|') ) {s = 13;}

                        else if ( (LA26_0=='~') ) {s = 14;}

                        else if ( (LA26_0=='!') ) {s = 15;}

                        else if ( (LA26_0=='%') ) {s = 16;}

                        else if ( (LA26_0=='s') ) {s = 17;}

                        else if ( (LA26_0=='u') ) {s = 18;}

                        else if ( (LA26_0=='p') ) {s = 19;}

                        else if ( (LA26_0=='{') ) {s = 20;}

                        else if ( (LA26_0=='}') ) {s = 21;}

                        else if ( (LA26_0==';') ) {s = 22;}

                        else if ( (LA26_0=='f') ) {s = 23;}

                        else if ( (LA26_0==',') ) {s = 24;}

                        else if ( (LA26_0=='[') ) {s = 25;}

                        else if ( (LA26_0==']') ) {s = 26;}

                        else if ( (LA26_0=='t') ) {s = 27;}

                        else if ( (LA26_0=='(') ) {s = 28;}

                        else if ( (LA26_0==')') ) {s = 29;}

                        else if ( (LA26_0=='e') ) {s = 30;}

                        else if ( (LA26_0=='c') ) {s = 31;}

                        else if ( (LA26_0==':') ) {s = 32;}

                        else if ( (LA26_0=='b') ) {s = 33;}

                        else if ( (LA26_0=='l') ) {s = 34;}

                        else if ( (LA26_0=='r') ) {s = 35;}

                        else if ( (LA26_0=='g') ) {s = 36;}

                        else if ( (LA26_0=='n') ) {s = 37;}

                        else if ( (LA26_0=='v') ) {s = 38;}

                        else if ( (LA26_0=='d') ) {s = 39;}

                        else if ( ((LA26_0>='1' && LA26_0<='9')) ) {s = 40;}

                        else if ( (LA26_0=='.') ) {s = 41;}

                        else if ( (LA26_0=='D') ) {s = 42;}

                        else if ( (LA26_0=='L') ) {s = 43;}

                        else if ( (LA26_0=='U') ) {s = 44;}

                        else if ( ((LA26_0>='A' && LA26_0<='C')||(LA26_0>='E' && LA26_0<='F')||LA26_0=='a') ) {s = 45;}

                        else if ( (LA26_0=='H'||LA26_0=='h') ) {s = 46;}

                        else if ( (LA26_0=='M') ) {s = 47;}

                        else if ( (LA26_0=='S') ) {s = 48;}

                        else if ( (LA26_0=='m') ) {s = 49;}

                        else if ( (LA26_0=='N') ) {s = 50;}

                        else if ( (LA26_0=='G'||(LA26_0>='I' && LA26_0<='K')||(LA26_0>='O' && LA26_0<='R')||LA26_0=='T'||(LA26_0>='V' && LA26_0<='Z')||LA26_0=='_'||(LA26_0>='j' && LA26_0<='k')||LA26_0=='q'||(LA26_0>='w' && LA26_0<='z')) ) {s = 51;}

                        else if ( (LA26_0=='\"') ) {s = 52;}

                        else if ( (LA26_0=='\'') ) {s = 53;}

                        else if ( ((LA26_0>='\t' && LA26_0<='\n')||LA26_0=='\r'||LA26_0==' ') ) {s = 54;}

                        else if ( ((LA26_0>='\u0000' && LA26_0<='\b')||(LA26_0>='\u000B' && LA26_0<='\f')||(LA26_0>='\u000E' && LA26_0<='\u001F')||(LA26_0>='#' && LA26_0<='$')||(LA26_0>='?' && LA26_0<='@')||LA26_0=='\\'||LA26_0=='`'||(LA26_0>='\u007F' && LA26_0<='\uFFFF')) ) {s = 55;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_52 = input.LA(1);

                        s = -1;
                        if ( ((LA26_52>='\u0000' && LA26_52<='\uFFFF')) ) {s = 148;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_53 = input.LA(1);

                        s = -1;
                        if ( ((LA26_53>='\u0000' && LA26_53<='\uFFFF')) ) {s = 148;}

                        else s = 55;

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