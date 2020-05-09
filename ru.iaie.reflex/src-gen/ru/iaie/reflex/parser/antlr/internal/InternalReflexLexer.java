package ru.iaie.reflex.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReflexLexer extends Lexer {
    public static final int RULE_HEX=14;
    public static final int T__50=50;
    public static final int RULE_SIGN=23;
    public static final int RULE_DEC_SEQUENCE=21;
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
    public static final int RULE_ID=4;
    public static final int RULE_HEX_FLOAT=20;
    public static final int RULE_INT=28;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=29;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int RULE_HEX_SEQUENCE=25;
    public static final int RULE_UNSIGNED=18;
    public static final int RULE_BOOL_LITERAL=7;
    public static final int RULE_BIN_EXPONENT=26;
    public static final int RULE_LOGICAL_AND=11;
    public static final int RULE_EXPONENT=22;
    public static final int T__48=48;
    public static final int RULE_DEC_FLOAT=19;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=6;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int RULE_BIT_AND=8;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_OCTAL=15;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DECIMAL=16;
    public static final int RULE_LOGICAL_OR=12;
    public static final int RULE_FLOAT_SUFFIX=24;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=13;
    public static final int RULE_SL_COMMENT=30;
    public static final int RULE_HEX_PREFIX=27;
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
    public static final int RULE_WS=31;
    public static final int RULE_ANY_OTHER=32;
    public static final int T__88=88;
    public static final int RULE_BIT_XOR=9;
    public static final int T__89=89;
    public static final int RULE_BIT_OR=10;
    public static final int RULE_LONG=17;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=5;
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

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:11:7: ( '[' )
            // InternalReflex.g:11:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:12:7: ( ']' )
            // InternalReflex.g:12:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:13:7: ( 'program' )
            // InternalReflex.g:13:9: 'program'
            {
            match("program"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:14:7: ( '{' )
            // InternalReflex.g:14:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:15:7: ( '}' )
            // InternalReflex.g:15:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:16:7: ( 'clock' )
            // InternalReflex.g:16:9: 'clock'
            {
            match("clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:17:7: ( ';' )
            // InternalReflex.g:17:9: ';'
            {
            match(';'); 

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
            // InternalReflex.g:18:7: ( 'process' )
            // InternalReflex.g:18:9: 'process'
            {
            match("process"); 


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
            // InternalReflex.g:19:7: ( 'state' )
            // InternalReflex.g:19:9: 'state'
            {
            match("state"); 


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
            // InternalReflex.g:20:7: ( 'looped' )
            // InternalReflex.g:20:9: 'looped'
            {
            match("looped"); 


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
            // InternalReflex.g:21:7: ( 'shared' )
            // InternalReflex.g:21:9: 'shared'
            {
            match("shared"); 


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
            // InternalReflex.g:22:7: ( ',' )
            // InternalReflex.g:22:9: ','
            {
            match(','); 

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
            // InternalReflex.g:23:7: ( 'from' )
            // InternalReflex.g:23:9: 'from'
            {
            match("from"); 


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
            // InternalReflex.g:24:7: ( '=' )
            // InternalReflex.g:24:9: '='
            {
            match('='); 

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
            // InternalReflex.g:25:7: ( 'timeout' )
            // InternalReflex.g:25:9: 'timeout'
            {
            match("timeout"); 


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
            // InternalReflex.g:26:7: ( '(' )
            // InternalReflex.g:26:9: '('
            {
            match('('); 

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
            // InternalReflex.g:27:7: ( ')' )
            // InternalReflex.g:27:9: ')'
            {
            match(')'); 

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
            // InternalReflex.g:28:7: ( 'if' )
            // InternalReflex.g:28:9: 'if'
            {
            match("if"); 


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
            // InternalReflex.g:29:7: ( 'else' )
            // InternalReflex.g:29:9: 'else'
            {
            match("else"); 


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
            // InternalReflex.g:30:7: ( 'switch' )
            // InternalReflex.g:30:9: 'switch'
            {
            match("switch"); 


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
            // InternalReflex.g:31:7: ( 'case' )
            // InternalReflex.g:31:9: 'case'
            {
            match("case"); 


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
            // InternalReflex.g:32:7: ( ':' )
            // InternalReflex.g:32:9: ':'
            {
            match(':'); 

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
            // InternalReflex.g:33:7: ( 'break' )
            // InternalReflex.g:33:9: 'break'
            {
            match("break"); 


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
            // InternalReflex.g:34:7: ( 'start' )
            // InternalReflex.g:34:9: 'start'
            {
            match("start"); 


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
            // InternalReflex.g:35:7: ( 'stop' )
            // InternalReflex.g:35:9: 'stop'
            {
            match("stop"); 


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
            // InternalReflex.g:36:7: ( 'error' )
            // InternalReflex.g:36:9: 'error'
            {
            match("error"); 


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
            // InternalReflex.g:37:7: ( 'restart' )
            // InternalReflex.g:37:9: 'restart'
            {
            match("restart"); 


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
            // InternalReflex.g:38:7: ( 'reset' )
            // InternalReflex.g:38:9: 'reset'
            {
            match("reset"); 


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
            // InternalReflex.g:39:7: ( 'timer' )
            // InternalReflex.g:39:9: 'timer'
            {
            match("timer"); 


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
            // InternalReflex.g:40:7: ( 'set' )
            // InternalReflex.g:40:9: 'set'
            {
            match("set"); 


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
            // InternalReflex.g:41:7: ( 'next' )
            // InternalReflex.g:41:9: 'next'
            {
            match("next"); 


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
            // InternalReflex.g:42:7: ( 'const' )
            // InternalReflex.g:42:9: 'const'
            {
            match("const"); 


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
            // InternalReflex.g:43:7: ( 'enum' )
            // InternalReflex.g:43:9: 'enum'
            {
            match("enum"); 


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
            // InternalReflex.g:44:7: ( 'in' )
            // InternalReflex.g:44:9: 'in'
            {
            match("in"); 


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
            // InternalReflex.g:45:7: ( '.' )
            // InternalReflex.g:45:9: '.'
            {
            match('.'); 

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
            // InternalReflex.g:46:7: ( 'input' )
            // InternalReflex.g:46:9: 'input'
            {
            match("input"); 


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
            // InternalReflex.g:47:7: ( 'output' )
            // InternalReflex.g:47:9: 'output'
            {
            match("output"); 


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
            // InternalReflex.g:48:7: ( 'active' )
            // InternalReflex.g:48:9: 'active'
            {
            match("active"); 


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
            // InternalReflex.g:49:7: ( 'inactive' )
            // InternalReflex.g:49:9: 'inactive'
            {
            match("inactive"); 


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
            // InternalReflex.g:50:7: ( '++' )
            // InternalReflex.g:50:9: '++'
            {
            match("++"); 


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
            // InternalReflex.g:51:7: ( '--' )
            // InternalReflex.g:51:9: '--'
            {
            match("--"); 


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
            // InternalReflex.g:52:7: ( '*=' )
            // InternalReflex.g:52:9: '*='
            {
            match("*="); 


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
            // InternalReflex.g:53:7: ( '/=' )
            // InternalReflex.g:53:9: '/='
            {
            match("/="); 


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
            // InternalReflex.g:54:7: ( '+=' )
            // InternalReflex.g:54:9: '+='
            {
            match("+="); 


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
            // InternalReflex.g:55:7: ( '-=' )
            // InternalReflex.g:55:9: '-='
            {
            match("-="); 


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
            // InternalReflex.g:56:7: ( '<<=' )
            // InternalReflex.g:56:9: '<<='
            {
            match("<<="); 


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
            // InternalReflex.g:57:7: ( '>>=' )
            // InternalReflex.g:57:9: '>>='
            {
            match(">>="); 


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
            // InternalReflex.g:58:7: ( '&=' )
            // InternalReflex.g:58:9: '&='
            {
            match("&="); 


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
            // InternalReflex.g:59:7: ( '^=' )
            // InternalReflex.g:59:9: '^='
            {
            match("^="); 


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
            // InternalReflex.g:60:7: ( '|=' )
            // InternalReflex.g:60:9: '|='
            {
            match("|="); 


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
            // InternalReflex.g:61:7: ( '+' )
            // InternalReflex.g:61:9: '+'
            {
            match('+'); 

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
            // InternalReflex.g:62:7: ( '-' )
            // InternalReflex.g:62:9: '-'
            {
            match('-'); 

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
            // InternalReflex.g:63:7: ( '~' )
            // InternalReflex.g:63:9: '~'
            {
            match('~'); 

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
            // InternalReflex.g:64:7: ( '!' )
            // InternalReflex.g:64:9: '!'
            {
            match('!'); 

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
            // InternalReflex.g:65:7: ( '<' )
            // InternalReflex.g:65:9: '<'
            {
            match('<'); 

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
            // InternalReflex.g:66:7: ( '>' )
            // InternalReflex.g:66:9: '>'
            {
            match('>'); 

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
            // InternalReflex.g:67:7: ( '=<' )
            // InternalReflex.g:67:9: '=<'
            {
            match("=<"); 


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
            // InternalReflex.g:68:7: ( '>=' )
            // InternalReflex.g:68:9: '>='
            {
            match(">="); 


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
            // InternalReflex.g:69:7: ( '==' )
            // InternalReflex.g:69:9: '=='
            {
            match("=="); 


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
            // InternalReflex.g:70:7: ( '!=' )
            // InternalReflex.g:70:9: '!='
            {
            match("!="); 


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
            // InternalReflex.g:71:7: ( '>>' )
            // InternalReflex.g:71:9: '>>'
            {
            match(">>"); 


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
            // InternalReflex.g:72:7: ( '<<' )
            // InternalReflex.g:72:9: '<<'
            {
            match("<<"); 


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
            // InternalReflex.g:73:7: ( '*' )
            // InternalReflex.g:73:9: '*'
            {
            match('*'); 

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
            // InternalReflex.g:74:7: ( '/' )
            // InternalReflex.g:74:9: '/'
            {
            match('/'); 

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
            // InternalReflex.g:75:7: ( '%' )
            // InternalReflex.g:75:9: '%'
            {
            match('%'); 

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
            // InternalReflex.g:76:7: ( 'void' )
            // InternalReflex.g:76:9: 'void'
            {
            match("void"); 


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
            // InternalReflex.g:77:7: ( 'float' )
            // InternalReflex.g:77:9: 'float'
            {
            match("float"); 


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
            // InternalReflex.g:78:8: ( 'double' )
            // InternalReflex.g:78:10: 'double'
            {
            match("double"); 


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
            // InternalReflex.g:79:8: ( 'short' )
            // InternalReflex.g:79:10: 'short'
            {
            match("short"); 


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
            // InternalReflex.g:80:8: ( 'int' )
            // InternalReflex.g:80:10: 'int'
            {
            match("int"); 


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
            // InternalReflex.g:81:8: ( 'long' )
            // InternalReflex.g:81:10: 'long'
            {
            match("long"); 


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
            // InternalReflex.g:82:8: ( 'bool' )
            // InternalReflex.g:82:10: 'bool'
            {
            match("bool"); 


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
            // InternalReflex.g:83:8: ( 'signed' )
            // InternalReflex.g:83:10: 'signed'
            {
            match("signed"); 


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
            // InternalReflex.g:84:8: ( 'unsigned' )
            // InternalReflex.g:84:10: 'unsigned'
            {
            match("unsigned"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "RULE_BOOL_LITERAL"
    public final void mRULE_BOOL_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_BOOL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:4442:19: ( ( 'true' | 'false' ) )
            // InternalReflex.g:4442:21: ( 'true' | 'false' )
            {
            // InternalReflex.g:4442:21: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalReflex.g:4442:22: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4442:29: 'false'
                    {
                    match("false"); 


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
    // $ANTLR end "RULE_BOOL_LITERAL"

    // $ANTLR start "RULE_LOGICAL_OR"
    public final void mRULE_LOGICAL_OR() throws RecognitionException {
        try {
            int _type = RULE_LOGICAL_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:4444:17: ( '||' )
            // InternalReflex.g:4444:19: '||'
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
            // InternalReflex.g:4446:18: ( '&&' )
            // InternalReflex.g:4446:20: '&&'
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
            // InternalReflex.g:4448:13: ( '|' )
            // InternalReflex.g:4448:15: '|'
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
            // InternalReflex.g:4450:14: ( '^' )
            // InternalReflex.g:4450:16: '^'
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
            // InternalReflex.g:4452:14: ( '&' )
            // InternalReflex.g:4452:16: '&'
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

    // $ANTLR start "RULE_INTEGER"
    public final void mRULE_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:4454:14: ( ( RULE_HEX | RULE_OCTAL | RULE_DECIMAL ) ( RULE_LONG | RULE_UNSIGNED )? )
            // InternalReflex.g:4454:16: ( RULE_HEX | RULE_OCTAL | RULE_DECIMAL ) ( RULE_LONG | RULE_UNSIGNED )?
            {
            // InternalReflex.g:4454:16: ( RULE_HEX | RULE_OCTAL | RULE_DECIMAL )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'X':
                case 'x':
                    {
                    alt2=1;
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
                    alt2=2;
                    }
                    break;
                default:
                    alt2=3;}

            }
            else if ( ((LA2_0>='1' && LA2_0<='9')) ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalReflex.g:4454:17: RULE_HEX
                    {
                    mRULE_HEX(); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:4454:26: RULE_OCTAL
                    {
                    mRULE_OCTAL(); 

                    }
                    break;
                case 3 :
                    // InternalReflex.g:4454:37: RULE_DECIMAL
                    {
                    mRULE_DECIMAL(); 

                    }
                    break;

            }

            // InternalReflex.g:4454:51: ( RULE_LONG | RULE_UNSIGNED )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='L'||LA3_0=='U'||LA3_0=='l'||LA3_0=='u') ) {
                alt3=1;
            }
            switch (alt3) {
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
            // InternalReflex.g:4456:12: ( ( RULE_DEC_FLOAT | RULE_HEX_FLOAT ) )
            // InternalReflex.g:4456:14: ( RULE_DEC_FLOAT | RULE_HEX_FLOAT )
            {
            // InternalReflex.g:4456:14: ( RULE_DEC_FLOAT | RULE_HEX_FLOAT )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalReflex.g:4456:15: RULE_DEC_FLOAT
                    {
                    mRULE_DEC_FLOAT(); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:4456:30: RULE_HEX_FLOAT
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
            // InternalReflex.g:4458:25: ( ( RULE_DEC_SEQUENCE )? '.' RULE_DEC_SEQUENCE ( RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )? )
            // InternalReflex.g:4458:27: ( RULE_DEC_SEQUENCE )? '.' RULE_DEC_SEQUENCE ( RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            {
            // InternalReflex.g:4458:27: ( RULE_DEC_SEQUENCE )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalReflex.g:4458:27: RULE_DEC_SEQUENCE
                    {
                    mRULE_DEC_SEQUENCE(); 

                    }
                    break;

            }

            match('.'); 
            mRULE_DEC_SEQUENCE(); 
            // InternalReflex.g:4458:68: ( RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='E'||LA6_0=='e') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalReflex.g:4458:69: RULE_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE
                    {
                    mRULE_EXPONENT(); 
                    mRULE_SIGN(); 
                    mRULE_DEC_SEQUENCE(); 

                    }
                    break;

            }

            // InternalReflex.g:4458:113: ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='F'||LA7_0=='L'||LA7_0=='f'||LA7_0=='l') ) {
                alt7=1;
            }
            switch (alt7) {
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
            // InternalReflex.g:4460:25: ( ( RULE_HEX_SEQUENCE )? '.' RULE_HEX_SEQUENCE ( RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )? )
            // InternalReflex.g:4460:27: ( RULE_HEX_SEQUENCE )? '.' RULE_HEX_SEQUENCE ( RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )? ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            {
            // InternalReflex.g:4460:27: ( RULE_HEX_SEQUENCE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='F')||(LA8_0>='a' && LA8_0<='f')) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalReflex.g:4460:27: RULE_HEX_SEQUENCE
                    {
                    mRULE_HEX_SEQUENCE(); 

                    }
                    break;

            }

            match('.'); 
            mRULE_HEX_SEQUENCE(); 
            // InternalReflex.g:4460:68: ( RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='P'||LA9_0=='p') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalReflex.g:4460:69: RULE_BIN_EXPONENT RULE_SIGN RULE_DEC_SEQUENCE
                    {
                    mRULE_BIN_EXPONENT(); 
                    mRULE_SIGN(); 
                    mRULE_DEC_SEQUENCE(); 

                    }
                    break;

            }

            // InternalReflex.g:4460:117: ( RULE_LONG | RULE_FLOAT_SUFFIX )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='F'||LA10_0=='L'||LA10_0=='f'||LA10_0=='l') ) {
                alt10=1;
            }
            switch (alt10) {
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
            // InternalReflex.g:4462:28: ( ( '0' .. '9' )+ )
            // InternalReflex.g:4462:30: ( '0' .. '9' )+
            {
            // InternalReflex.g:4462:30: ( '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalReflex.g:4462:31: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_DEC_SEQUENCE"

    // $ANTLR start "RULE_HEX_SEQUENCE"
    public final void mRULE_HEX_SEQUENCE() throws RecognitionException {
        try {
            // InternalReflex.g:4464:28: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalReflex.g:4464:30: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            // InternalReflex.g:4464:30: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')||(LA12_0>='A' && LA12_0<='F')||(LA12_0>='a' && LA12_0<='f')) ) {
                    alt12=1;
                }


                switch (alt12) {
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
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
            // InternalReflex.g:4466:28: ( ( 'p' | 'P' ) )
            // InternalReflex.g:4466:30: ( 'p' | 'P' )
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
            // InternalReflex.g:4468:24: ( ( 'e' | 'E' ) )
            // InternalReflex.g:4468:26: ( 'e' | 'E' )
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
            // InternalReflex.g:4470:20: ( ( '+' | '-' ) )
            // InternalReflex.g:4470:22: ( '+' | '-' )
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
            // InternalReflex.g:4472:23: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) )
            // InternalReflex.g:4472:25: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            {
            // InternalReflex.g:4472:25: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='0') ) {
                alt14=1;
            }
            else if ( ((LA14_0>='1' && LA14_0<='9')) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalReflex.g:4472:26: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:4472:30: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // InternalReflex.g:4472:39: ( '0' .. '9' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalReflex.g:4472:40: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
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
            // InternalReflex.g:4474:21: ( '0' ( '0' .. '7' )+ )
            // InternalReflex.g:4474:23: '0' ( '0' .. '7' )+
            {
            match('0'); 
            // InternalReflex.g:4474:27: ( '0' .. '7' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='7')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalReflex.g:4474:28: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
            // InternalReflex.g:4476:19: ( RULE_HEX_PREFIX RULE_HEX_SEQUENCE )
            // InternalReflex.g:4476:21: RULE_HEX_PREFIX RULE_HEX_SEQUENCE
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
            // InternalReflex.g:4478:26: ( '0' ( 'x' | 'X' ) )
            // InternalReflex.g:4478:28: '0' ( 'x' | 'X' )
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
            // InternalReflex.g:4480:20: ( ( 'L' | 'l' ) )
            // InternalReflex.g:4480:22: ( 'L' | 'l' )
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
            // InternalReflex.g:4482:28: ( ( 'F' | 'f' ) )
            // InternalReflex.g:4482:30: ( 'F' | 'f' )
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
            // InternalReflex.g:4484:24: ( ( 'U' | 'u' ) )
            // InternalReflex.g:4484:26: ( 'U' | 'u' )
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
            // InternalReflex.g:4486:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalReflex.g:4486:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalReflex.g:4486:11: ( '^' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='^') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalReflex.g:4486:11: '^'
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

            // InternalReflex.g:4486:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='0' && LA17_0<='9')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
                    alt17=1;
                }


                switch (alt17) {
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
            	    break loop17;
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
            // InternalReflex.g:4488:10: ( ( '0' .. '9' )+ )
            // InternalReflex.g:4488:12: ( '0' .. '9' )+
            {
            // InternalReflex.g:4488:12: ( '0' .. '9' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalReflex.g:4488:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
            // InternalReflex.g:4490:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalReflex.g:4490:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalReflex.g:4490:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\"') ) {
                alt21=1;
            }
            else if ( (LA21_0=='\'') ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalReflex.g:4490:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalReflex.g:4490:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop19:
                    do {
                        int alt19=3;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='\\') ) {
                            alt19=1;
                        }
                        else if ( ((LA19_0>='\u0000' && LA19_0<='!')||(LA19_0>='#' && LA19_0<='[')||(LA19_0>=']' && LA19_0<='\uFFFF')) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalReflex.g:4490:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:4490:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop19;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:4490:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalReflex.g:4490:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop20:
                    do {
                        int alt20=3;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='\\') ) {
                            alt20=1;
                        }
                        else if ( ((LA20_0>='\u0000' && LA20_0<='&')||(LA20_0>='(' && LA20_0<='[')||(LA20_0>=']' && LA20_0<='\uFFFF')) ) {
                            alt20=2;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalReflex.g:4490:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:4490:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop20;
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
            // InternalReflex.g:4492:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalReflex.g:4492:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalReflex.g:4492:24: ( options {greedy=false; } : . )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='*') ) {
                    int LA22_1 = input.LA(2);

                    if ( (LA22_1=='/') ) {
                        alt22=2;
                    }
                    else if ( ((LA22_1>='\u0000' && LA22_1<='.')||(LA22_1>='0' && LA22_1<='\uFFFF')) ) {
                        alt22=1;
                    }


                }
                else if ( ((LA22_0>='\u0000' && LA22_0<=')')||(LA22_0>='+' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalReflex.g:4492:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop22;
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
            // InternalReflex.g:4494:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalReflex.g:4494:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalReflex.g:4494:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='\u0000' && LA23_0<='\t')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\uFFFF')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalReflex.g:4494:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop23;
                }
            } while (true);

            // InternalReflex.g:4494:40: ( ( '\\r' )? '\\n' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='\n'||LA25_0=='\r') ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalReflex.g:4494:41: ( '\\r' )? '\\n'
                    {
                    // InternalReflex.g:4494:41: ( '\\r' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='\r') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalReflex.g:4494:41: '\\r'
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
            // InternalReflex.g:4496:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalReflex.g:4496:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalReflex.g:4496:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>='\t' && LA26_0<='\n')||LA26_0=='\r'||LA26_0==' ') ) {
                    alt26=1;
                }


                switch (alt26) {
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
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
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
            // InternalReflex.g:4498:16: ( . )
            // InternalReflex.g:4498:18: .
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
        // InternalReflex.g:1:8: ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | RULE_BOOL_LITERAL | RULE_LOGICAL_OR | RULE_LOGICAL_AND | RULE_BIT_OR | RULE_BIT_XOR | RULE_BIT_AND | RULE_INTEGER | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt27=89;
        alt27 = dfa27.predict(input);
        switch (alt27) {
            case 1 :
                // InternalReflex.g:1:10: T__33
                {
                mT__33(); 

                }
                break;
            case 2 :
                // InternalReflex.g:1:16: T__34
                {
                mT__34(); 

                }
                break;
            case 3 :
                // InternalReflex.g:1:22: T__35
                {
                mT__35(); 

                }
                break;
            case 4 :
                // InternalReflex.g:1:28: T__36
                {
                mT__36(); 

                }
                break;
            case 5 :
                // InternalReflex.g:1:34: T__37
                {
                mT__37(); 

                }
                break;
            case 6 :
                // InternalReflex.g:1:40: T__38
                {
                mT__38(); 

                }
                break;
            case 7 :
                // InternalReflex.g:1:46: T__39
                {
                mT__39(); 

                }
                break;
            case 8 :
                // InternalReflex.g:1:52: T__40
                {
                mT__40(); 

                }
                break;
            case 9 :
                // InternalReflex.g:1:58: T__41
                {
                mT__41(); 

                }
                break;
            case 10 :
                // InternalReflex.g:1:64: T__42
                {
                mT__42(); 

                }
                break;
            case 11 :
                // InternalReflex.g:1:70: T__43
                {
                mT__43(); 

                }
                break;
            case 12 :
                // InternalReflex.g:1:76: T__44
                {
                mT__44(); 

                }
                break;
            case 13 :
                // InternalReflex.g:1:82: T__45
                {
                mT__45(); 

                }
                break;
            case 14 :
                // InternalReflex.g:1:88: T__46
                {
                mT__46(); 

                }
                break;
            case 15 :
                // InternalReflex.g:1:94: T__47
                {
                mT__47(); 

                }
                break;
            case 16 :
                // InternalReflex.g:1:100: T__48
                {
                mT__48(); 

                }
                break;
            case 17 :
                // InternalReflex.g:1:106: T__49
                {
                mT__49(); 

                }
                break;
            case 18 :
                // InternalReflex.g:1:112: T__50
                {
                mT__50(); 

                }
                break;
            case 19 :
                // InternalReflex.g:1:118: T__51
                {
                mT__51(); 

                }
                break;
            case 20 :
                // InternalReflex.g:1:124: T__52
                {
                mT__52(); 

                }
                break;
            case 21 :
                // InternalReflex.g:1:130: T__53
                {
                mT__53(); 

                }
                break;
            case 22 :
                // InternalReflex.g:1:136: T__54
                {
                mT__54(); 

                }
                break;
            case 23 :
                // InternalReflex.g:1:142: T__55
                {
                mT__55(); 

                }
                break;
            case 24 :
                // InternalReflex.g:1:148: T__56
                {
                mT__56(); 

                }
                break;
            case 25 :
                // InternalReflex.g:1:154: T__57
                {
                mT__57(); 

                }
                break;
            case 26 :
                // InternalReflex.g:1:160: T__58
                {
                mT__58(); 

                }
                break;
            case 27 :
                // InternalReflex.g:1:166: T__59
                {
                mT__59(); 

                }
                break;
            case 28 :
                // InternalReflex.g:1:172: T__60
                {
                mT__60(); 

                }
                break;
            case 29 :
                // InternalReflex.g:1:178: T__61
                {
                mT__61(); 

                }
                break;
            case 30 :
                // InternalReflex.g:1:184: T__62
                {
                mT__62(); 

                }
                break;
            case 31 :
                // InternalReflex.g:1:190: T__63
                {
                mT__63(); 

                }
                break;
            case 32 :
                // InternalReflex.g:1:196: T__64
                {
                mT__64(); 

                }
                break;
            case 33 :
                // InternalReflex.g:1:202: T__65
                {
                mT__65(); 

                }
                break;
            case 34 :
                // InternalReflex.g:1:208: T__66
                {
                mT__66(); 

                }
                break;
            case 35 :
                // InternalReflex.g:1:214: T__67
                {
                mT__67(); 

                }
                break;
            case 36 :
                // InternalReflex.g:1:220: T__68
                {
                mT__68(); 

                }
                break;
            case 37 :
                // InternalReflex.g:1:226: T__69
                {
                mT__69(); 

                }
                break;
            case 38 :
                // InternalReflex.g:1:232: T__70
                {
                mT__70(); 

                }
                break;
            case 39 :
                // InternalReflex.g:1:238: T__71
                {
                mT__71(); 

                }
                break;
            case 40 :
                // InternalReflex.g:1:244: T__72
                {
                mT__72(); 

                }
                break;
            case 41 :
                // InternalReflex.g:1:250: T__73
                {
                mT__73(); 

                }
                break;
            case 42 :
                // InternalReflex.g:1:256: T__74
                {
                mT__74(); 

                }
                break;
            case 43 :
                // InternalReflex.g:1:262: T__75
                {
                mT__75(); 

                }
                break;
            case 44 :
                // InternalReflex.g:1:268: T__76
                {
                mT__76(); 

                }
                break;
            case 45 :
                // InternalReflex.g:1:274: T__77
                {
                mT__77(); 

                }
                break;
            case 46 :
                // InternalReflex.g:1:280: T__78
                {
                mT__78(); 

                }
                break;
            case 47 :
                // InternalReflex.g:1:286: T__79
                {
                mT__79(); 

                }
                break;
            case 48 :
                // InternalReflex.g:1:292: T__80
                {
                mT__80(); 

                }
                break;
            case 49 :
                // InternalReflex.g:1:298: T__81
                {
                mT__81(); 

                }
                break;
            case 50 :
                // InternalReflex.g:1:304: T__82
                {
                mT__82(); 

                }
                break;
            case 51 :
                // InternalReflex.g:1:310: T__83
                {
                mT__83(); 

                }
                break;
            case 52 :
                // InternalReflex.g:1:316: T__84
                {
                mT__84(); 

                }
                break;
            case 53 :
                // InternalReflex.g:1:322: T__85
                {
                mT__85(); 

                }
                break;
            case 54 :
                // InternalReflex.g:1:328: T__86
                {
                mT__86(); 

                }
                break;
            case 55 :
                // InternalReflex.g:1:334: T__87
                {
                mT__87(); 

                }
                break;
            case 56 :
                // InternalReflex.g:1:340: T__88
                {
                mT__88(); 

                }
                break;
            case 57 :
                // InternalReflex.g:1:346: T__89
                {
                mT__89(); 

                }
                break;
            case 58 :
                // InternalReflex.g:1:352: T__90
                {
                mT__90(); 

                }
                break;
            case 59 :
                // InternalReflex.g:1:358: T__91
                {
                mT__91(); 

                }
                break;
            case 60 :
                // InternalReflex.g:1:364: T__92
                {
                mT__92(); 

                }
                break;
            case 61 :
                // InternalReflex.g:1:370: T__93
                {
                mT__93(); 

                }
                break;
            case 62 :
                // InternalReflex.g:1:376: T__94
                {
                mT__94(); 

                }
                break;
            case 63 :
                // InternalReflex.g:1:382: T__95
                {
                mT__95(); 

                }
                break;
            case 64 :
                // InternalReflex.g:1:388: T__96
                {
                mT__96(); 

                }
                break;
            case 65 :
                // InternalReflex.g:1:394: T__97
                {
                mT__97(); 

                }
                break;
            case 66 :
                // InternalReflex.g:1:400: T__98
                {
                mT__98(); 

                }
                break;
            case 67 :
                // InternalReflex.g:1:406: T__99
                {
                mT__99(); 

                }
                break;
            case 68 :
                // InternalReflex.g:1:412: T__100
                {
                mT__100(); 

                }
                break;
            case 69 :
                // InternalReflex.g:1:419: T__101
                {
                mT__101(); 

                }
                break;
            case 70 :
                // InternalReflex.g:1:426: T__102
                {
                mT__102(); 

                }
                break;
            case 71 :
                // InternalReflex.g:1:433: T__103
                {
                mT__103(); 

                }
                break;
            case 72 :
                // InternalReflex.g:1:440: T__104
                {
                mT__104(); 

                }
                break;
            case 73 :
                // InternalReflex.g:1:447: T__105
                {
                mT__105(); 

                }
                break;
            case 74 :
                // InternalReflex.g:1:454: T__106
                {
                mT__106(); 

                }
                break;
            case 75 :
                // InternalReflex.g:1:461: RULE_BOOL_LITERAL
                {
                mRULE_BOOL_LITERAL(); 

                }
                break;
            case 76 :
                // InternalReflex.g:1:479: RULE_LOGICAL_OR
                {
                mRULE_LOGICAL_OR(); 

                }
                break;
            case 77 :
                // InternalReflex.g:1:495: RULE_LOGICAL_AND
                {
                mRULE_LOGICAL_AND(); 

                }
                break;
            case 78 :
                // InternalReflex.g:1:512: RULE_BIT_OR
                {
                mRULE_BIT_OR(); 

                }
                break;
            case 79 :
                // InternalReflex.g:1:524: RULE_BIT_XOR
                {
                mRULE_BIT_XOR(); 

                }
                break;
            case 80 :
                // InternalReflex.g:1:537: RULE_BIT_AND
                {
                mRULE_BIT_AND(); 

                }
                break;
            case 81 :
                // InternalReflex.g:1:550: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 82 :
                // InternalReflex.g:1:563: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 83 :
                // InternalReflex.g:1:574: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 84 :
                // InternalReflex.g:1:582: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 85 :
                // InternalReflex.g:1:591: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 86 :
                // InternalReflex.g:1:603: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 87 :
                // InternalReflex.g:1:619: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 88 :
                // InternalReflex.g:1:635: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 89 :
                // InternalReflex.g:1:643: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA4_eotS =
        "\5\uffff";
    static final String DFA4_eofS =
        "\5\uffff";
    static final String DFA4_minS =
        "\2\56\1\60\2\uffff";
    static final String DFA4_maxS =
        "\3\146\2\uffff";
    static final String DFA4_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA4_specialS =
        "\5\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\1\uffff\12\1\7\uffff\6\3\32\uffff\6\3",
            "\1\2\1\uffff\12\1\7\uffff\6\3\32\uffff\6\3",
            "\12\4\7\uffff\6\3\32\uffff\6\3",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "4456:14: ( RULE_DEC_FLOAT | RULE_HEX_FLOAT )";
        }
    }
    static final String DFA27_eotS =
        "\3\uffff\1\63\2\uffff\1\63\1\uffff\2\63\1\uffff\1\63\1\110\1\63\2\uffff\2\63\1\uffff\3\63\1\127\2\63\1\134\1\137\1\141\1\145\1\147\1\152\1\155\1\157\1\162\1\uffff\1\165\1\uffff\3\63\2\172\1\63\1\uffff\2\57\4\uffff\1\63\3\uffff\3\63\1\uffff\1\63\1\uffff\6\63\1\uffff\3\63\3\uffff\2\63\2\uffff\1\u0092\1\u0096\3\63\1\uffff\4\63\1\uffff\2\63\14\uffff\1\u00a1\1\uffff\1\u00a3\16\uffff\3\63\1\uffff\1\172\1\u00a7\1\172\2\uffff\11\63\1\u00b3\10\63\1\uffff\2\63\1\u00be\1\uffff\11\63\4\uffff\3\63\1\uffff\3\63\1\u00cf\3\63\1\u00d3\3\63\1\uffff\2\63\1\u00d9\1\u00da\3\63\1\u00df\2\63\1\uffff\1\u00e2\1\63\1\u00e4\1\63\1\u00e6\2\63\1\u00e9\2\63\1\u00ec\4\63\1\u00f1\1\uffff\1\u00f2\1\u00f3\1\u00f4\1\uffff\1\63\1\u00f6\3\63\2\uffff\1\u00fa\1\u00df\1\63\1\u00fc\1\uffff\1\u00fd\1\63\1\uffff\1\u00ff\1\uffff\1\u0100\1\uffff\1\63\1\u0102\1\uffff\2\63\1\uffff\4\63\4\uffff\1\u0109\1\uffff\1\u010a\1\u010b\1\u010c\1\uffff\1\63\2\uffff\1\63\2\uffff\1\63\1\uffff\1\u0110\1\u0111\1\u0112\1\63\1\u0114\1\u0115\4\uffff\1\u0116\1\63\1\u0118\3\uffff\1\63\3\uffff\1\u011a\1\uffff\1\u011b\2\uffff";
    static final String DFA27_eofS =
        "\u011c\uffff";
    static final String DFA27_minS =
        "\1\0\2\uffff\1\162\2\uffff\1\56\1\uffff\1\145\1\157\1\uffff\1\56\1\74\1\151\2\uffff\1\146\1\56\1\uffff\1\56\2\145\1\60\1\165\1\56\1\53\1\55\1\75\1\52\1\74\1\75\1\46\2\75\1\uffff\1\75\1\uffff\1\157\1\56\1\156\3\56\1\uffff\2\0\4\uffff\1\157\3\uffff\1\157\1\56\1\156\1\uffff\1\56\1\uffff\2\141\1\151\1\164\1\147\1\156\1\uffff\2\157\1\56\3\uffff\1\155\1\165\2\uffff\2\60\1\163\1\162\1\165\1\uffff\1\145\1\157\1\163\1\170\1\uffff\1\164\1\56\14\uffff\1\75\1\uffff\1\75\16\uffff\1\151\1\165\1\163\1\uffff\3\56\2\uffff\2\143\1\145\1\163\1\162\1\160\2\162\1\164\1\60\1\156\1\160\1\147\1\155\1\141\1\163\2\145\1\uffff\1\165\1\143\1\60\1\uffff\1\145\1\157\1\155\1\141\1\154\1\145\1\164\1\160\1\151\4\uffff\1\144\1\142\1\151\1\uffff\1\162\1\145\1\153\1\60\1\164\1\145\1\164\1\60\1\145\1\164\1\143\1\uffff\2\145\2\60\1\164\1\145\1\157\1\60\2\164\1\uffff\1\60\1\162\1\60\1\153\1\60\1\141\1\164\1\60\1\165\1\166\1\60\1\154\1\147\1\141\1\163\1\60\1\uffff\3\60\1\uffff\1\144\1\60\1\150\2\144\2\uffff\2\60\1\165\1\60\1\uffff\1\60\1\151\1\uffff\1\60\1\uffff\1\60\1\uffff\1\162\1\60\1\uffff\1\164\1\145\1\uffff\1\145\1\156\1\155\1\163\4\uffff\1\60\1\uffff\3\60\1\uffff\1\164\2\uffff\1\166\2\uffff\1\164\1\uffff\3\60\1\145\2\60\4\uffff\1\60\1\145\1\60\3\uffff\1\144\3\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA27_maxS =
        "\1\uffff\2\uffff\1\162\2\uffff\1\157\1\uffff\1\167\1\157\1\uffff\1\162\1\75\1\162\2\uffff\1\156\1\162\1\uffff\1\162\2\145\1\146\1\165\1\146\4\75\1\74\1\76\1\75\1\172\1\174\1\uffff\1\75\1\uffff\2\157\1\156\3\146\1\uffff\2\uffff\4\uffff\1\157\3\uffff\1\157\1\163\1\156\1\uffff\1\146\1\uffff\2\157\1\151\1\164\1\147\1\157\1\uffff\2\157\1\154\3\uffff\1\155\1\165\2\uffff\2\172\1\163\1\162\1\165\1\uffff\1\145\1\157\1\163\1\170\1\uffff\2\164\14\uffff\1\75\1\uffff\1\75\16\uffff\1\151\1\165\1\163\1\uffff\3\146\2\uffff\1\147\1\143\1\145\1\163\1\164\1\160\2\162\1\164\1\172\1\156\1\160\1\147\1\155\1\141\1\163\2\145\1\uffff\1\165\1\143\1\172\1\uffff\1\145\1\157\1\155\1\141\1\154\2\164\1\160\1\151\4\uffff\1\144\1\142\1\151\1\uffff\1\162\1\145\1\153\1\172\1\164\1\145\1\164\1\172\1\145\1\164\1\143\1\uffff\2\145\2\172\1\164\1\145\1\162\1\172\2\164\1\uffff\1\172\1\162\1\172\1\153\1\172\1\141\1\164\1\172\1\165\1\166\1\172\1\154\1\147\1\141\1\163\1\172\1\uffff\3\172\1\uffff\1\144\1\172\1\150\2\144\2\uffff\2\172\1\165\1\172\1\uffff\1\172\1\151\1\uffff\1\172\1\uffff\1\172\1\uffff\1\162\1\172\1\uffff\1\164\1\145\1\uffff\1\145\1\156\1\155\1\163\4\uffff\1\172\1\uffff\3\172\1\uffff\1\164\2\uffff\1\166\2\uffff\1\164\1\uffff\3\172\1\145\2\172\4\uffff\1\172\1\145\1\172\3\uffff\1\144\3\uffff\1\172\1\uffff\1\172\2\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\uffff\1\7\2\uffff\1\14\3\uffff\1\20\1\21\2\uffff\1\26\17\uffff\1\65\1\uffff\1\101\6\uffff\1\123\2\uffff\1\130\1\131\1\1\1\2\1\uffff\1\123\1\4\1\5\3\uffff\1\122\1\uffff\1\7\6\uffff\1\14\3\uffff\1\71\1\73\1\16\2\uffff\1\20\1\21\5\uffff\1\26\4\uffff\1\43\2\uffff\1\50\1\54\1\63\1\51\1\55\1\64\1\52\1\77\1\53\1\126\1\127\1\100\1\uffff\1\67\1\uffff\1\72\1\70\1\60\1\115\1\120\1\61\1\117\1\62\1\114\1\116\1\65\1\74\1\66\1\101\3\uffff\1\121\3\uffff\1\125\1\130\22\uffff\1\22\3\uffff\1\42\11\uffff\1\56\1\76\1\57\1\75\3\uffff\1\124\13\uffff\1\36\12\uffff\1\106\20\uffff\1\25\3\uffff\1\31\5\uffff\1\107\1\15\4\uffff\1\113\2\uffff\1\23\1\uffff\1\41\1\uffff\1\110\2\uffff\1\37\2\uffff\1\102\4\uffff\1\6\1\40\1\11\1\30\1\uffff\1\105\3\uffff\1\103\1\uffff\1\35\1\44\1\uffff\1\32\1\27\1\uffff\1\34\6\uffff\1\13\1\24\1\111\1\12\3\uffff\1\45\1\46\1\104\1\uffff\1\3\1\10\1\17\1\uffff\1\33\1\uffff\1\47\1\112";
    static final String DFA27_specialS =
        "\1\2\53\uffff\1\0\1\1\u00ee\uffff}>";
    static final String[] DFA27_transitionS = {
            "\11\57\2\56\2\57\1\56\22\57\1\56\1\43\1\54\2\57\1\44\1\37\1\55\1\16\1\17\1\33\1\31\1\12\1\32\1\26\1\34\1\50\11\51\1\22\1\7\1\35\1\14\1\36\2\57\6\52\24\53\1\1\1\57\1\2\1\40\1\53\1\57\1\30\1\23\1\6\1\46\1\21\1\13\2\53\1\20\2\53\1\11\1\53\1\25\1\27\1\3\1\53\1\24\1\10\1\15\1\47\1\45\4\53\1\4\1\41\1\5\1\42\uff81\57",
            "",
            "",
            "\1\62",
            "",
            "",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\1\67\5\72\5\uffff\1\66\2\uffff\1\70",
            "",
            "\1\77\2\uffff\1\75\1\100\12\uffff\1\74\2\uffff\1\76",
            "\1\101",
            "",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\1\105\5\72\5\uffff\1\104\5\uffff\1\103",
            "\1\106\1\107",
            "\1\111\10\uffff\1\112",
            "",
            "",
            "\1\115\7\uffff\1\116",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\6\72\5\uffff\1\117\1\uffff\1\121\3\uffff\1\120",
            "",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\6\72\10\uffff\1\124\2\uffff\1\123",
            "\1\125",
            "\1\126",
            "\12\71\7\uffff\6\71\32\uffff\6\71",
            "\1\130",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\2\72\1\131\3\72",
            "\1\132\21\uffff\1\133",
            "\1\135\17\uffff\1\136",
            "\1\140",
            "\1\143\4\uffff\1\144\15\uffff\1\142",
            "\1\146",
            "\1\151\1\150",
            "\1\154\26\uffff\1\153",
            "\1\156\3\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\160\76\uffff\1\161",
            "",
            "\1\164",
            "",
            "\1\167",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\6\72\10\uffff\1\170",
            "\1\171",
            "\1\71\1\uffff\10\173\2\174\7\uffff\6\71\32\uffff\6\71",
            "\1\71\1\uffff\12\175\7\uffff\6\71\32\uffff\6\71",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\6\72",
            "",
            "\0\176",
            "\0\176",
            "",
            "",
            "",
            "",
            "\1\u0080",
            "",
            "",
            "",
            "\1\u0081",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\6\72\14\uffff\1\u0082",
            "\1\u0083",
            "",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\6\72",
            "",
            "\1\u0084\15\uffff\1\u0085",
            "\1\u0086\15\uffff\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008c\1\u008b",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\6\72\5\uffff\1\u008f",
            "",
            "",
            "",
            "\1\u0090",
            "\1\u0091",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\1\u0094\16\63\1\u0093\3\63\1\u0095\6\63",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "",
            "\1\u009e",
            "\1\71\1\uffff\12\72\7\uffff\6\72\32\uffff\6\72\15\uffff\1\u009f",
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
            "",
            "\1\u00a2",
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
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\1\71\1\uffff\10\173\2\174\7\uffff\6\71\32\uffff\6\71",
            "\1\71\1\uffff\12\174\7\uffff\6\71\32\uffff\6\71",
            "\1\71\1\uffff\12\175\7\uffff\6\71\32\uffff\6\71",
            "",
            "",
            "\1\u00a9\3\uffff\1\u00a8",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ae\1\uffff\1\u00ad",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "",
            "\1\u00bc",
            "\1\u00bd",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c5\16\uffff\1\u00c4",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "",
            "",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "",
            "\1\u00d7",
            "\1\u00d8",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd\2\uffff\1\u00de",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00e0",
            "\1\u00e1",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00e3",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00e5",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00e7",
            "\1\u00e8",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00ea",
            "\1\u00eb",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u00f5",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00fb",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00fe",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u0101",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u0103",
            "\1\u0104",
            "",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "",
            "",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u010d",
            "",
            "",
            "\1\u010e",
            "",
            "",
            "\1\u010f",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0113",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0117",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "\1\u0119",
            "",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | RULE_BOOL_LITERAL | RULE_LOGICAL_OR | RULE_LOGICAL_AND | RULE_BIT_OR | RULE_BIT_XOR | RULE_BIT_AND | RULE_INTEGER | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_44 = input.LA(1);

                        s = -1;
                        if ( ((LA27_44>='\u0000' && LA27_44<='\uFFFF')) ) {s = 126;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_45 = input.LA(1);

                        s = -1;
                        if ( ((LA27_45>='\u0000' && LA27_45<='\uFFFF')) ) {s = 126;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_0 = input.LA(1);

                        s = -1;
                        if ( (LA27_0=='[') ) {s = 1;}

                        else if ( (LA27_0==']') ) {s = 2;}

                        else if ( (LA27_0=='p') ) {s = 3;}

                        else if ( (LA27_0=='{') ) {s = 4;}

                        else if ( (LA27_0=='}') ) {s = 5;}

                        else if ( (LA27_0=='c') ) {s = 6;}

                        else if ( (LA27_0==';') ) {s = 7;}

                        else if ( (LA27_0=='s') ) {s = 8;}

                        else if ( (LA27_0=='l') ) {s = 9;}

                        else if ( (LA27_0==',') ) {s = 10;}

                        else if ( (LA27_0=='f') ) {s = 11;}

                        else if ( (LA27_0=='=') ) {s = 12;}

                        else if ( (LA27_0=='t') ) {s = 13;}

                        else if ( (LA27_0=='(') ) {s = 14;}

                        else if ( (LA27_0==')') ) {s = 15;}

                        else if ( (LA27_0=='i') ) {s = 16;}

                        else if ( (LA27_0=='e') ) {s = 17;}

                        else if ( (LA27_0==':') ) {s = 18;}

                        else if ( (LA27_0=='b') ) {s = 19;}

                        else if ( (LA27_0=='r') ) {s = 20;}

                        else if ( (LA27_0=='n') ) {s = 21;}

                        else if ( (LA27_0=='.') ) {s = 22;}

                        else if ( (LA27_0=='o') ) {s = 23;}

                        else if ( (LA27_0=='a') ) {s = 24;}

                        else if ( (LA27_0=='+') ) {s = 25;}

                        else if ( (LA27_0=='-') ) {s = 26;}

                        else if ( (LA27_0=='*') ) {s = 27;}

                        else if ( (LA27_0=='/') ) {s = 28;}

                        else if ( (LA27_0=='<') ) {s = 29;}

                        else if ( (LA27_0=='>') ) {s = 30;}

                        else if ( (LA27_0=='&') ) {s = 31;}

                        else if ( (LA27_0=='^') ) {s = 32;}

                        else if ( (LA27_0=='|') ) {s = 33;}

                        else if ( (LA27_0=='~') ) {s = 34;}

                        else if ( (LA27_0=='!') ) {s = 35;}

                        else if ( (LA27_0=='%') ) {s = 36;}

                        else if ( (LA27_0=='v') ) {s = 37;}

                        else if ( (LA27_0=='d') ) {s = 38;}

                        else if ( (LA27_0=='u') ) {s = 39;}

                        else if ( (LA27_0=='0') ) {s = 40;}

                        else if ( ((LA27_0>='1' && LA27_0<='9')) ) {s = 41;}

                        else if ( ((LA27_0>='A' && LA27_0<='F')) ) {s = 42;}

                        else if ( ((LA27_0>='G' && LA27_0<='Z')||LA27_0=='_'||(LA27_0>='g' && LA27_0<='h')||(LA27_0>='j' && LA27_0<='k')||LA27_0=='m'||LA27_0=='q'||(LA27_0>='w' && LA27_0<='z')) ) {s = 43;}

                        else if ( (LA27_0=='\"') ) {s = 44;}

                        else if ( (LA27_0=='\'') ) {s = 45;}

                        else if ( ((LA27_0>='\t' && LA27_0<='\n')||LA27_0=='\r'||LA27_0==' ') ) {s = 46;}

                        else if ( ((LA27_0>='\u0000' && LA27_0<='\b')||(LA27_0>='\u000B' && LA27_0<='\f')||(LA27_0>='\u000E' && LA27_0<='\u001F')||(LA27_0>='#' && LA27_0<='$')||(LA27_0>='?' && LA27_0<='@')||LA27_0=='\\'||LA27_0=='`'||(LA27_0>='\u007F' && LA27_0<='\uFFFF')) ) {s = 47;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}