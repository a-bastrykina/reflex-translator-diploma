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
    public static final int RULE_BOOL_TYPE=13;
    public static final int RULE_HEX=16;
    public static final int T__50=50;
    public static final int RULE_DAY=19;
    public static final int RULE_REG_SIZE=6;
    public static final int RULE_FLOAT_C_TYPE=8;
    public static final int RULE_OCTAL=15;
    public static final int RULE_MINUTE=21;
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
    public static final int RULE_TACT=5;
    public static final int RULE_INT_C_TYPE=11;
    public static final int RULE_SHORT_C_TYPE=10;
    public static final int RULE_DECIMAL=14;
    public static final int RULE_SECOND=22;
    public static final int RULE_INT=26;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=28;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RULE_LONG_C_TYPE=12;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_NANOSECOND=25;
    public static final int RULE_MILISECOND=23;
    public static final int RULE_STRING=27;
    public static final int RULE_SL_COMMENT=29;
    public static final int RULE_MICROSECOND=24;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int RULE_VOID_C_TYPE=7;
    public static final int T__32=32;
    public static final int RULE_HOUR=20;
    public static final int RULE_UNSIGNED=18;
    public static final int RULE_WS=30;
    public static final int RULE_DOUBLE_C_TYPE=9;
    public static final int RULE_ANY_OTHER=31;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int RULE_LONG=17;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:11:7: ( 'program' )
            // InternalReflex.g:11:9: 'program'
            {
            match("program"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:12:7: ( '{' )
            // InternalReflex.g:12:9: '{'
            {
            match('{'); 

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
            // InternalReflex.g:13:7: ( '}' )
            // InternalReflex.g:13:9: '}'
            {
            match('}'); 

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
            // InternalReflex.g:14:7: ( 'proc' )
            // InternalReflex.g:14:9: 'proc'
            {
            match("proc"); 


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
            // InternalReflex.g:15:7: ( ';' )
            // InternalReflex.g:15:9: ';'
            {
            match(';'); 

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
            // InternalReflex.g:16:7: ( 'from' )
            // InternalReflex.g:16:9: 'from'
            {
            match("from"); 


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
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:18:7: ( ',' )
            // InternalReflex.g:18:9: ','
            {
            match(','); 

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
            // InternalReflex.g:19:7: ( '[' )
            // InternalReflex.g:19:9: '['
            {
            match('['); 

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
            // InternalReflex.g:20:7: ( ']' )
            // InternalReflex.g:20:9: ']'
            {
            match(']'); 

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
            // InternalReflex.g:21:7: ( 'local' )
            // InternalReflex.g:21:9: 'local'
            {
            match("local"); 


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
            // InternalReflex.g:22:7: ( 'global' )
            // InternalReflex.g:22:9: 'global'
            {
            match("global"); 


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
            // InternalReflex.g:23:7: ( 'shared' )
            // InternalReflex.g:23:9: 'shared'
            {
            match("shared"); 


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
            // InternalReflex.g:24:7: ( 'state' )
            // InternalReflex.g:24:9: 'state'
            {
            match("state"); 


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
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:26:7: ( 'if' )
            // InternalReflex.g:26:9: 'if'
            {
            match("if"); 


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
            // InternalReflex.g:27:7: ( '(' )
            // InternalReflex.g:27:9: '('
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
            // InternalReflex.g:28:7: ( ')' )
            // InternalReflex.g:28:9: ')'
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
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
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
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
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
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
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
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
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
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
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
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
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
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
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
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:37:7: ( 'loop' )
            // InternalReflex.g:37:9: 'loop'
            {
            match("loop"); 


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
            // InternalReflex.g:38:7: ( 'restart' )
            // InternalReflex.g:38:9: 'restart'
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
            // InternalReflex.g:39:7: ( 'set' )
            // InternalReflex.g:39:9: 'set'
            {
            match("set"); 


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
            // InternalReflex.g:40:7: ( 'next' )
            // InternalReflex.g:40:9: 'next'
            {
            match("next"); 


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
            // InternalReflex.g:41:7: ( 'const' )
            // InternalReflex.g:41:9: 'const'
            {
            match("const"); 


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
            // InternalReflex.g:42:7: ( 'enum' )
            // InternalReflex.g:42:9: 'enum'
            {
            match("enum"); 


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
            // InternalReflex.g:43:7: ( '0t' )
            // InternalReflex.g:43:9: '0t'
            {
            match("0t"); 


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
            // InternalReflex.g:44:7: ( '0T' )
            // InternalReflex.g:44:9: '0T'
            {
            match("0T"); 


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
            // InternalReflex.g:45:7: ( 'input' )
            // InternalReflex.g:45:9: 'input'
            {
            match("input"); 


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
            // InternalReflex.g:46:7: ( 'output' )
            // InternalReflex.g:46:9: 'output'
            {
            match("output"); 


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
            // InternalReflex.g:47:7: ( 'signed' )
            // InternalReflex.g:47:9: 'signed'
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
            // InternalReflex.g:48:7: ( 'unsigned' )
            // InternalReflex.g:48:9: 'unsigned'
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

    // $ANTLR start "RULE_VOID_C_TYPE"
    public final void mRULE_VOID_C_TYPE() throws RecognitionException {
        try {
            int _type = RULE_VOID_C_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:2763:18: ( 'void' )
            // InternalReflex.g:2763:20: 'void'
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
            // InternalReflex.g:2765:19: ( 'float' )
            // InternalReflex.g:2765:21: 'float'
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
            // InternalReflex.g:2767:20: ( 'double' )
            // InternalReflex.g:2767:22: 'double'
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
            // InternalReflex.g:2769:19: ( 'short' )
            // InternalReflex.g:2769:21: 'short'
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
            // InternalReflex.g:2771:17: ( 'int' )
            // InternalReflex.g:2771:19: 'int'
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
            // InternalReflex.g:2773:18: ( 'long' )
            // InternalReflex.g:2773:20: 'long'
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
            // InternalReflex.g:2775:16: ( 'bool' )
            // InternalReflex.g:2775:18: 'bool'
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
            // InternalReflex.g:2777:11: ( 'tact' )
            // InternalReflex.g:2777:13: 'tact'
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

    // $ANTLR start "RULE_REG_SIZE"
    public final void mRULE_REG_SIZE() throws RecognitionException {
        try {
            int _type = RULE_REG_SIZE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:2779:15: ( ( '8' | '16' ) )
            // InternalReflex.g:2779:17: ( '8' | '16' )
            {
            // InternalReflex.g:2779:17: ( '8' | '16' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='8') ) {
                alt1=1;
            }
            else if ( (LA1_0=='1') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalReflex.g:2779:18: '8'
                    {
                    match('8'); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2779:22: '16'
                    {
                    match("16"); 


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
    // $ANTLR end "RULE_REG_SIZE"

    // $ANTLR start "RULE_DECIMAL"
    public final void mRULE_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:2781:14: ( '1' .. '9' ( '0' .. '9' )* )
            // InternalReflex.g:2781:16: '1' .. '9' ( '0' .. '9' )*
            {
            matchRange('1','9'); 
            // InternalReflex.g:2781:25: ( '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalReflex.g:2781:26: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
            // InternalReflex.g:2783:12: ( '0' ( '0' .. '7' )* )
            // InternalReflex.g:2783:14: '0' ( '0' .. '7' )*
            {
            match('0'); 
            // InternalReflex.g:2783:18: ( '0' .. '7' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='7')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalReflex.g:2783:19: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
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
            // InternalReflex.g:2785:10: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalReflex.g:2785:12: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalReflex.g:2785:26: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='F')||(LA4_0>='a' && LA4_0<='f')) ) {
                    alt4=1;
                }


                switch (alt4) {
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_LONG"
    public final void mRULE_LONG() throws RecognitionException {
        try {
            int _type = RULE_LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:2787:11: ( ( 'L' | 'l' ) )
            // InternalReflex.g:2787:13: ( 'L' | 'l' )
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

    // $ANTLR start "RULE_UNSIGNED"
    public final void mRULE_UNSIGNED() throws RecognitionException {
        try {
            int _type = RULE_UNSIGNED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:2789:15: ( ( 'U' | 'u' ) )
            // InternalReflex.g:2789:17: ( 'U' | 'u' )
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
            // InternalReflex.g:2791:10: ( ( 'D' | 'd' ) )
            // InternalReflex.g:2791:12: ( 'D' | 'd' )
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
            // InternalReflex.g:2793:11: ( ( 'H' | 'h' ) )
            // InternalReflex.g:2793:13: ( 'H' | 'h' )
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
            // InternalReflex.g:2795:13: ( ( 'M' | 'm' ) )
            // InternalReflex.g:2795:15: ( 'M' | 'm' )
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
            // InternalReflex.g:2797:13: ( ( 'S' | 's' ) )
            // InternalReflex.g:2797:15: ( 'S' | 's' )
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
            // InternalReflex.g:2799:17: ( ( 'MS' | 'ms' ) )
            // InternalReflex.g:2799:19: ( 'MS' | 'ms' )
            {
            // InternalReflex.g:2799:19: ( 'MS' | 'ms' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='M') ) {
                alt5=1;
            }
            else if ( (LA5_0=='m') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalReflex.g:2799:20: 'MS'
                    {
                    match("MS"); 


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2799:25: 'ms'
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
            // InternalReflex.g:2801:18: ( ( 'US' | 'us' ) )
            // InternalReflex.g:2801:20: ( 'US' | 'us' )
            {
            // InternalReflex.g:2801:20: ( 'US' | 'us' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='U') ) {
                alt6=1;
            }
            else if ( (LA6_0=='u') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalReflex.g:2801:21: 'US'
                    {
                    match("US"); 


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2801:26: 'us'
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
            // InternalReflex.g:2803:17: ( ( 'NS' | 'ns' ) )
            // InternalReflex.g:2803:19: ( 'NS' | 'ns' )
            {
            // InternalReflex.g:2803:19: ( 'NS' | 'ns' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='N') ) {
                alt7=1;
            }
            else if ( (LA7_0=='n') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalReflex.g:2803:20: 'NS'
                    {
                    match("NS"); 


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2803:25: 'ns'
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
            // InternalReflex.g:2805:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalReflex.g:2805:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalReflex.g:2805:11: ( '^' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='^') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalReflex.g:2805:11: '^'
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

            // InternalReflex.g:2805:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
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
            	    break loop9;
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
            // InternalReflex.g:2807:10: ( ( '0' .. '9' )+ )
            // InternalReflex.g:2807:12: ( '0' .. '9' )+
            {
            // InternalReflex.g:2807:12: ( '0' .. '9' )+
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
            	    // InternalReflex.g:2807:13: '0' .. '9'
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
            // InternalReflex.g:2809:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalReflex.g:2809:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalReflex.g:2809:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\"') ) {
                alt13=1;
            }
            else if ( (LA13_0=='\'') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalReflex.g:2809:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalReflex.g:2809:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop11:
                    do {
                        int alt11=3;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='\\') ) {
                            alt11=1;
                        }
                        else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                            alt11=2;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalReflex.g:2809:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:2809:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop11;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2809:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalReflex.g:2809:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\\') ) {
                            alt12=1;
                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalReflex.g:2809:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:2809:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop12;
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
            // InternalReflex.g:2811:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalReflex.g:2811:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalReflex.g:2811:24: ( options {greedy=false; } : . )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='*') ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1=='/') ) {
                        alt14=2;
                    }
                    else if ( ((LA14_1>='\u0000' && LA14_1<='.')||(LA14_1>='0' && LA14_1<='\uFFFF')) ) {
                        alt14=1;
                    }


                }
                else if ( ((LA14_0>='\u0000' && LA14_0<=')')||(LA14_0>='+' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalReflex.g:2811:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop14;
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
            // InternalReflex.g:2813:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalReflex.g:2813:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalReflex.g:2813:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalReflex.g:2813:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop15;
                }
            } while (true);

            // InternalReflex.g:2813:40: ( ( '\\r' )? '\\n' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\n'||LA17_0=='\r') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalReflex.g:2813:41: ( '\\r' )? '\\n'
                    {
                    // InternalReflex.g:2813:41: ( '\\r' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='\r') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalReflex.g:2813:41: '\\r'
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
            // InternalReflex.g:2815:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalReflex.g:2815:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalReflex.g:2815:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {
                    alt18=1;
                }


                switch (alt18) {
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
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:2817:16: ( . )
            // InternalReflex.g:2817:18: .
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
        // InternalReflex.g:1:8: ( T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | RULE_VOID_C_TYPE | RULE_FLOAT_C_TYPE | RULE_DOUBLE_C_TYPE | RULE_SHORT_C_TYPE | RULE_INT_C_TYPE | RULE_LONG_C_TYPE | RULE_BOOL_TYPE | RULE_TACT | RULE_REG_SIZE | RULE_DECIMAL | RULE_OCTAL | RULE_HEX | RULE_LONG | RULE_UNSIGNED | RULE_DAY | RULE_HOUR | RULE_MINUTE | RULE_SECOND | RULE_MILISECOND | RULE_MICROSECOND | RULE_NANOSECOND | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt19=66;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // InternalReflex.g:1:10: T__32
                {
                mT__32(); 

                }
                break;
            case 2 :
                // InternalReflex.g:1:16: T__33
                {
                mT__33(); 

                }
                break;
            case 3 :
                // InternalReflex.g:1:22: T__34
                {
                mT__34(); 

                }
                break;
            case 4 :
                // InternalReflex.g:1:28: T__35
                {
                mT__35(); 

                }
                break;
            case 5 :
                // InternalReflex.g:1:34: T__36
                {
                mT__36(); 

                }
                break;
            case 6 :
                // InternalReflex.g:1:40: T__37
                {
                mT__37(); 

                }
                break;
            case 7 :
                // InternalReflex.g:1:46: T__38
                {
                mT__38(); 

                }
                break;
            case 8 :
                // InternalReflex.g:1:52: T__39
                {
                mT__39(); 

                }
                break;
            case 9 :
                // InternalReflex.g:1:58: T__40
                {
                mT__40(); 

                }
                break;
            case 10 :
                // InternalReflex.g:1:64: T__41
                {
                mT__41(); 

                }
                break;
            case 11 :
                // InternalReflex.g:1:70: T__42
                {
                mT__42(); 

                }
                break;
            case 12 :
                // InternalReflex.g:1:76: T__43
                {
                mT__43(); 

                }
                break;
            case 13 :
                // InternalReflex.g:1:82: T__44
                {
                mT__44(); 

                }
                break;
            case 14 :
                // InternalReflex.g:1:88: T__45
                {
                mT__45(); 

                }
                break;
            case 15 :
                // InternalReflex.g:1:94: T__46
                {
                mT__46(); 

                }
                break;
            case 16 :
                // InternalReflex.g:1:100: T__47
                {
                mT__47(); 

                }
                break;
            case 17 :
                // InternalReflex.g:1:106: T__48
                {
                mT__48(); 

                }
                break;
            case 18 :
                // InternalReflex.g:1:112: T__49
                {
                mT__49(); 

                }
                break;
            case 19 :
                // InternalReflex.g:1:118: T__50
                {
                mT__50(); 

                }
                break;
            case 20 :
                // InternalReflex.g:1:124: T__51
                {
                mT__51(); 

                }
                break;
            case 21 :
                // InternalReflex.g:1:130: T__52
                {
                mT__52(); 

                }
                break;
            case 22 :
                // InternalReflex.g:1:136: T__53
                {
                mT__53(); 

                }
                break;
            case 23 :
                // InternalReflex.g:1:142: T__54
                {
                mT__54(); 

                }
                break;
            case 24 :
                // InternalReflex.g:1:148: T__55
                {
                mT__55(); 

                }
                break;
            case 25 :
                // InternalReflex.g:1:154: T__56
                {
                mT__56(); 

                }
                break;
            case 26 :
                // InternalReflex.g:1:160: T__57
                {
                mT__57(); 

                }
                break;
            case 27 :
                // InternalReflex.g:1:166: T__58
                {
                mT__58(); 

                }
                break;
            case 28 :
                // InternalReflex.g:1:172: T__59
                {
                mT__59(); 

                }
                break;
            case 29 :
                // InternalReflex.g:1:178: T__60
                {
                mT__60(); 

                }
                break;
            case 30 :
                // InternalReflex.g:1:184: T__61
                {
                mT__61(); 

                }
                break;
            case 31 :
                // InternalReflex.g:1:190: T__62
                {
                mT__62(); 

                }
                break;
            case 32 :
                // InternalReflex.g:1:196: T__63
                {
                mT__63(); 

                }
                break;
            case 33 :
                // InternalReflex.g:1:202: T__64
                {
                mT__64(); 

                }
                break;
            case 34 :
                // InternalReflex.g:1:208: T__65
                {
                mT__65(); 

                }
                break;
            case 35 :
                // InternalReflex.g:1:214: T__66
                {
                mT__66(); 

                }
                break;
            case 36 :
                // InternalReflex.g:1:220: T__67
                {
                mT__67(); 

                }
                break;
            case 37 :
                // InternalReflex.g:1:226: T__68
                {
                mT__68(); 

                }
                break;
            case 38 :
                // InternalReflex.g:1:232: T__69
                {
                mT__69(); 

                }
                break;
            case 39 :
                // InternalReflex.g:1:238: RULE_VOID_C_TYPE
                {
                mRULE_VOID_C_TYPE(); 

                }
                break;
            case 40 :
                // InternalReflex.g:1:255: RULE_FLOAT_C_TYPE
                {
                mRULE_FLOAT_C_TYPE(); 

                }
                break;
            case 41 :
                // InternalReflex.g:1:273: RULE_DOUBLE_C_TYPE
                {
                mRULE_DOUBLE_C_TYPE(); 

                }
                break;
            case 42 :
                // InternalReflex.g:1:292: RULE_SHORT_C_TYPE
                {
                mRULE_SHORT_C_TYPE(); 

                }
                break;
            case 43 :
                // InternalReflex.g:1:310: RULE_INT_C_TYPE
                {
                mRULE_INT_C_TYPE(); 

                }
                break;
            case 44 :
                // InternalReflex.g:1:326: RULE_LONG_C_TYPE
                {
                mRULE_LONG_C_TYPE(); 

                }
                break;
            case 45 :
                // InternalReflex.g:1:343: RULE_BOOL_TYPE
                {
                mRULE_BOOL_TYPE(); 

                }
                break;
            case 46 :
                // InternalReflex.g:1:358: RULE_TACT
                {
                mRULE_TACT(); 

                }
                break;
            case 47 :
                // InternalReflex.g:1:368: RULE_REG_SIZE
                {
                mRULE_REG_SIZE(); 

                }
                break;
            case 48 :
                // InternalReflex.g:1:382: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 49 :
                // InternalReflex.g:1:395: RULE_OCTAL
                {
                mRULE_OCTAL(); 

                }
                break;
            case 50 :
                // InternalReflex.g:1:406: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 51 :
                // InternalReflex.g:1:415: RULE_LONG
                {
                mRULE_LONG(); 

                }
                break;
            case 52 :
                // InternalReflex.g:1:425: RULE_UNSIGNED
                {
                mRULE_UNSIGNED(); 

                }
                break;
            case 53 :
                // InternalReflex.g:1:439: RULE_DAY
                {
                mRULE_DAY(); 

                }
                break;
            case 54 :
                // InternalReflex.g:1:448: RULE_HOUR
                {
                mRULE_HOUR(); 

                }
                break;
            case 55 :
                // InternalReflex.g:1:458: RULE_MINUTE
                {
                mRULE_MINUTE(); 

                }
                break;
            case 56 :
                // InternalReflex.g:1:470: RULE_SECOND
                {
                mRULE_SECOND(); 

                }
                break;
            case 57 :
                // InternalReflex.g:1:482: RULE_MILISECOND
                {
                mRULE_MILISECOND(); 

                }
                break;
            case 58 :
                // InternalReflex.g:1:498: RULE_MICROSECOND
                {
                mRULE_MICROSECOND(); 

                }
                break;
            case 59 :
                // InternalReflex.g:1:515: RULE_NANOSECOND
                {
                mRULE_NANOSECOND(); 

                }
                break;
            case 60 :
                // InternalReflex.g:1:531: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 61 :
                // InternalReflex.g:1:539: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 62 :
                // InternalReflex.g:1:548: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 63 :
                // InternalReflex.g:1:560: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 64 :
                // InternalReflex.g:1:576: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 65 :
                // InternalReflex.g:1:592: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 66 :
                // InternalReflex.g:1:600: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\1\uffff\1\57\3\uffff\1\57\4\uffff\1\72\1\57\1\101\2\57\2\uffff\2\57\1\uffff\3\57\1\127\1\57\1\134\1\57\1\137\1\140\2\143\1\72\1\134\1\137\1\145\1\147\1\101\1\147\1\57\1\55\1\uffff\3\55\2\uffff\1\57\4\uffff\2\57\4\uffff\1\57\1\uffff\6\57\1\uffff\2\57\1\176\1\57\2\uffff\5\57\1\uffff\4\57\1\u008a\3\uffff\1\127\2\uffff\2\57\1\u008d\1\uffff\2\57\2\uffff\1\143\1\140\1\uffff\1\u008d\1\uffff\1\u0090\1\uffff\1\u0090\1\u008a\4\uffff\14\57\1\u009f\3\57\1\uffff\1\57\1\u00a4\11\57\1\uffff\2\57\1\uffff\2\57\1\uffff\1\57\1\u00b3\1\u00b4\2\57\1\u00b7\1\u00b8\5\57\1\u00be\1\57\1\uffff\2\57\1\u00c2\1\57\1\uffff\1\u00c4\1\57\1\u00c6\1\u00c7\2\57\1\u00ca\1\57\1\u00cc\2\57\1\u00cf\2\57\2\uffff\1\u00d2\1\u00d3\2\uffff\2\57\1\u00d6\1\u00d7\1\u00d8\1\uffff\3\57\1\uffff\1\u00dc\1\uffff\1\u00dd\2\uffff\1\u00de\1\u00df\1\uffff\1\57\1\uffff\2\57\1\uffff\2\57\2\uffff\1\u00e5\1\u00e6\3\uffff\1\u00e7\1\u00e8\1\57\4\uffff\1\57\1\u00eb\1\57\1\u00ed\1\u00ee\4\uffff\1\u00ef\1\u00f0\1\uffff\1\57\4\uffff\1\u00f2\1\uffff";
    static final String DFA19_eofS =
        "\u00f3\uffff";
    static final String DFA19_minS =
        "\1\0\1\162\3\uffff\1\154\4\uffff\1\60\1\154\1\60\1\141\1\146\2\uffff\1\154\1\141\1\uffff\1\157\2\145\1\60\1\165\1\60\1\157\13\60\1\123\1\101\1\uffff\2\0\1\52\2\uffff\1\157\4\uffff\2\157\4\uffff\1\143\1\uffff\1\157\2\141\1\151\1\164\1\147\1\uffff\1\155\1\143\1\60\1\160\2\uffff\1\163\1\162\1\165\1\163\1\156\1\uffff\1\145\1\157\1\163\1\170\1\60\3\uffff\1\60\2\uffff\1\164\1\163\1\60\1\uffff\1\151\1\165\2\uffff\2\60\1\uffff\1\60\1\uffff\1\60\1\uffff\2\60\4\uffff\1\143\1\155\2\141\1\160\1\147\1\142\3\162\1\160\1\164\1\60\1\156\1\145\1\164\1\uffff\1\165\1\60\1\145\1\157\1\155\1\145\1\163\1\141\1\154\2\164\1\uffff\1\160\1\151\1\uffff\1\144\1\142\1\uffff\1\162\2\60\1\164\1\154\2\60\1\141\1\145\1\164\1\145\1\164\1\60\1\143\1\uffff\1\145\1\157\1\60\1\164\1\uffff\1\60\1\162\2\60\1\164\1\153\1\60\1\141\1\60\1\165\1\147\1\60\1\154\1\141\2\uffff\2\60\2\uffff\1\154\1\144\3\60\1\uffff\1\150\1\144\1\165\1\uffff\1\60\1\uffff\1\60\2\uffff\2\60\1\uffff\1\162\1\uffff\1\164\1\156\1\uffff\1\145\1\155\2\uffff\2\60\3\uffff\2\60\1\164\4\uffff\1\164\1\60\1\145\2\60\4\uffff\2\60\1\uffff\1\144\4\uffff\1\60\1\uffff";
    static final String DFA19_maxS =
        "\1\uffff\1\162\3\uffff\1\162\4\uffff\1\172\1\154\1\172\1\151\1\156\2\uffff\1\162\1\157\1\uffff\1\162\1\145\1\163\1\170\1\165\1\172\1\157\1\172\3\71\7\172\1\123\1\172\1\uffff\2\uffff\1\57\2\uffff\1\157\4\uffff\2\157\4\uffff\1\157\1\uffff\3\157\1\151\1\164\1\147\1\uffff\1\155\1\143\1\172\1\164\2\uffff\1\163\1\162\1\165\1\163\1\156\1\uffff\1\145\1\157\1\163\1\170\1\172\3\uffff\1\71\2\uffff\1\164\1\163\1\172\1\uffff\1\151\1\165\2\uffff\2\71\1\uffff\1\172\1\uffff\1\172\1\uffff\2\172\4\uffff\1\147\1\155\2\141\1\160\1\147\1\142\2\162\1\164\1\160\1\164\1\172\1\156\1\145\1\164\1\uffff\1\165\1\172\1\145\1\157\1\155\1\145\1\163\1\141\1\154\2\164\1\uffff\1\160\1\151\1\uffff\1\144\1\142\1\uffff\1\162\2\172\1\164\1\154\2\172\1\141\1\145\1\164\1\145\1\164\1\172\1\143\1\uffff\1\145\1\157\1\172\1\164\1\uffff\1\172\1\162\2\172\1\164\1\153\1\172\1\141\1\172\1\165\1\147\1\172\1\154\1\141\2\uffff\2\172\2\uffff\1\154\1\144\3\172\1\uffff\1\150\1\144\1\165\1\uffff\1\172\1\uffff\1\172\2\uffff\2\172\1\uffff\1\162\1\uffff\1\164\1\156\1\uffff\1\145\1\155\2\uffff\2\172\3\uffff\2\172\1\164\4\uffff\1\164\1\172\1\145\2\172\4\uffff\2\172\1\uffff\1\144\4\uffff\1\172\1\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\1\3\1\5\1\uffff\1\7\1\10\1\11\1\12\5\uffff\1\21\1\22\2\uffff\1\26\24\uffff\1\74\3\uffff\1\101\1\102\1\uffff\1\74\1\2\1\3\1\5\2\uffff\1\7\1\10\1\11\1\12\1\uffff\1\63\6\uffff\1\70\4\uffff\1\21\1\22\5\uffff\1\26\5\uffff\1\41\1\42\1\62\1\uffff\1\61\1\75\3\uffff\1\64\2\uffff\1\65\1\57\2\uffff\1\60\1\uffff\1\66\1\uffff\1\67\2\uffff\1\76\1\77\1\100\1\101\20\uffff\1\20\13\uffff\1\73\2\uffff\1\72\2\uffff\1\71\16\uffff\1\35\4\uffff\1\53\16\uffff\1\4\1\6\2\uffff\1\33\1\54\5\uffff\1\31\3\uffff\1\56\1\uffff\1\23\1\uffff\1\40\1\25\2\uffff\1\55\1\uffff\1\36\2\uffff\1\47\2\uffff\1\50\1\13\2\uffff\1\52\1\16\1\30\3\uffff\1\43\1\32\1\37\1\27\5\uffff\1\14\1\15\1\24\1\45\2\uffff\1\44\1\uffff\1\51\1\1\1\17\1\34\1\uffff\1\46";
    static final String DFA19_specialS =
        "\1\2\50\uffff\1\0\1\1\u00c8\uffff}>";
    static final String[] DFA19_transitionS = {
            "\11\55\2\54\2\55\1\54\22\55\1\54\1\55\1\51\4\55\1\52\1\17\1\20\2\55\1\7\2\55\1\53\1\27\1\35\6\36\1\34\1\36\1\23\1\4\1\55\1\6\3\55\3\50\1\41\3\50\1\42\3\50\1\37\1\43\1\46\4\50\1\44\1\50\1\40\5\50\1\10\1\55\1\11\1\47\1\50\1\55\1\50\1\24\1\22\1\33\1\21\1\5\1\13\1\42\1\16\2\50\1\12\1\45\1\26\1\30\1\1\1\50\1\25\1\14\1\15\1\31\1\32\4\50\1\2\1\55\1\3\uff82\55",
            "\1\56",
            "",
            "",
            "",
            "\1\64\5\uffff\1\63",
            "",
            "",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\16\57\1\71\13\57",
            "\1\73",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\4\57\1\77\2\57\1\74\1\100\12\57\1\75\2\57\1\76\3\57",
            "\1\103\7\uffff\1\102",
            "\1\104\7\uffff\1\105",
            "",
            "",
            "\1\110\1\uffff\1\112\3\uffff\1\111",
            "\1\113\15\uffff\1\114",
            "",
            "\1\117\2\uffff\1\116",
            "\1\120",
            "\1\121\15\uffff\1\122",
            "\10\126\2\130\32\uffff\1\124\3\uffff\1\125\33\uffff\1\123\3\uffff\1\125",
            "\1\131",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\15\57\1\132\4\57\1\133\7\57",
            "\1\135",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\16\57\1\136\13\57",
            "\12\141",
            "\6\141\1\142\3\141",
            "\12\141",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\22\57\1\144\7\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\22\57\1\146\7\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\22\57\1\150\7\57",
            "\1\151",
            "\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\0\152",
            "\0\152",
            "\1\153\4\uffff\1\154",
            "",
            "",
            "\1\156",
            "",
            "",
            "",
            "",
            "\1\157",
            "\1\160",
            "",
            "",
            "",
            "",
            "\1\161\12\uffff\1\163\1\162",
            "",
            "\1\164",
            "\1\165\15\uffff\1\166",
            "\1\167\15\uffff\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "",
            "\1\174",
            "\1\175",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\177\3\uffff\1\u0080",
            "",
            "",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "",
            "\10\126\2\130",
            "",
            "",
            "\1\u008b",
            "\1\u008c",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u008e",
            "\1\u008f",
            "",
            "",
            "\12\141",
            "\12\141",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "",
            "",
            "\1\u0092\3\uffff\1\u0091",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009c\1\uffff\1\u009b",
            "\1\u009d",
            "\1\u009e",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "",
            "\1\u00a3",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "",
            "\1\u00ae",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "\1\u00b2",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00b5",
            "\1\u00b6",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00bf",
            "",
            "\1\u00c0",
            "\1\u00c1",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00c3",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00c5",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00c8",
            "\1\u00c9",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00cb",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00cd",
            "\1\u00ce",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00d0",
            "\1\u00d1",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u00e0",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "\1\u00e4",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00e9",
            "",
            "",
            "",
            "",
            "\1\u00ea",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00ec",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u00f1",
            "",
            "",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | RULE_VOID_C_TYPE | RULE_FLOAT_C_TYPE | RULE_DOUBLE_C_TYPE | RULE_SHORT_C_TYPE | RULE_INT_C_TYPE | RULE_LONG_C_TYPE | RULE_BOOL_TYPE | RULE_TACT | RULE_REG_SIZE | RULE_DECIMAL | RULE_OCTAL | RULE_HEX | RULE_LONG | RULE_UNSIGNED | RULE_DAY | RULE_HOUR | RULE_MINUTE | RULE_SECOND | RULE_MILISECOND | RULE_MICROSECOND | RULE_NANOSECOND | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_41 = input.LA(1);

                        s = -1;
                        if ( ((LA19_41>='\u0000' && LA19_41<='\uFFFF')) ) {s = 106;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_42 = input.LA(1);

                        s = -1;
                        if ( ((LA19_42>='\u0000' && LA19_42<='\uFFFF')) ) {s = 106;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_0 = input.LA(1);

                        s = -1;
                        if ( (LA19_0=='p') ) {s = 1;}

                        else if ( (LA19_0=='{') ) {s = 2;}

                        else if ( (LA19_0=='}') ) {s = 3;}

                        else if ( (LA19_0==';') ) {s = 4;}

                        else if ( (LA19_0=='f') ) {s = 5;}

                        else if ( (LA19_0=='=') ) {s = 6;}

                        else if ( (LA19_0==',') ) {s = 7;}

                        else if ( (LA19_0=='[') ) {s = 8;}

                        else if ( (LA19_0==']') ) {s = 9;}

                        else if ( (LA19_0=='l') ) {s = 10;}

                        else if ( (LA19_0=='g') ) {s = 11;}

                        else if ( (LA19_0=='s') ) {s = 12;}

                        else if ( (LA19_0=='t') ) {s = 13;}

                        else if ( (LA19_0=='i') ) {s = 14;}

                        else if ( (LA19_0=='(') ) {s = 15;}

                        else if ( (LA19_0==')') ) {s = 16;}

                        else if ( (LA19_0=='e') ) {s = 17;}

                        else if ( (LA19_0=='c') ) {s = 18;}

                        else if ( (LA19_0==':') ) {s = 19;}

                        else if ( (LA19_0=='b') ) {s = 20;}

                        else if ( (LA19_0=='r') ) {s = 21;}

                        else if ( (LA19_0=='n') ) {s = 22;}

                        else if ( (LA19_0=='0') ) {s = 23;}

                        else if ( (LA19_0=='o') ) {s = 24;}

                        else if ( (LA19_0=='u') ) {s = 25;}

                        else if ( (LA19_0=='v') ) {s = 26;}

                        else if ( (LA19_0=='d') ) {s = 27;}

                        else if ( (LA19_0=='8') ) {s = 28;}

                        else if ( (LA19_0=='1') ) {s = 29;}

                        else if ( ((LA19_0>='2' && LA19_0<='7')||LA19_0=='9') ) {s = 30;}

                        else if ( (LA19_0=='L') ) {s = 31;}

                        else if ( (LA19_0=='U') ) {s = 32;}

                        else if ( (LA19_0=='D') ) {s = 33;}

                        else if ( (LA19_0=='H'||LA19_0=='h') ) {s = 34;}

                        else if ( (LA19_0=='M') ) {s = 35;}

                        else if ( (LA19_0=='S') ) {s = 36;}

                        else if ( (LA19_0=='m') ) {s = 37;}

                        else if ( (LA19_0=='N') ) {s = 38;}

                        else if ( (LA19_0=='^') ) {s = 39;}

                        else if ( ((LA19_0>='A' && LA19_0<='C')||(LA19_0>='E' && LA19_0<='G')||(LA19_0>='I' && LA19_0<='K')||(LA19_0>='O' && LA19_0<='R')||LA19_0=='T'||(LA19_0>='V' && LA19_0<='Z')||LA19_0=='_'||LA19_0=='a'||(LA19_0>='j' && LA19_0<='k')||LA19_0=='q'||(LA19_0>='w' && LA19_0<='z')) ) {s = 40;}

                        else if ( (LA19_0=='\"') ) {s = 41;}

                        else if ( (LA19_0=='\'') ) {s = 42;}

                        else if ( (LA19_0=='/') ) {s = 43;}

                        else if ( ((LA19_0>='\t' && LA19_0<='\n')||LA19_0=='\r'||LA19_0==' ') ) {s = 44;}

                        else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||LA19_0=='!'||(LA19_0>='#' && LA19_0<='&')||(LA19_0>='*' && LA19_0<='+')||(LA19_0>='-' && LA19_0<='.')||LA19_0=='<'||(LA19_0>='>' && LA19_0<='@')||LA19_0=='\\'||LA19_0=='`'||LA19_0=='|'||(LA19_0>='~' && LA19_0<='\uFFFF')) ) {s = 45;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}