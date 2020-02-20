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
    public static final int RULE_REG_SIZE=6;
    public static final int RULE_FLOAT_C_TYPE=8;
    public static final int RULE_OCTAL=15;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int RULE_TACT=5;
    public static final int RULE_INT_C_TYPE=11;
    public static final int RULE_SHORT_C_TYPE=10;
    public static final int RULE_DECIMAL=14;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=17;
    public static final int T__29=29;
    public static final int RULE_ML_COMMENT=19;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_LONG_C_TYPE=12;
    public static final int RULE_STRING=18;
    public static final int RULE_SL_COMMENT=20;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_VOID_C_TYPE=7;
    public static final int T__32=32;
    public static final int RULE_WS=21;
    public static final int RULE_DOUBLE_C_TYPE=9;
    public static final int RULE_ANY_OTHER=22;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
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

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
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
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
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
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
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
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
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
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
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
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
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
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
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
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
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
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
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
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
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
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
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
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
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
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
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
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
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
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
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
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
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
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
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
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
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
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
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
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
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
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:43:7: ( 'input' )
            // InternalReflex.g:43:9: 'input'
            {
            match("input"); 


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
            // InternalReflex.g:44:7: ( 'output' )
            // InternalReflex.g:44:9: 'output'
            {
            match("output"); 


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
            // InternalReflex.g:45:7: ( 'signed' )
            // InternalReflex.g:45:9: 'signed'
            {
            match("signed"); 


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
            // InternalReflex.g:46:7: ( 'unsigned' )
            // InternalReflex.g:46:9: 'unsigned'
            {
            match("unsigned"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "RULE_VOID_C_TYPE"
    public final void mRULE_VOID_C_TYPE() throws RecognitionException {
        try {
            int _type = RULE_VOID_C_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:2553:18: ( 'void' )
            // InternalReflex.g:2553:20: 'void'
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
            // InternalReflex.g:2555:19: ( 'float' )
            // InternalReflex.g:2555:21: 'float'
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
            // InternalReflex.g:2557:20: ( 'double' )
            // InternalReflex.g:2557:22: 'double'
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
            // InternalReflex.g:2559:19: ( 'short' )
            // InternalReflex.g:2559:21: 'short'
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
            // InternalReflex.g:2561:17: ( 'int' )
            // InternalReflex.g:2561:19: 'int'
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
            // InternalReflex.g:2563:18: ( 'long' )
            // InternalReflex.g:2563:20: 'long'
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
            // InternalReflex.g:2565:16: ( 'bool' )
            // InternalReflex.g:2565:18: 'bool'
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
            // InternalReflex.g:2567:11: ( 'tact' )
            // InternalReflex.g:2567:13: 'tact'
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
            // InternalReflex.g:2569:15: ( ( '8' | '16' ) )
            // InternalReflex.g:2569:17: ( '8' | '16' )
            {
            // InternalReflex.g:2569:17: ( '8' | '16' )
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
                    // InternalReflex.g:2569:18: '8'
                    {
                    match('8'); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2569:22: '16'
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
            // InternalReflex.g:2571:14: ( '1' .. '9' ( '0' .. '9' )* )
            // InternalReflex.g:2571:16: '1' .. '9' ( '0' .. '9' )*
            {
            matchRange('1','9'); 
            // InternalReflex.g:2571:25: ( '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalReflex.g:2571:26: '0' .. '9'
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
            // InternalReflex.g:2573:12: ( '0' ( '0' .. '7' )* )
            // InternalReflex.g:2573:14: '0' ( '0' .. '7' )*
            {
            match('0'); 
            // InternalReflex.g:2573:18: ( '0' .. '7' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='7')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalReflex.g:2573:19: '0' .. '7'
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
            // InternalReflex.g:2575:10: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalReflex.g:2575:12: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalReflex.g:2575:26: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalReflex.g:2577:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalReflex.g:2577:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalReflex.g:2577:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalReflex.g:2577:11: '^'
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

            // InternalReflex.g:2577:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
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
            	    break loop6;
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
            // InternalReflex.g:2579:10: ( ( '0' .. '9' )+ )
            // InternalReflex.g:2579:12: ( '0' .. '9' )+
            {
            // InternalReflex.g:2579:12: ( '0' .. '9' )+
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
            	    // InternalReflex.g:2579:13: '0' .. '9'
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
            // InternalReflex.g:2581:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalReflex.g:2581:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalReflex.g:2581:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalReflex.g:2581:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalReflex.g:2581:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalReflex.g:2581:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:2581:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2581:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalReflex.g:2581:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalReflex.g:2581:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReflex.g:2581:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop9;
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
            // InternalReflex.g:2583:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalReflex.g:2583:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalReflex.g:2583:24: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='/') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='.')||(LA11_1>='0' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalReflex.g:2583:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // InternalReflex.g:2585:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalReflex.g:2585:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalReflex.g:2585:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalReflex.g:2585:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop12;
                }
            } while (true);

            // InternalReflex.g:2585:40: ( ( '\\r' )? '\\n' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\n'||LA14_0=='\r') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalReflex.g:2585:41: ( '\\r' )? '\\n'
                    {
                    // InternalReflex.g:2585:41: ( '\\r' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\r') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalReflex.g:2585:41: '\\r'
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
            // InternalReflex.g:2587:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalReflex.g:2587:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalReflex.g:2587:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
            // InternalReflex.g:2589:16: ( . )
            // InternalReflex.g:2589:18: .
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
        // InternalReflex.g:1:8: ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RULE_VOID_C_TYPE | RULE_FLOAT_C_TYPE | RULE_DOUBLE_C_TYPE | RULE_SHORT_C_TYPE | RULE_INT_C_TYPE | RULE_LONG_C_TYPE | RULE_BOOL_TYPE | RULE_TACT | RULE_REG_SIZE | RULE_DECIMAL | RULE_OCTAL | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt16=55;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // InternalReflex.g:1:10: T__23
                {
                mT__23(); 

                }
                break;
            case 2 :
                // InternalReflex.g:1:16: T__24
                {
                mT__24(); 

                }
                break;
            case 3 :
                // InternalReflex.g:1:22: T__25
                {
                mT__25(); 

                }
                break;
            case 4 :
                // InternalReflex.g:1:28: T__26
                {
                mT__26(); 

                }
                break;
            case 5 :
                // InternalReflex.g:1:34: T__27
                {
                mT__27(); 

                }
                break;
            case 6 :
                // InternalReflex.g:1:40: T__28
                {
                mT__28(); 

                }
                break;
            case 7 :
                // InternalReflex.g:1:46: T__29
                {
                mT__29(); 

                }
                break;
            case 8 :
                // InternalReflex.g:1:52: T__30
                {
                mT__30(); 

                }
                break;
            case 9 :
                // InternalReflex.g:1:58: T__31
                {
                mT__31(); 

                }
                break;
            case 10 :
                // InternalReflex.g:1:64: T__32
                {
                mT__32(); 

                }
                break;
            case 11 :
                // InternalReflex.g:1:70: T__33
                {
                mT__33(); 

                }
                break;
            case 12 :
                // InternalReflex.g:1:76: T__34
                {
                mT__34(); 

                }
                break;
            case 13 :
                // InternalReflex.g:1:82: T__35
                {
                mT__35(); 

                }
                break;
            case 14 :
                // InternalReflex.g:1:88: T__36
                {
                mT__36(); 

                }
                break;
            case 15 :
                // InternalReflex.g:1:94: T__37
                {
                mT__37(); 

                }
                break;
            case 16 :
                // InternalReflex.g:1:100: T__38
                {
                mT__38(); 

                }
                break;
            case 17 :
                // InternalReflex.g:1:106: T__39
                {
                mT__39(); 

                }
                break;
            case 18 :
                // InternalReflex.g:1:112: T__40
                {
                mT__40(); 

                }
                break;
            case 19 :
                // InternalReflex.g:1:118: T__41
                {
                mT__41(); 

                }
                break;
            case 20 :
                // InternalReflex.g:1:124: T__42
                {
                mT__42(); 

                }
                break;
            case 21 :
                // InternalReflex.g:1:130: T__43
                {
                mT__43(); 

                }
                break;
            case 22 :
                // InternalReflex.g:1:136: T__44
                {
                mT__44(); 

                }
                break;
            case 23 :
                // InternalReflex.g:1:142: T__45
                {
                mT__45(); 

                }
                break;
            case 24 :
                // InternalReflex.g:1:148: T__46
                {
                mT__46(); 

                }
                break;
            case 25 :
                // InternalReflex.g:1:154: T__47
                {
                mT__47(); 

                }
                break;
            case 26 :
                // InternalReflex.g:1:160: T__48
                {
                mT__48(); 

                }
                break;
            case 27 :
                // InternalReflex.g:1:166: T__49
                {
                mT__49(); 

                }
                break;
            case 28 :
                // InternalReflex.g:1:172: T__50
                {
                mT__50(); 

                }
                break;
            case 29 :
                // InternalReflex.g:1:178: T__51
                {
                mT__51(); 

                }
                break;
            case 30 :
                // InternalReflex.g:1:184: T__52
                {
                mT__52(); 

                }
                break;
            case 31 :
                // InternalReflex.g:1:190: T__53
                {
                mT__53(); 

                }
                break;
            case 32 :
                // InternalReflex.g:1:196: T__54
                {
                mT__54(); 

                }
                break;
            case 33 :
                // InternalReflex.g:1:202: T__55
                {
                mT__55(); 

                }
                break;
            case 34 :
                // InternalReflex.g:1:208: T__56
                {
                mT__56(); 

                }
                break;
            case 35 :
                // InternalReflex.g:1:214: T__57
                {
                mT__57(); 

                }
                break;
            case 36 :
                // InternalReflex.g:1:220: T__58
                {
                mT__58(); 

                }
                break;
            case 37 :
                // InternalReflex.g:1:226: RULE_VOID_C_TYPE
                {
                mRULE_VOID_C_TYPE(); 

                }
                break;
            case 38 :
                // InternalReflex.g:1:243: RULE_FLOAT_C_TYPE
                {
                mRULE_FLOAT_C_TYPE(); 

                }
                break;
            case 39 :
                // InternalReflex.g:1:261: RULE_DOUBLE_C_TYPE
                {
                mRULE_DOUBLE_C_TYPE(); 

                }
                break;
            case 40 :
                // InternalReflex.g:1:280: RULE_SHORT_C_TYPE
                {
                mRULE_SHORT_C_TYPE(); 

                }
                break;
            case 41 :
                // InternalReflex.g:1:298: RULE_INT_C_TYPE
                {
                mRULE_INT_C_TYPE(); 

                }
                break;
            case 42 :
                // InternalReflex.g:1:314: RULE_LONG_C_TYPE
                {
                mRULE_LONG_C_TYPE(); 

                }
                break;
            case 43 :
                // InternalReflex.g:1:331: RULE_BOOL_TYPE
                {
                mRULE_BOOL_TYPE(); 

                }
                break;
            case 44 :
                // InternalReflex.g:1:346: RULE_TACT
                {
                mRULE_TACT(); 

                }
                break;
            case 45 :
                // InternalReflex.g:1:356: RULE_REG_SIZE
                {
                mRULE_REG_SIZE(); 

                }
                break;
            case 46 :
                // InternalReflex.g:1:370: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 47 :
                // InternalReflex.g:1:383: RULE_OCTAL
                {
                mRULE_OCTAL(); 

                }
                break;
            case 48 :
                // InternalReflex.g:1:394: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 49 :
                // InternalReflex.g:1:403: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 50 :
                // InternalReflex.g:1:411: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 51 :
                // InternalReflex.g:1:420: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 52 :
                // InternalReflex.g:1:432: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 53 :
                // InternalReflex.g:1:448: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 54 :
                // InternalReflex.g:1:464: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 55 :
                // InternalReflex.g:1:472: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\1\47\3\uffff\1\47\4\uffff\5\47\2\uffff\2\47\1\uffff\7\47\1\115\2\117\1\122\1\45\1\uffff\3\45\2\uffff\1\47\4\uffff\2\47\4\uffff\11\47\1\150\1\47\2\uffff\5\47\1\uffff\10\47\1\117\1\uffff\1\115\2\uffff\1\122\6\uffff\14\47\1\u0086\3\47\1\uffff\1\47\1\u008b\16\47\1\u009a\1\u009b\2\47\1\u009e\1\u009f\5\47\1\u00a5\1\47\1\uffff\2\47\1\u00a9\1\47\1\uffff\1\u00ab\1\47\1\u00ad\1\u00ae\2\47\1\u00b1\1\47\1\u00b3\2\47\1\u00b6\2\47\2\uffff\1\u00b9\1\u00ba\2\uffff\2\47\1\u00bd\1\u00be\1\u00bf\1\uffff\3\47\1\uffff\1\u00c3\1\uffff\1\u00c4\2\uffff\1\u00c5\1\u00c6\1\uffff\1\47\1\uffff\2\47\1\uffff\2\47\2\uffff\1\u00cc\1\u00cd\3\uffff\1\u00ce\1\u00cf\1\47\4\uffff\1\47\1\u00d2\1\47\1\u00d4\1\u00d5\4\uffff\1\u00d6\1\u00d7\1\uffff\1\47\4\uffff\1\u00d9\1\uffff";
    static final String DFA16_eofS =
        "\u00da\uffff";
    static final String DFA16_minS =
        "\1\0\1\162\3\uffff\1\154\4\uffff\1\157\1\154\1\145\1\141\1\146\2\uffff\1\154\1\141\1\uffff\1\157\2\145\1\165\1\156\2\157\4\60\1\101\1\uffff\2\0\1\52\2\uffff\1\157\4\uffff\2\157\4\uffff\1\143\1\157\2\141\1\151\1\164\1\147\1\155\1\143\1\60\1\160\2\uffff\1\163\1\162\1\165\1\163\1\156\1\uffff\1\145\1\157\1\163\1\170\1\164\1\163\1\151\1\165\1\60\1\uffff\1\60\2\uffff\1\60\6\uffff\1\143\1\155\2\141\1\160\1\147\1\142\3\162\1\160\1\164\1\60\1\156\1\145\1\164\1\uffff\1\165\1\60\1\145\1\157\1\155\1\145\1\163\1\141\1\154\2\164\1\160\1\151\1\144\1\142\1\162\2\60\1\164\1\154\2\60\1\141\1\145\1\164\1\145\1\164\1\60\1\143\1\uffff\1\145\1\157\1\60\1\164\1\uffff\1\60\1\162\2\60\1\164\1\153\1\60\1\141\1\60\1\165\1\147\1\60\1\154\1\141\2\uffff\2\60\2\uffff\1\154\1\144\3\60\1\uffff\1\150\1\144\1\165\1\uffff\1\60\1\uffff\1\60\2\uffff\2\60\1\uffff\1\162\1\uffff\1\164\1\156\1\uffff\1\145\1\155\2\uffff\2\60\3\uffff\2\60\1\164\4\uffff\1\164\1\60\1\145\2\60\4\uffff\2\60\1\uffff\1\144\4\uffff\1\60\1\uffff";
    static final String DFA16_maxS =
        "\1\uffff\1\162\3\uffff\1\162\4\uffff\1\157\1\154\1\167\1\151\1\156\2\uffff\1\162\1\157\1\uffff\1\162\2\145\1\165\1\156\2\157\3\71\1\170\1\172\1\uffff\2\uffff\1\57\2\uffff\1\157\4\uffff\2\157\4\uffff\4\157\1\151\1\164\1\147\1\155\1\143\1\172\1\164\2\uffff\1\163\1\162\1\165\1\163\1\156\1\uffff\1\145\1\157\1\163\1\170\1\164\1\163\1\151\1\165\1\71\1\uffff\1\71\2\uffff\1\71\6\uffff\1\147\1\155\2\141\1\160\1\147\1\142\2\162\1\164\1\160\1\164\1\172\1\156\1\145\1\164\1\uffff\1\165\1\172\1\145\1\157\1\155\1\145\1\163\1\141\1\154\2\164\1\160\1\151\1\144\1\142\1\162\2\172\1\164\1\154\2\172\1\141\1\145\1\164\1\145\1\164\1\172\1\143\1\uffff\1\145\1\157\1\172\1\164\1\uffff\1\172\1\162\2\172\1\164\1\153\1\172\1\141\1\172\1\165\1\147\1\172\1\154\1\141\2\uffff\2\172\2\uffff\1\154\1\144\3\172\1\uffff\1\150\1\144\1\165\1\uffff\1\172\1\uffff\1\172\2\uffff\2\172\1\uffff\1\162\1\uffff\1\164\1\156\1\uffff\1\145\1\155\2\uffff\2\172\3\uffff\2\172\1\164\4\uffff\1\164\1\172\1\145\2\172\4\uffff\2\172\1\uffff\1\144\4\uffff\1\172\1\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\2\1\3\1\5\1\uffff\1\7\1\10\1\11\1\12\5\uffff\1\21\1\22\2\uffff\1\26\14\uffff\1\61\3\uffff\1\66\1\67\1\uffff\1\61\1\2\1\3\1\5\2\uffff\1\7\1\10\1\11\1\12\13\uffff\1\21\1\22\5\uffff\1\26\11\uffff\1\55\1\uffff\1\56\1\60\1\uffff\1\57\1\62\1\63\1\64\1\65\1\66\20\uffff\1\20\35\uffff\1\35\4\uffff\1\51\16\uffff\1\4\1\6\2\uffff\1\33\1\52\5\uffff\1\31\3\uffff\1\54\1\uffff\1\23\1\uffff\1\40\1\25\2\uffff\1\53\1\uffff\1\36\2\uffff\1\45\2\uffff\1\46\1\13\2\uffff\1\50\1\16\1\30\3\uffff\1\41\1\32\1\37\1\27\5\uffff\1\14\1\15\1\24\1\43\2\uffff\1\42\1\uffff\1\47\1\1\1\17\1\34\1\uffff\1\44";
    static final String DFA16_specialS =
        "\1\2\40\uffff\1\0\1\1\u00b7\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\45\2\44\2\45\1\44\22\45\1\44\1\45\1\41\4\45\1\42\1\17\1\20\2\45\1\7\2\45\1\43\1\36\1\34\6\35\1\33\1\35\1\23\1\4\1\45\1\6\3\45\32\40\1\10\1\45\1\11\1\37\1\40\1\45\1\40\1\24\1\22\1\32\1\21\1\5\1\13\1\40\1\16\2\40\1\12\1\40\1\26\1\27\1\1\1\40\1\25\1\14\1\15\1\30\1\31\4\40\1\2\1\45\1\3\uff82\45",
            "\1\46",
            "",
            "",
            "",
            "\1\54\5\uffff\1\53",
            "",
            "",
            "",
            "",
            "\1\61",
            "\1\62",
            "\1\66\2\uffff\1\63\1\67\12\uffff\1\64\2\uffff\1\65",
            "\1\71\7\uffff\1\70",
            "\1\72\7\uffff\1\73",
            "",
            "",
            "\1\76\1\uffff\1\100\3\uffff\1\77",
            "\1\101\15\uffff\1\102",
            "",
            "\1\105\2\uffff\1\104",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\12\114",
            "\6\114\1\116\3\114",
            "\12\114",
            "\10\121\2\123\36\uffff\1\120\37\uffff\1\120",
            "\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\0\124",
            "\0\124",
            "\1\125\4\uffff\1\126",
            "",
            "",
            "\1\130",
            "",
            "",
            "",
            "",
            "\1\131",
            "\1\132",
            "",
            "",
            "",
            "",
            "\1\133\12\uffff\1\135\1\134",
            "\1\136",
            "\1\137\15\uffff\1\140",
            "\1\141\15\uffff\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\151\3\uffff\1\152",
            "",
            "",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\12\114",
            "",
            "\12\114",
            "",
            "",
            "\10\121\2\123",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\171\3\uffff\1\170",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0083\1\uffff\1\u0082",
            "\1\u0084",
            "\1\u0085",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "",
            "\1\u008a",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u009c",
            "\1\u009d",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00a6",
            "",
            "\1\u00a7",
            "\1\u00a8",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00aa",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00ac",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00af",
            "\1\u00b0",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00b2",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00b4",
            "\1\u00b5",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\u00bb",
            "\1\u00bc",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u00c7",
            "",
            "\1\u00c8",
            "\1\u00c9",
            "",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d0",
            "",
            "",
            "",
            "",
            "\1\u00d1",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d3",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u00d8",
            "",
            "",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RULE_VOID_C_TYPE | RULE_FLOAT_C_TYPE | RULE_DOUBLE_C_TYPE | RULE_SHORT_C_TYPE | RULE_INT_C_TYPE | RULE_LONG_C_TYPE | RULE_BOOL_TYPE | RULE_TACT | RULE_REG_SIZE | RULE_DECIMAL | RULE_OCTAL | RULE_HEX | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_33 = input.LA(1);

                        s = -1;
                        if ( ((LA16_33>='\u0000' && LA16_33<='\uFFFF')) ) {s = 84;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_34 = input.LA(1);

                        s = -1;
                        if ( ((LA16_34>='\u0000' && LA16_34<='\uFFFF')) ) {s = 84;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0=='p') ) {s = 1;}

                        else if ( (LA16_0=='{') ) {s = 2;}

                        else if ( (LA16_0=='}') ) {s = 3;}

                        else if ( (LA16_0==';') ) {s = 4;}

                        else if ( (LA16_0=='f') ) {s = 5;}

                        else if ( (LA16_0=='=') ) {s = 6;}

                        else if ( (LA16_0==',') ) {s = 7;}

                        else if ( (LA16_0=='[') ) {s = 8;}

                        else if ( (LA16_0==']') ) {s = 9;}

                        else if ( (LA16_0=='l') ) {s = 10;}

                        else if ( (LA16_0=='g') ) {s = 11;}

                        else if ( (LA16_0=='s') ) {s = 12;}

                        else if ( (LA16_0=='t') ) {s = 13;}

                        else if ( (LA16_0=='i') ) {s = 14;}

                        else if ( (LA16_0=='(') ) {s = 15;}

                        else if ( (LA16_0==')') ) {s = 16;}

                        else if ( (LA16_0=='e') ) {s = 17;}

                        else if ( (LA16_0=='c') ) {s = 18;}

                        else if ( (LA16_0==':') ) {s = 19;}

                        else if ( (LA16_0=='b') ) {s = 20;}

                        else if ( (LA16_0=='r') ) {s = 21;}

                        else if ( (LA16_0=='n') ) {s = 22;}

                        else if ( (LA16_0=='o') ) {s = 23;}

                        else if ( (LA16_0=='u') ) {s = 24;}

                        else if ( (LA16_0=='v') ) {s = 25;}

                        else if ( (LA16_0=='d') ) {s = 26;}

                        else if ( (LA16_0=='8') ) {s = 27;}

                        else if ( (LA16_0=='1') ) {s = 28;}

                        else if ( ((LA16_0>='2' && LA16_0<='7')||LA16_0=='9') ) {s = 29;}

                        else if ( (LA16_0=='0') ) {s = 30;}

                        else if ( (LA16_0=='^') ) {s = 31;}

                        else if ( ((LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||LA16_0=='a'||LA16_0=='h'||(LA16_0>='j' && LA16_0<='k')||LA16_0=='m'||LA16_0=='q'||(LA16_0>='w' && LA16_0<='z')) ) {s = 32;}

                        else if ( (LA16_0=='\"') ) {s = 33;}

                        else if ( (LA16_0=='\'') ) {s = 34;}

                        else if ( (LA16_0=='/') ) {s = 35;}

                        else if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {s = 36;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||(LA16_0>='#' && LA16_0<='&')||(LA16_0>='*' && LA16_0<='+')||(LA16_0>='-' && LA16_0<='.')||LA16_0=='<'||(LA16_0>='>' && LA16_0<='@')||LA16_0=='\\'||LA16_0=='`'||LA16_0=='|'||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {s = 37;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}