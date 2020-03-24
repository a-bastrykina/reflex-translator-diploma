package ru.iaie.reflex.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ru.iaie.reflex.services.ReflexGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalReflexParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TACT", "RULE_BIT_AND", "RULE_BIT_XOR", "RULE_BIT_OR", "RULE_LOGICAL_AND", "RULE_LOGICAL_OR", "RULE_VOID_C_TYPE", "RULE_FLOAT_C_TYPE", "RULE_DOUBLE_C_TYPE", "RULE_SHORT_C_TYPE", "RULE_INT_C_TYPE", "RULE_LONG_C_TYPE", "RULE_BOOL_TYPE", "RULE_HEX", "RULE_OCTAL", "RULE_DECIMAL", "RULE_LONG", "RULE_UNSIGNED", "RULE_DEC_FLOAT", "RULE_HEX_FLOAT", "RULE_DAY", "RULE_HOUR", "RULE_DEC_SEQUENCE", "RULE_EXPONENT", "RULE_SIGN", "RULE_FLOAT_SUFFIX", "RULE_HEX_SEQUENCE", "RULE_BIN_EXPONENT", "RULE_HEX_PREFIX", "RULE_MINUTE", "RULE_SECOND", "RULE_MILISECOND", "RULE_MICROSECOND", "RULE_NANOSECOND", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'program'", "'{'", "'}'", "'proc'", "';'", "'from'", "','", "'='", "'['", "']'", "'local'", "'global'", "'shared'", "'state'", "'timeout'", "'if'", "'('", "')'", "'else'", "'switch'", "'case'", "':'", "'break'", "'start'", "'stop'", "'error'", "'loop'", "'restart'", "'reset'", "'set'", "'next'", "'const'", "'enum'", "'0t'", "'0T'", "'input'", "'output'", "'++'", "'--'", "'*='", "'/='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'+'", "'-'", "'~'", "'!'", "'<'", "'>'", "'=<'", "'>='", "'=='", "'!='", "'>>'", "'<<'", "'*'", "'/'", "'%'", "'signed'", "'unsigned'"
    };
    public static final int RULE_HEX=18;
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
    public static final int RULE_ID=4;
    public static final int RULE_TACT=5;
    public static final int RULE_HEX_FLOAT=24;
    public static final int RULE_INT_C_TYPE=15;
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
    public static final int RULE_VOID_C_TYPE=11;
    public static final int RULE_HEX_SEQUENCE=31;
    public static final int RULE_HOUR=26;
    public static final int RULE_UNSIGNED=22;
    public static final int RULE_DOUBLE_C_TYPE=13;
    public static final int RULE_BIN_EXPONENT=32;
    public static final int RULE_LOGICAL_AND=9;
    public static final int RULE_EXPONENT=28;
    public static final int T__48=48;
    public static final int RULE_DEC_FLOAT=23;
    public static final int T__49=49;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_BIT_AND=6;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int RULE_BOOL_TYPE=17;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int RULE_DAY=25;
    public static final int T__90=90;
    public static final int RULE_FLOAT_C_TYPE=12;
    public static final int RULE_OCTAL=19;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_SHORT_C_TYPE=14;
    public static final int RULE_DECIMAL=20;
    public static final int RULE_SECOND=35;
    public static final int RULE_LOGICAL_OR=10;
    public static final int RULE_LONG_C_TYPE=16;
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
    public static final int RULE_BIT_XOR=7;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_BIT_OR=8;
    public static final int RULE_LONG=21;
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


        public InternalReflexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReflexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReflexParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReflex.g"; }



     	private ReflexGrammarAccess grammarAccess;

        public InternalReflexParser(TokenStream input, ReflexGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Program";
       	}

       	@Override
       	protected ReflexGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgram"
    // InternalReflex.g:65:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalReflex.g:65:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalReflex.g:66:2: iv_ruleProgram= ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgram; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalReflex.g:72:1: ruleProgram returns [EObject current=null] : (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_ticks_3_0=null;
        Token otherlv_9=null;
        EObject lv_consts_4_0 = null;

        EObject lv_enums_5_0 = null;

        EObject lv_functions_6_0 = null;

        EObject lv_registers_7_0 = null;

        EObject lv_processes_8_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:78:2: ( (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' ) )
            // InternalReflex.g:79:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' )
            {
            // InternalReflex.g:79:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' )
            // InternalReflex.g:80:3: otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getProgramAccess().getProgramKeyword_0());
              		
            }
            // InternalReflex.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProgramAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProgramAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:106:3: ( (lv_ticks_3_0= RULE_TACT ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_TACT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalReflex.g:107:4: (lv_ticks_3_0= RULE_TACT )
                    {
                    // InternalReflex.g:107:4: (lv_ticks_3_0= RULE_TACT )
                    // InternalReflex.g:108:5: lv_ticks_3_0= RULE_TACT
                    {
                    lv_ticks_3_0=(Token)match(input,RULE_TACT,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_ticks_3_0, grammarAccess.getProgramAccess().getTicksTACTTerminalRuleCall_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getProgramRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"ticks",
                      						true,
                      						"ru.iaie.reflex.Reflex.TACT");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:124:3: ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )*
            loop2:
            do {
                int alt2=6;
                switch ( input.LA(1) ) {
                case 76:
                    {
                    alt2=1;
                    }
                    break;
                case 77:
                    {
                    alt2=2;
                    }
                    break;
                case RULE_VOID_C_TYPE:
                case RULE_FLOAT_C_TYPE:
                case RULE_DOUBLE_C_TYPE:
                case RULE_SHORT_C_TYPE:
                case RULE_INT_C_TYPE:
                case RULE_LONG_C_TYPE:
                case 108:
                case 109:
                    {
                    alt2=3;
                    }
                    break;
                case 80:
                case 81:
                    {
                    alt2=4;
                    }
                    break;
                case 48:
                    {
                    alt2=5;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // InternalReflex.g:125:4: ( (lv_consts_4_0= ruleConst ) )
            	    {
            	    // InternalReflex.g:125:4: ( (lv_consts_4_0= ruleConst ) )
            	    // InternalReflex.g:126:5: (lv_consts_4_0= ruleConst )
            	    {
            	    // InternalReflex.g:126:5: (lv_consts_4_0= ruleConst )
            	    // InternalReflex.g:127:6: lv_consts_4_0= ruleConst
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getConstsConstParserRuleCall_4_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_consts_4_0=ruleConst();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"consts",
            	      							lv_consts_4_0,
            	      							"ru.iaie.reflex.Reflex.Const");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalReflex.g:145:4: ( (lv_enums_5_0= ruleEnum ) )
            	    {
            	    // InternalReflex.g:145:4: ( (lv_enums_5_0= ruleEnum ) )
            	    // InternalReflex.g:146:5: (lv_enums_5_0= ruleEnum )
            	    {
            	    // InternalReflex.g:146:5: (lv_enums_5_0= ruleEnum )
            	    // InternalReflex.g:147:6: lv_enums_5_0= ruleEnum
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getEnumsEnumParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_enums_5_0=ruleEnum();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enums",
            	      							lv_enums_5_0,
            	      							"ru.iaie.reflex.Reflex.Enum");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalReflex.g:165:4: ( (lv_functions_6_0= ruleFunction ) )
            	    {
            	    // InternalReflex.g:165:4: ( (lv_functions_6_0= ruleFunction ) )
            	    // InternalReflex.g:166:5: (lv_functions_6_0= ruleFunction )
            	    {
            	    // InternalReflex.g:166:5: (lv_functions_6_0= ruleFunction )
            	    // InternalReflex.g:167:6: lv_functions_6_0= ruleFunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getFunctionsFunctionParserRuleCall_4_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_functions_6_0=ruleFunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"functions",
            	      							lv_functions_6_0,
            	      							"ru.iaie.reflex.Reflex.Function");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalReflex.g:185:4: ( (lv_registers_7_0= ruleRegister ) )
            	    {
            	    // InternalReflex.g:185:4: ( (lv_registers_7_0= ruleRegister ) )
            	    // InternalReflex.g:186:5: (lv_registers_7_0= ruleRegister )
            	    {
            	    // InternalReflex.g:186:5: (lv_registers_7_0= ruleRegister )
            	    // InternalReflex.g:187:6: lv_registers_7_0= ruleRegister
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getRegistersRegisterParserRuleCall_4_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_registers_7_0=ruleRegister();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"registers",
            	      							lv_registers_7_0,
            	      							"ru.iaie.reflex.Reflex.Register");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalReflex.g:205:4: ( (lv_processes_8_0= ruleProcess ) )
            	    {
            	    // InternalReflex.g:205:4: ( (lv_processes_8_0= ruleProcess ) )
            	    // InternalReflex.g:206:5: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalReflex.g:206:5: (lv_processes_8_0= ruleProcess )
            	    // InternalReflex.g:207:6: lv_processes_8_0= ruleProcess
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getProcessesProcessParserRuleCall_4_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_processes_8_0=ruleProcess();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"processes",
            	      							lv_processes_8_0,
            	      							"ru.iaie.reflex.Reflex.Process");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_9=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getProgramAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleProcess"
    // InternalReflex.g:233:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalReflex.g:233:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalReflex.g:234:2: iv_ruleProcess= ruleProcess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcess; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalReflex.g:240:1: ruleProcess returns [EObject current=null] : (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_variable_3_0 = null;

        EObject lv_states_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:246:2: ( (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' ) )
            // InternalReflex.g:247:2: (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' )
            {
            // InternalReflex.g:247:2: (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' )
            // InternalReflex.g:248:3: otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getProcKeyword_0());
              		
            }
            // InternalReflex.g:252:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:253:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:253:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:254:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProcessRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:274:3: ( (lv_variable_3_0= ruleVariable ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_VOID_C_TYPE && LA3_0<=RULE_BOOL_TYPE)||LA3_0==50||(LA3_0>=108 && LA3_0<=109)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalReflex.g:275:4: (lv_variable_3_0= ruleVariable )
            	    {
            	    // InternalReflex.g:275:4: (lv_variable_3_0= ruleVariable )
            	    // InternalReflex.g:276:5: lv_variable_3_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getVariableVariableParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_variable_3_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"variable",
            	      						lv_variable_3_0,
            	      						"ru.iaie.reflex.Reflex.Variable");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalReflex.g:293:3: ( (lv_states_4_0= ruleState ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==58) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalReflex.g:294:4: (lv_states_4_0= ruleState )
            	    {
            	    // InternalReflex.g:294:4: (lv_states_4_0= ruleState )
            	    // InternalReflex.g:295:5: lv_states_4_0= ruleState
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_states_4_0=ruleState();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"states",
            	      						lv_states_4_0,
            	      						"ru.iaie.reflex.Reflex.State");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_5=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleVariable"
    // InternalReflex.g:320:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalReflex.g:320:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalReflex.g:321:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalReflex.g:327:1: ruleVariable returns [EObject current=null] : ( (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ImportedVariable_0 = null;

        EObject this_DeclaredVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:333:2: ( ( (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' ) )
            // InternalReflex.g:334:2: ( (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' )
            {
            // InternalReflex.g:334:2: ( (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' )
            // InternalReflex.g:335:3: (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';'
            {
            // InternalReflex.g:335:3: (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==50) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_VOID_C_TYPE && LA5_0<=RULE_BOOL_TYPE)||(LA5_0>=108 && LA5_0<=109)) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalReflex.g:336:4: this_ImportedVariable_0= ruleImportedVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getVariableAccess().getImportedVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_9);
                    this_ImportedVariable_0=ruleImportedVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ImportedVariable_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:345:4: this_DeclaredVariable_1= ruleDeclaredVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getVariableAccess().getDeclaredVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_9);
                    this_DeclaredVariable_1=ruleDeclaredVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_DeclaredVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_2=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleImportedVariable"
    // InternalReflex.g:362:1: entryRuleImportedVariable returns [EObject current=null] : iv_ruleImportedVariable= ruleImportedVariable EOF ;
    public final EObject entryRuleImportedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedVariable = null;


        try {
            // InternalReflex.g:362:57: (iv_ruleImportedVariable= ruleImportedVariable EOF )
            // InternalReflex.g:363:2: iv_ruleImportedVariable= ruleImportedVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportedVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportedVariable=ruleImportedVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportedVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedVariable"


    // $ANTLR start "ruleImportedVariable"
    // InternalReflex.g:369:1: ruleImportedVariable returns [EObject current=null] : (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )* ) ;
    public final EObject ruleImportedVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token lv_varNames_3_0=null;
        Token otherlv_4=null;
        Token lv_varNames_5_0=null;


        	enterRule();

        try {
            // InternalReflex.g:375:2: ( (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )* ) )
            // InternalReflex.g:376:2: (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )* )
            {
            // InternalReflex.g:376:2: (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )* )
            // InternalReflex.g:377:3: otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,50,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportedVariableAccess().getFromKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,48,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getImportedVariableAccess().getProcKeyword_1());
              		
            }
            // InternalReflex.g:385:3: ( (lv_procId_2_0= RULE_ID ) )
            // InternalReflex.g:386:4: (lv_procId_2_0= RULE_ID )
            {
            // InternalReflex.g:386:4: (lv_procId_2_0= RULE_ID )
            // InternalReflex.g:387:5: lv_procId_2_0= RULE_ID
            {
            lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_procId_2_0, grammarAccess.getImportedVariableAccess().getProcIdIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportedVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"procId",
              						lv_procId_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:403:3: ( (lv_varNames_3_0= RULE_ID ) )
            // InternalReflex.g:404:4: (lv_varNames_3_0= RULE_ID )
            {
            // InternalReflex.g:404:4: (lv_varNames_3_0= RULE_ID )
            // InternalReflex.g:405:5: lv_varNames_3_0= RULE_ID
            {
            lv_varNames_3_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_varNames_3_0, grammarAccess.getImportedVariableAccess().getVarNamesIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportedVariableRule());
              					}
              					addWithLastConsumed(
              						current,
              						"varNames",
              						lv_varNames_3_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:421:3: (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==51) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReflex.g:422:4: otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getImportedVariableAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:426:4: ( (lv_varNames_5_0= RULE_ID ) )
            	    // InternalReflex.g:427:5: (lv_varNames_5_0= RULE_ID )
            	    {
            	    // InternalReflex.g:427:5: (lv_varNames_5_0= RULE_ID )
            	    // InternalReflex.g:428:6: lv_varNames_5_0= RULE_ID
            	    {
            	    lv_varNames_5_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_varNames_5_0, grammarAccess.getImportedVariableAccess().getVarNamesIDTerminalRuleCall_4_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getImportedVariableRule());
            	      						}
            	      						addWithLastConsumed(
            	      							current,
            	      							"varNames",
            	      							lv_varNames_5_0,
            	      							"org.eclipse.xtext.common.Terminals.ID");
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedVariable"


    // $ANTLR start "entryRuleDeclaredVariable"
    // InternalReflex.g:449:1: entryRuleDeclaredVariable returns [EObject current=null] : iv_ruleDeclaredVariable= ruleDeclaredVariable EOF ;
    public final EObject entryRuleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredVariable = null;


        try {
            // InternalReflex.g:449:57: (iv_ruleDeclaredVariable= ruleDeclaredVariable EOF )
            // InternalReflex.g:450:2: iv_ruleDeclaredVariable= ruleDeclaredVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaredVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclaredVariable=ruleDeclaredVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaredVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaredVariable"


    // $ANTLR start "ruleDeclaredVariable"
    // InternalReflex.g:456:1: ruleDeclaredVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) ) ;
    public final EObject ruleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;

        EObject lv_visibility_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:462:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) ) )
            // InternalReflex.g:463:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) )
            {
            // InternalReflex.g:463:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) )
            // InternalReflex.g:464:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) )
            {
            // InternalReflex.g:464:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt7=2;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( ((LA7_6>=55 && LA7_6<=57)) ) {
                        alt7=2;
                    }
                    else if ( (LA7_6==52) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT_C_TYPE:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( ((LA7_6>=55 && LA7_6<=57)) ) {
                        alt7=2;
                    }
                    else if ( (LA7_6==52) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                int LA7_3 = input.LA(2);

                if ( (LA7_3==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( ((LA7_6>=55 && LA7_6<=57)) ) {
                        alt7=2;
                    }
                    else if ( (LA7_6==52) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                int LA7_4 = input.LA(2);

                if ( (LA7_4==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( ((LA7_6>=55 && LA7_6<=57)) ) {
                        alt7=2;
                    }
                    else if ( (LA7_6==52) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VOID_C_TYPE:
            case RULE_FLOAT_C_TYPE:
            case RULE_DOUBLE_C_TYPE:
            case 108:
            case 109:
                {
                alt7=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalReflex.g:465:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_12);
                    this_PhysicalVariable_0=rulePhysicalVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_PhysicalVariable_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:474:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_12);
                    this_ProgramVariable_1=ruleProgramVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ProgramVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalReflex.g:483:3: ( (lv_visibility_2_0= ruleVisibility ) )
            // InternalReflex.g:484:4: (lv_visibility_2_0= ruleVisibility )
            {
            // InternalReflex.g:484:4: (lv_visibility_2_0= ruleVisibility )
            // InternalReflex.g:485:5: lv_visibility_2_0= ruleVisibility
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclaredVariableAccess().getVisibilityVisibilityParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_visibility_2_0=ruleVisibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeclaredVariableRule());
              					}
              					set(
              						current,
              						"visibility",
              						lv_visibility_2_0,
              						"ru.iaie.reflex.Reflex.Visibility");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaredVariable"


    // $ANTLR start "entryRulePhysicalVariable"
    // InternalReflex.g:506:1: entryRulePhysicalVariable returns [EObject current=null] : iv_rulePhysicalVariable= rulePhysicalVariable EOF ;
    public final EObject entryRulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalVariable = null;


        try {
            // InternalReflex.g:506:57: (iv_rulePhysicalVariable= rulePhysicalVariable EOF )
            // InternalReflex.g:507:2: iv_rulePhysicalVariable= rulePhysicalVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPhysicalVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePhysicalVariable=rulePhysicalVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePhysicalVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysicalVariable"


    // $ANTLR start "rulePhysicalVariable"
    // InternalReflex.g:513:1: rulePhysicalVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' ) ;
    public final EObject rulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_ports_4_0 = null;

        EObject lv_ports_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:519:2: ( ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' ) )
            // InternalReflex.g:520:2: ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' )
            {
            // InternalReflex.g:520:2: ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' )
            // InternalReflex.g:521:3: ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}'
            {
            // InternalReflex.g:521:3: ( (lv_type_0_0= ruleIntegerType ) )
            // InternalReflex.g:522:4: (lv_type_0_0= ruleIntegerType )
            {
            // InternalReflex.g:522:4: (lv_type_0_0= ruleIntegerType )
            // InternalReflex.g:523:5: lv_type_0_0= ruleIntegerType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getTypeIntegerTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleIntegerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.IntegerType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:540:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:541:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:541:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:542:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPhysicalVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPhysicalVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,52,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPhysicalVariableAccess().getEqualsSignKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getPhysicalVariableAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalReflex.g:566:3: ( (lv_ports_4_0= ruleRegisterPort ) )
            // InternalReflex.g:567:4: (lv_ports_4_0= ruleRegisterPort )
            {
            // InternalReflex.g:567:4: (lv_ports_4_0= ruleRegisterPort )
            // InternalReflex.g:568:5: lv_ports_4_0= ruleRegisterPort
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getPortsRegisterPortParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_ports_4_0=ruleRegisterPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					add(
              						current,
              						"ports",
              						lv_ports_4_0,
              						"ru.iaie.reflex.Reflex.RegisterPort");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:585:3: (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==51) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalReflex.g:586:4: otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) )
            	    {
            	    otherlv_5=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_5, grammarAccess.getPhysicalVariableAccess().getCommaKeyword_5_0());
            	      			
            	    }
            	    // InternalReflex.g:590:4: ( (lv_ports_6_0= ruleRegisterPort ) )
            	    // InternalReflex.g:591:5: (lv_ports_6_0= ruleRegisterPort )
            	    {
            	    // InternalReflex.g:591:5: (lv_ports_6_0= ruleRegisterPort )
            	    // InternalReflex.g:592:6: lv_ports_6_0= ruleRegisterPort
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPhysicalVariableAccess().getPortsRegisterPortParserRuleCall_5_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_ports_6_0=ruleRegisterPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
            	      						}
            	      						add(
            	      							current,
            	      							"ports",
            	      							lv_ports_6_0,
            	      							"ru.iaie.reflex.Reflex.RegisterPort");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_7=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getPhysicalVariableAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysicalVariable"


    // $ANTLR start "entryRuleRegisterPort"
    // InternalReflex.g:618:1: entryRuleRegisterPort returns [EObject current=null] : iv_ruleRegisterPort= ruleRegisterPort EOF ;
    public final EObject entryRuleRegisterPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegisterPort = null;


        try {
            // InternalReflex.g:618:53: (iv_ruleRegisterPort= ruleRegisterPort EOF )
            // InternalReflex.g:619:2: iv_ruleRegisterPort= ruleRegisterPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterPortRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegisterPort=ruleRegisterPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegisterPort; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegisterPort"


    // $ANTLR start "ruleRegisterPort"
    // InternalReflex.g:625:1: ruleRegisterPort returns [EObject current=null] : ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' ) ;
    public final EObject ruleRegisterPort() throws RecognitionException {
        EObject current = null;

        Token lv_regName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_port_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:631:2: ( ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' ) )
            // InternalReflex.g:632:2: ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' )
            {
            // InternalReflex.g:632:2: ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' )
            // InternalReflex.g:633:3: ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']'
            {
            // InternalReflex.g:633:3: ( (lv_regName_0_0= RULE_ID ) )
            // InternalReflex.g:634:4: (lv_regName_0_0= RULE_ID )
            {
            // InternalReflex.g:634:4: (lv_regName_0_0= RULE_ID )
            // InternalReflex.g:635:5: lv_regName_0_0= RULE_ID
            {
            lv_regName_0_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_regName_0_0, grammarAccess.getRegisterPortAccess().getRegNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"regName",
              						lv_regName_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,53,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRegisterPortAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalReflex.g:655:3: ( (lv_port_2_0= ruleInteger ) )
            // InternalReflex.g:656:4: (lv_port_2_0= ruleInteger )
            {
            // InternalReflex.g:656:4: (lv_port_2_0= ruleInteger )
            // InternalReflex.g:657:5: lv_port_2_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterPortAccess().getPortIntegerParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_port_2_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterPortRule());
              					}
              					set(
              						current,
              						"port",
              						lv_port_2_0,
              						"ru.iaie.reflex.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRegisterPortAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegisterPort"


    // $ANTLR start "entryRuleProgramVariable"
    // InternalReflex.g:682:1: entryRuleProgramVariable returns [EObject current=null] : iv_ruleProgramVariable= ruleProgramVariable EOF ;
    public final EObject entryRuleProgramVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramVariable = null;


        try {
            // InternalReflex.g:682:56: (iv_ruleProgramVariable= ruleProgramVariable EOF )
            // InternalReflex.g:683:2: iv_ruleProgramVariable= ruleProgramVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgramVariable=ruleProgramVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgramVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramVariable"


    // $ANTLR start "ruleProgramVariable"
    // InternalReflex.g:689:1: ruleProgramVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProgramVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:695:2: ( ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:696:2: ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:696:2: ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalReflex.g:697:3: ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalReflex.g:697:3: ( (lv_type_0_0= ruleReflexType ) )
            // InternalReflex.g:698:4: (lv_type_0_0= ruleReflexType )
            {
            // InternalReflex.g:698:4: (lv_type_0_0= ruleReflexType )
            // InternalReflex.g:699:5: lv_type_0_0= ruleReflexType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProgramVariableAccess().getTypeReflexTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleReflexType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProgramVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.ReflexType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:716:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:717:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:717:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:718:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProgramVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramVariable"


    // $ANTLR start "entryRuleVisibility"
    // InternalReflex.g:738:1: entryRuleVisibility returns [EObject current=null] : iv_ruleVisibility= ruleVisibility EOF ;
    public final EObject entryRuleVisibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibility = null;


        try {
            // InternalReflex.g:738:51: (iv_ruleVisibility= ruleVisibility EOF )
            // InternalReflex.g:739:2: iv_ruleVisibility= ruleVisibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVisibilityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVisibility=ruleVisibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVisibility; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVisibility"


    // $ANTLR start "ruleVisibility"
    // InternalReflex.g:745:1: ruleVisibility returns [EObject current=null] : ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_sharingProcs_5_0= RULE_ID ) ) )* ) ) ;
    public final EObject ruleVisibility() throws RecognitionException {
        EObject current = null;

        Token lv_LOCAL_0_0=null;
        Token lv_GLOBAL_1_0=null;
        Token lv_SHARED_2_0=null;
        Token lv_sharingProcs_3_0=null;
        Token otherlv_4=null;
        Token lv_sharingProcs_5_0=null;


        	enterRule();

        try {
            // InternalReflex.g:751:2: ( ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_sharingProcs_5_0= RULE_ID ) ) )* ) ) )
            // InternalReflex.g:752:2: ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_sharingProcs_5_0= RULE_ID ) ) )* ) )
            {
            // InternalReflex.g:752:2: ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_sharingProcs_5_0= RULE_ID ) ) )* ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt10=1;
                }
                break;
            case 56:
                {
                alt10=2;
                }
                break;
            case 57:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalReflex.g:753:3: ( (lv_LOCAL_0_0= 'local' ) )
                    {
                    // InternalReflex.g:753:3: ( (lv_LOCAL_0_0= 'local' ) )
                    // InternalReflex.g:754:4: (lv_LOCAL_0_0= 'local' )
                    {
                    // InternalReflex.g:754:4: (lv_LOCAL_0_0= 'local' )
                    // InternalReflex.g:755:5: lv_LOCAL_0_0= 'local'
                    {
                    lv_LOCAL_0_0=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_LOCAL_0_0, grammarAccess.getVisibilityAccess().getLOCALLocalKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVisibilityRule());
                      					}
                      					setWithLastConsumed(current, "LOCAL", lv_LOCAL_0_0, "local");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:768:3: ( (lv_GLOBAL_1_0= 'global' ) )
                    {
                    // InternalReflex.g:768:3: ( (lv_GLOBAL_1_0= 'global' ) )
                    // InternalReflex.g:769:4: (lv_GLOBAL_1_0= 'global' )
                    {
                    // InternalReflex.g:769:4: (lv_GLOBAL_1_0= 'global' )
                    // InternalReflex.g:770:5: lv_GLOBAL_1_0= 'global'
                    {
                    lv_GLOBAL_1_0=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_GLOBAL_1_0, grammarAccess.getVisibilityAccess().getGLOBALGlobalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVisibilityRule());
                      					}
                      					setWithLastConsumed(current, "GLOBAL", lv_GLOBAL_1_0, "global");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:783:3: ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_sharingProcs_5_0= RULE_ID ) ) )* )
                    {
                    // InternalReflex.g:783:3: ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_sharingProcs_5_0= RULE_ID ) ) )* )
                    // InternalReflex.g:784:4: ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_sharingProcs_5_0= RULE_ID ) ) )*
                    {
                    // InternalReflex.g:784:4: ( (lv_SHARED_2_0= 'shared' ) )
                    // InternalReflex.g:785:5: (lv_SHARED_2_0= 'shared' )
                    {
                    // InternalReflex.g:785:5: (lv_SHARED_2_0= 'shared' )
                    // InternalReflex.g:786:6: lv_SHARED_2_0= 'shared'
                    {
                    lv_SHARED_2_0=(Token)match(input,57,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_SHARED_2_0, grammarAccess.getVisibilityAccess().getSHAREDSharedKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVisibilityRule());
                      						}
                      						setWithLastConsumed(current, "SHARED", lv_SHARED_2_0, "shared");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:798:4: ( (lv_sharingProcs_3_0= RULE_ID ) )
                    // InternalReflex.g:799:5: (lv_sharingProcs_3_0= RULE_ID )
                    {
                    // InternalReflex.g:799:5: (lv_sharingProcs_3_0= RULE_ID )
                    // InternalReflex.g:800:6: lv_sharingProcs_3_0= RULE_ID
                    {
                    lv_sharingProcs_3_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_sharingProcs_3_0, grammarAccess.getVisibilityAccess().getSharingProcsIDTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVisibilityRule());
                      						}
                      						addWithLastConsumed(
                      							current,
                      							"sharingProcs",
                      							lv_sharingProcs_3_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:816:4: (otherlv_4= ',' ( (lv_sharingProcs_5_0= RULE_ID ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==51) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalReflex.g:817:5: otherlv_4= ',' ( (lv_sharingProcs_5_0= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getVisibilityAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalReflex.g:821:5: ( (lv_sharingProcs_5_0= RULE_ID ) )
                    	    // InternalReflex.g:822:6: (lv_sharingProcs_5_0= RULE_ID )
                    	    {
                    	    // InternalReflex.g:822:6: (lv_sharingProcs_5_0= RULE_ID )
                    	    // InternalReflex.g:823:7: lv_sharingProcs_5_0= RULE_ID
                    	    {
                    	    lv_sharingProcs_5_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(lv_sharingProcs_5_0, grammarAccess.getVisibilityAccess().getSharingProcsIDTerminalRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getVisibilityRule());
                    	      							}
                    	      							addWithLastConsumed(
                    	      								current,
                    	      								"sharingProcs",
                    	      								lv_sharingProcs_5_0,
                    	      								"org.eclipse.xtext.common.Terminals.ID");
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVisibility"


    // $ANTLR start "entryRuleState"
    // InternalReflex.g:845:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalReflex.g:845:46: (iv_ruleState= ruleState EOF )
            // InternalReflex.g:846:2: iv_ruleState= ruleState EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleState; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalReflex.g:852:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_stateFunction_3_0 = null;

        EObject lv_timeoutFunction_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:858:2: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' ) )
            // InternalReflex.g:859:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' )
            {
            // InternalReflex.g:859:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' )
            // InternalReflex.g:860:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
              		
            }
            // InternalReflex.g:864:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:865:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:865:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:866:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStateRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:886:3: ( (lv_stateFunction_3_0= ruleStatementSequence ) )
            // InternalReflex.g:887:4: (lv_stateFunction_3_0= ruleStatementSequence )
            {
            // InternalReflex.g:887:4: (lv_stateFunction_3_0= ruleStatementSequence )
            // InternalReflex.g:888:5: lv_stateFunction_3_0= ruleStatementSequence
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStateAccess().getStateFunctionStatementSequenceParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_stateFunction_3_0=ruleStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStateRule());
              					}
              					set(
              						current,
              						"stateFunction",
              						lv_stateFunction_3_0,
              						"ru.iaie.reflex.Reflex.StatementSequence");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:905:3: ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==59) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalReflex.g:906:4: (lv_timeoutFunction_4_0= ruleTimeoutFunction )
                    {
                    // InternalReflex.g:906:4: (lv_timeoutFunction_4_0= ruleTimeoutFunction )
                    // InternalReflex.g:907:5: lv_timeoutFunction_4_0= ruleTimeoutFunction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStateAccess().getTimeoutFunctionTimeoutFunctionParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
                    lv_timeoutFunction_4_0=ruleTimeoutFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStateRule());
                      					}
                      					set(
                      						current,
                      						"timeoutFunction",
                      						lv_timeoutFunction_4_0,
                      						"ru.iaie.reflex.Reflex.TimeoutFunction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleStatementSequence"
    // InternalReflex.g:932:1: entryRuleStatementSequence returns [EObject current=null] : iv_ruleStatementSequence= ruleStatementSequence EOF ;
    public final EObject entryRuleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementSequence = null;


        try {
            // InternalReflex.g:932:58: (iv_ruleStatementSequence= ruleStatementSequence EOF )
            // InternalReflex.g:933:2: iv_ruleStatementSequence= ruleStatementSequence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatementSequence=ruleStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementSequence; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementSequence"


    // $ANTLR start "ruleStatementSequence"
    // InternalReflex.g:939:1: ruleStatementSequence returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:945:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalReflex.g:946:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalReflex.g:946:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalReflex.g:947:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalReflex.g:947:3: ()
            // InternalReflex.g:948:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStatementSequenceAccess().getStatementSequenceAction_0(),
              					current);
              			
            }

            }

            // InternalReflex.g:954:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||(LA12_0>=RULE_HEX && LA12_0<=RULE_DECIMAL)||(LA12_0>=RULE_DEC_FLOAT && LA12_0<=RULE_HEX_FLOAT)||LA12_0==46||LA12_0==49||(LA12_0>=60 && LA12_0<=61)||LA12_0==64||(LA12_0>=68 && LA12_0<=74)||(LA12_0>=82 && LA12_0<=83)||(LA12_0>=93 && LA12_0<=96)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalReflex.g:955:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalReflex.g:955:4: (lv_statements_1_0= ruleStatement )
            	    // InternalReflex.g:956:5: lv_statements_1_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStatementSequenceAccess().getStatementsStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_statements_1_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getStatementSequenceRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_1_0,
            	      						"ru.iaie.reflex.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementSequence"


    // $ANTLR start "entryRuleStatementBlock"
    // InternalReflex.g:977:1: entryRuleStatementBlock returns [EObject current=null] : iv_ruleStatementBlock= ruleStatementBlock EOF ;
    public final EObject entryRuleStatementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementBlock = null;


        try {
            // InternalReflex.g:977:55: (iv_ruleStatementBlock= ruleStatementBlock EOF )
            // InternalReflex.g:978:2: iv_ruleStatementBlock= ruleStatementBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatementBlock=ruleStatementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementBlock"


    // $ANTLR start "ruleStatementBlock"
    // InternalReflex.g:984:1: ruleStatementBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleStatementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:990:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // InternalReflex.g:991:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // InternalReflex.g:991:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // InternalReflex.g:992:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // InternalReflex.g:992:3: ()
            // InternalReflex.g:993:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStatementBlockAccess().getStatementBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,46,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStatementBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalReflex.g:1003:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||(LA13_0>=RULE_HEX && LA13_0<=RULE_DECIMAL)||(LA13_0>=RULE_DEC_FLOAT && LA13_0<=RULE_HEX_FLOAT)||LA13_0==46||LA13_0==49||(LA13_0>=60 && LA13_0<=61)||LA13_0==64||(LA13_0>=68 && LA13_0<=74)||(LA13_0>=82 && LA13_0<=83)||(LA13_0>=93 && LA13_0<=96)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalReflex.g:1004:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalReflex.g:1004:4: (lv_statements_2_0= ruleStatement )
            	    // InternalReflex.g:1005:5: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStatementBlockAccess().getStatementsStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getStatementBlockRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"ru.iaie.reflex.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_3=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStatementBlockAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementBlock"


    // $ANTLR start "entryRuleTimeoutFunction"
    // InternalReflex.g:1030:1: entryRuleTimeoutFunction returns [EObject current=null] : iv_ruleTimeoutFunction= ruleTimeoutFunction EOF ;
    public final EObject entryRuleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutFunction = null;


        try {
            // InternalReflex.g:1030:56: (iv_ruleTimeoutFunction= ruleTimeoutFunction EOF )
            // InternalReflex.g:1031:2: iv_ruleTimeoutFunction= ruleTimeoutFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeoutFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTimeoutFunction=ruleTimeoutFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimeoutFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeoutFunction"


    // $ANTLR start "ruleTimeoutFunction"
    // InternalReflex.g:1037:1: ruleTimeoutFunction returns [EObject current=null] : (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) ) ;
    public final EObject ruleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_time_1_0 = null;

        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1043:2: ( (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) ) )
            // InternalReflex.g:1044:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) )
            {
            // InternalReflex.g:1044:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) )
            // InternalReflex.g:1045:3: otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTimeoutFunctionAccess().getTimeoutKeyword_0());
              		
            }
            // InternalReflex.g:1049:3: ( (lv_time_1_0= ruleTime ) )
            // InternalReflex.g:1050:4: (lv_time_1_0= ruleTime )
            {
            // InternalReflex.g:1050:4: (lv_time_1_0= ruleTime )
            // InternalReflex.g:1051:5: lv_time_1_0= ruleTime
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getTimeTimeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_time_1_0=ruleTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTimeoutFunctionRule());
              					}
              					set(
              						current,
              						"time",
              						lv_time_1_0,
              						"ru.iaie.reflex.Reflex.Time");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1068:3: ( (lv_body_2_0= ruleStatement ) )
            // InternalReflex.g:1069:4: (lv_body_2_0= ruleStatement )
            {
            // InternalReflex.g:1069:4: (lv_body_2_0= ruleStatement )
            // InternalReflex.g:1070:5: lv_body_2_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getBodyStatementParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_2_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTimeoutFunctionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_2_0,
              						"ru.iaie.reflex.Reflex.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeoutFunction"


    // $ANTLR start "entryRuleStatement"
    // InternalReflex.g:1091:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalReflex.g:1091:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalReflex.g:1092:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalReflex.g:1098:1: ruleStatement returns [EObject current=null] : ( ( () otherlv_1= ';' ) | this_StatementBlock_2= ruleStatementBlock | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_LoopStat_6= ruleLoopStat | this_RestartStat_7= ruleRestartStat | this_ResetStat_8= ruleResetStat | this_SetStateStat_9= ruleSetStateStat | this_IfElseStat_10= ruleIfElseStat | this_SwitchStat_11= ruleSwitchStat | (this_Expression_12= ruleExpression otherlv_13= ';' ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_13=null;
        EObject this_StatementBlock_2 = null;

        EObject this_StartProcStat_3 = null;

        EObject this_StopProcStat_4 = null;

        EObject this_ErrorStat_5 = null;

        EObject this_LoopStat_6 = null;

        EObject this_RestartStat_7 = null;

        EObject this_ResetStat_8 = null;

        EObject this_SetStateStat_9 = null;

        EObject this_IfElseStat_10 = null;

        EObject this_SwitchStat_11 = null;

        EObject this_Expression_12 = null;



        	enterRule();

        try {
            // InternalReflex.g:1104:2: ( ( ( () otherlv_1= ';' ) | this_StatementBlock_2= ruleStatementBlock | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_LoopStat_6= ruleLoopStat | this_RestartStat_7= ruleRestartStat | this_ResetStat_8= ruleResetStat | this_SetStateStat_9= ruleSetStateStat | this_IfElseStat_10= ruleIfElseStat | this_SwitchStat_11= ruleSwitchStat | (this_Expression_12= ruleExpression otherlv_13= ';' ) ) )
            // InternalReflex.g:1105:2: ( ( () otherlv_1= ';' ) | this_StatementBlock_2= ruleStatementBlock | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_LoopStat_6= ruleLoopStat | this_RestartStat_7= ruleRestartStat | this_ResetStat_8= ruleResetStat | this_SetStateStat_9= ruleSetStateStat | this_IfElseStat_10= ruleIfElseStat | this_SwitchStat_11= ruleSwitchStat | (this_Expression_12= ruleExpression otherlv_13= ';' ) )
            {
            // InternalReflex.g:1105:2: ( ( () otherlv_1= ';' ) | this_StatementBlock_2= ruleStatementBlock | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_LoopStat_6= ruleLoopStat | this_RestartStat_7= ruleRestartStat | this_ResetStat_8= ruleResetStat | this_SetStateStat_9= ruleSetStateStat | this_IfElseStat_10= ruleIfElseStat | this_SwitchStat_11= ruleSwitchStat | (this_Expression_12= ruleExpression otherlv_13= ';' ) )
            int alt14=12;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt14=1;
                }
                break;
            case 46:
                {
                alt14=2;
                }
                break;
            case 68:
                {
                alt14=3;
                }
                break;
            case 69:
                {
                alt14=4;
                }
                break;
            case 70:
                {
                alt14=5;
                }
                break;
            case 71:
                {
                alt14=6;
                }
                break;
            case 72:
                {
                alt14=7;
                }
                break;
            case 73:
                {
                alt14=8;
                }
                break;
            case 74:
                {
                alt14=9;
                }
                break;
            case 60:
                {
                alt14=10;
                }
                break;
            case 64:
                {
                alt14=11;
                }
                break;
            case RULE_ID:
            case RULE_HEX:
            case RULE_OCTAL:
            case RULE_DECIMAL:
            case RULE_DEC_FLOAT:
            case RULE_HEX_FLOAT:
            case 61:
            case 82:
            case 83:
            case 93:
            case 94:
            case 95:
            case 96:
                {
                alt14=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalReflex.g:1106:3: ( () otherlv_1= ';' )
                    {
                    // InternalReflex.g:1106:3: ( () otherlv_1= ';' )
                    // InternalReflex.g:1107:4: () otherlv_1= ';'
                    {
                    // InternalReflex.g:1107:4: ()
                    // InternalReflex.g:1108:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getStatementAccess().getStatementAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1120:3: this_StatementBlock_2= ruleStatementBlock
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getStatementBlockParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StatementBlock_2=ruleStatementBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StatementBlock_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:1129:3: this_StartProcStat_3= ruleStartProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getStartProcStatParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StartProcStat_3=ruleStartProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StartProcStat_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:1138:3: this_StopProcStat_4= ruleStopProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getStopProcStatParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StopProcStat_4=ruleStopProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StopProcStat_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalReflex.g:1147:3: this_ErrorStat_5= ruleErrorStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getErrorStatParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ErrorStat_5=ruleErrorStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ErrorStat_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalReflex.g:1156:3: this_LoopStat_6= ruleLoopStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getLoopStatParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LoopStat_6=ruleLoopStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LoopStat_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalReflex.g:1165:3: this_RestartStat_7= ruleRestartStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getRestartStatParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RestartStat_7=ruleRestartStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RestartStat_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalReflex.g:1174:3: this_ResetStat_8= ruleResetStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getResetStatParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ResetStat_8=ruleResetStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ResetStat_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalReflex.g:1183:3: this_SetStateStat_9= ruleSetStateStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSetStateStatParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SetStateStat_9=ruleSetStateStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetStateStat_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalReflex.g:1192:3: this_IfElseStat_10= ruleIfElseStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getIfElseStatParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfElseStat_10=ruleIfElseStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfElseStat_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalReflex.g:1201:3: this_SwitchStat_11= ruleSwitchStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSwitchStatParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SwitchStat_11=ruleSwitchStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SwitchStat_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalReflex.g:1210:3: (this_Expression_12= ruleExpression otherlv_13= ';' )
                    {
                    // InternalReflex.g:1210:3: (this_Expression_12= ruleExpression otherlv_13= ';' )
                    // InternalReflex.g:1211:4: this_Expression_12= ruleExpression otherlv_13= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStatementAccess().getExpressionParserRuleCall_11_0());
                      			
                    }
                    pushFollow(FOLLOW_9);
                    this_Expression_12=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_12;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_13=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getStatementAccess().getSemicolonKeyword_11_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleIfElseStat"
    // InternalReflex.g:1228:1: entryRuleIfElseStat returns [EObject current=null] : iv_ruleIfElseStat= ruleIfElseStat EOF ;
    public final EObject entryRuleIfElseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfElseStat = null;


        try {
            // InternalReflex.g:1228:51: (iv_ruleIfElseStat= ruleIfElseStat EOF )
            // InternalReflex.g:1229:2: iv_ruleIfElseStat= ruleIfElseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfElseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfElseStat=ruleIfElseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfElseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfElseStat"


    // $ANTLR start "ruleIfElseStat"
    // InternalReflex.g:1235:1: ruleIfElseStat returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) ;
    public final EObject ruleIfElseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_cond_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1241:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) )
            // InternalReflex.g:1242:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            {
            // InternalReflex.g:1242:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            // InternalReflex.g:1243:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,60,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfElseStatAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,61,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfElseStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1251:3: ( (lv_cond_2_0= ruleExpression ) )
            // InternalReflex.g:1252:4: (lv_cond_2_0= ruleExpression )
            {
            // InternalReflex.g:1252:4: (lv_cond_2_0= ruleExpression )
            // InternalReflex.g:1253:5: lv_cond_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getCondExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_26);
            lv_cond_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,62,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfElseStatAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalReflex.g:1274:3: ( (lv_then_4_0= ruleStatement ) )
            // InternalReflex.g:1275:4: (lv_then_4_0= ruleStatement )
            {
            // InternalReflex.g:1275:4: (lv_then_4_0= ruleStatement )
            // InternalReflex.g:1276:5: lv_then_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getThenStatementParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_then_4_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"ru.iaie.reflex.Reflex.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1293:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==63) ) {
                int LA15_1 = input.LA(2);

                if ( (synpred1_InternalReflex()) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalReflex.g:1294:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) )
                    {
                    // InternalReflex.g:1294:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalReflex.g:1295:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,63,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfElseStatAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalReflex.g:1301:4: ( (lv_else_6_0= ruleStatement ) )
                    // InternalReflex.g:1302:5: (lv_else_6_0= ruleStatement )
                    {
                    // InternalReflex.g:1302:5: (lv_else_6_0= ruleStatement )
                    // InternalReflex.g:1303:6: lv_else_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfElseStatAccess().getElseStatementParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_6_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfElseStatRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_6_0,
                      							"ru.iaie.reflex.Reflex.Statement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfElseStat"


    // $ANTLR start "entryRuleSwitchStat"
    // InternalReflex.g:1325:1: entryRuleSwitchStat returns [EObject current=null] : iv_ruleSwitchStat= ruleSwitchStat EOF ;
    public final EObject entryRuleSwitchStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStat = null;


        try {
            // InternalReflex.g:1325:51: (iv_ruleSwitchStat= ruleSwitchStat EOF )
            // InternalReflex.g:1326:2: iv_ruleSwitchStat= ruleSwitchStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitchStat=ruleSwitchStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchStat"


    // $ANTLR start "ruleSwitchStat"
    // InternalReflex.g:1332:1: ruleSwitchStat returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) ;
    public final EObject ruleSwitchStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expr_2_0 = null;

        EObject lv_options_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1338:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) )
            // InternalReflex.g:1339:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:1339:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            // InternalReflex.g:1340:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,61,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1348:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalReflex.g:1349:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalReflex.g:1349:4: (lv_expr_2_0= ruleExpression )
            // InternalReflex.g:1350:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_26);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,62,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,46,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:1375:3: ( (lv_options_5_0= ruleCaseStat ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==65) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalReflex.g:1376:4: (lv_options_5_0= ruleCaseStat )
            	    {
            	    // InternalReflex.g:1376:4: (lv_options_5_0= ruleCaseStat )
            	    // InternalReflex.g:1377:5: lv_options_5_0= ruleCaseStat
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchStatAccess().getOptionsCaseStatParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_options_5_0=ruleCaseStat();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
            	      					}
            	      					add(
            	      						current,
            	      						"options",
            	      						lv_options_5_0,
            	      						"ru.iaie.reflex.Reflex.CaseStat");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_6=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSwitchStatAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchStat"


    // $ANTLR start "entryRuleCaseStat"
    // InternalReflex.g:1402:1: entryRuleCaseStat returns [EObject current=null] : iv_ruleCaseStat= ruleCaseStat EOF ;
    public final EObject entryRuleCaseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStat = null;


        try {
            // InternalReflex.g:1402:49: (iv_ruleCaseStat= ruleCaseStat EOF )
            // InternalReflex.g:1403:2: iv_ruleCaseStat= ruleCaseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCaseStat=ruleCaseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseStat"


    // $ANTLR start "ruleCaseStat"
    // InternalReflex.g:1409:1: ruleCaseStat returns [EObject current=null] : (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' ) ;
    public final EObject ruleCaseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_option_1_0 = null;

        EObject lv_body_3_0 = null;

        AntlrDatatypeRuleToken lv_hasBreak_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1415:2: ( (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' ) )
            // InternalReflex.g:1416:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' )
            {
            // InternalReflex.g:1416:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' )
            // InternalReflex.g:1417:3: otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCaseStatAccess().getCaseKeyword_0());
              		
            }
            // InternalReflex.g:1421:3: ( (lv_option_1_0= ruleInteger ) )
            // InternalReflex.g:1422:4: (lv_option_1_0= ruleInteger )
            {
            // InternalReflex.g:1422:4: (lv_option_1_0= ruleInteger )
            // InternalReflex.g:1423:5: lv_option_1_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getOptionIntegerParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_29);
            lv_option_1_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"option",
              						lv_option_1_0,
              						"ru.iaie.reflex.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,66,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCaseStatAccess().getColonKeyword_2());
              		
            }
            // InternalReflex.g:1444:3: ( (lv_body_3_0= ruleStatementSequence ) )
            // InternalReflex.g:1445:4: (lv_body_3_0= ruleStatementSequence )
            {
            // InternalReflex.g:1445:4: (lv_body_3_0= ruleStatementSequence )
            // InternalReflex.g:1446:5: lv_body_3_0= ruleStatementSequence
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getBodyStatementSequenceParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_body_3_0=ruleStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_3_0,
              						"ru.iaie.reflex.Reflex.StatementSequence");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1463:3: ( (lv_hasBreak_4_0= ruleBreakStat ) )
            // InternalReflex.g:1464:4: (lv_hasBreak_4_0= ruleBreakStat )
            {
            // InternalReflex.g:1464:4: (lv_hasBreak_4_0= ruleBreakStat )
            // InternalReflex.g:1465:5: lv_hasBreak_4_0= ruleBreakStat
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getHasBreakBreakStatParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_20);
            lv_hasBreak_4_0=ruleBreakStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"hasBreak",
              						true,
              						"ru.iaie.reflex.Reflex.BreakStat");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCaseStatAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseStat"


    // $ANTLR start "entryRuleBreakStat"
    // InternalReflex.g:1490:1: entryRuleBreakStat returns [String current=null] : iv_ruleBreakStat= ruleBreakStat EOF ;
    public final String entryRuleBreakStat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBreakStat = null;


        try {
            // InternalReflex.g:1490:49: (iv_ruleBreakStat= ruleBreakStat EOF )
            // InternalReflex.g:1491:2: iv_ruleBreakStat= ruleBreakStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBreakStat=ruleBreakStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreakStat.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBreakStat"


    // $ANTLR start "ruleBreakStat"
    // InternalReflex.g:1497:1: ruleBreakStat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'break' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleBreakStat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalReflex.g:1503:2: ( (kw= 'break' kw= ';' ) )
            // InternalReflex.g:1504:2: (kw= 'break' kw= ';' )
            {
            // InternalReflex.g:1504:2: (kw= 'break' kw= ';' )
            // InternalReflex.g:1505:3: kw= 'break' kw= ';'
            {
            kw=(Token)match(input,67,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getBreakStatAccess().getBreakKeyword_0());
              		
            }
            kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getBreakStatAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBreakStat"


    // $ANTLR start "entryRuleStartProcStat"
    // InternalReflex.g:1519:1: entryRuleStartProcStat returns [EObject current=null] : iv_ruleStartProcStat= ruleStartProcStat EOF ;
    public final EObject entryRuleStartProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcStat = null;


        try {
            // InternalReflex.g:1519:54: (iv_ruleStartProcStat= ruleStartProcStat EOF )
            // InternalReflex.g:1520:2: iv_ruleStartProcStat= ruleStartProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStartProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStartProcStat=ruleStartProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStartProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartProcStat"


    // $ANTLR start "ruleStartProcStat"
    // InternalReflex.g:1526:1: ruleStartProcStat returns [EObject current=null] : (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleStartProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_procId_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1532:2: ( (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalReflex.g:1533:2: (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalReflex.g:1533:2: (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalReflex.g:1534:3: otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStartProcStatAccess().getStartKeyword_0());
              		
            }
            // InternalReflex.g:1538:3: ( (lv_procId_1_0= RULE_ID ) )
            // InternalReflex.g:1539:4: (lv_procId_1_0= RULE_ID )
            {
            // InternalReflex.g:1539:4: (lv_procId_1_0= RULE_ID )
            // InternalReflex.g:1540:5: lv_procId_1_0= RULE_ID
            {
            lv_procId_1_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_procId_1_0, grammarAccess.getStartProcStatAccess().getProcIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStartProcStatRule());
              					}
              					setWithLastConsumed(
              						current,
              						"procId",
              						lv_procId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStartProcStatAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartProcStat"


    // $ANTLR start "entryRuleStopProcStat"
    // InternalReflex.g:1564:1: entryRuleStopProcStat returns [EObject current=null] : iv_ruleStopProcStat= ruleStopProcStat EOF ;
    public final EObject entryRuleStopProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcStat = null;


        try {
            // InternalReflex.g:1564:53: (iv_ruleStopProcStat= ruleStopProcStat EOF )
            // InternalReflex.g:1565:2: iv_ruleStopProcStat= ruleStopProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStopProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStopProcStat=ruleStopProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStopProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStopProcStat"


    // $ANTLR start "ruleStopProcStat"
    // InternalReflex.g:1571:1: ruleStopProcStat returns [EObject current=null] : ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) ;
    public final EObject ruleStopProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1577:2: ( ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) )
            // InternalReflex.g:1578:2: ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            {
            // InternalReflex.g:1578:2: ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            // InternalReflex.g:1579:3: () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';'
            {
            // InternalReflex.g:1579:3: ()
            // InternalReflex.g:1580:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStopProcStatAccess().getStopProcStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStopProcStatAccess().getStopKeyword_1());
              		
            }
            // InternalReflex.g:1590:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalReflex.g:1591:4: (lv_procId_2_0= RULE_ID )
                    {
                    // InternalReflex.g:1591:4: (lv_procId_2_0= RULE_ID )
                    // InternalReflex.g:1592:5: lv_procId_2_0= RULE_ID
                    {
                    lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_procId_2_0, grammarAccess.getStopProcStatAccess().getProcIdIDTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getStopProcStatRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"procId",
                      						lv_procId_2_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStopProcStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStopProcStat"


    // $ANTLR start "entryRuleErrorStat"
    // InternalReflex.g:1616:1: entryRuleErrorStat returns [EObject current=null] : iv_ruleErrorStat= ruleErrorStat EOF ;
    public final EObject entryRuleErrorStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorStat = null;


        try {
            // InternalReflex.g:1616:50: (iv_ruleErrorStat= ruleErrorStat EOF )
            // InternalReflex.g:1617:2: iv_ruleErrorStat= ruleErrorStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleErrorStat=ruleErrorStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorStat"


    // $ANTLR start "ruleErrorStat"
    // InternalReflex.g:1623:1: ruleErrorStat returns [EObject current=null] : ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) ;
    public final EObject ruleErrorStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1629:2: ( ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) )
            // InternalReflex.g:1630:2: ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            {
            // InternalReflex.g:1630:2: ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            // InternalReflex.g:1631:3: () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';'
            {
            // InternalReflex.g:1631:3: ()
            // InternalReflex.g:1632:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getErrorStatAccess().getErrorStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getErrorStatAccess().getErrorKeyword_1());
              		
            }
            // InternalReflex.g:1642:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalReflex.g:1643:4: (lv_procId_2_0= RULE_ID )
                    {
                    // InternalReflex.g:1643:4: (lv_procId_2_0= RULE_ID )
                    // InternalReflex.g:1644:5: lv_procId_2_0= RULE_ID
                    {
                    lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_procId_2_0, grammarAccess.getErrorStatAccess().getProcIdIDTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getErrorStatRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"procId",
                      						lv_procId_2_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getErrorStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErrorStat"


    // $ANTLR start "entryRuleLoopStat"
    // InternalReflex.g:1668:1: entryRuleLoopStat returns [EObject current=null] : iv_ruleLoopStat= ruleLoopStat EOF ;
    public final EObject entryRuleLoopStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopStat = null;


        try {
            // InternalReflex.g:1668:49: (iv_ruleLoopStat= ruleLoopStat EOF )
            // InternalReflex.g:1669:2: iv_ruleLoopStat= ruleLoopStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoopStat=ruleLoopStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopStat"


    // $ANTLR start "ruleLoopStat"
    // InternalReflex.g:1675:1: ruleLoopStat returns [EObject current=null] : ( () otherlv_1= 'loop' otherlv_2= ';' ) ;
    public final EObject ruleLoopStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1681:2: ( ( () otherlv_1= 'loop' otherlv_2= ';' ) )
            // InternalReflex.g:1682:2: ( () otherlv_1= 'loop' otherlv_2= ';' )
            {
            // InternalReflex.g:1682:2: ( () otherlv_1= 'loop' otherlv_2= ';' )
            // InternalReflex.g:1683:3: () otherlv_1= 'loop' otherlv_2= ';'
            {
            // InternalReflex.g:1683:3: ()
            // InternalReflex.g:1684:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLoopStatAccess().getLoopStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLoopStatAccess().getLoopKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLoopStatAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopStat"


    // $ANTLR start "entryRuleRestartStat"
    // InternalReflex.g:1702:1: entryRuleRestartStat returns [EObject current=null] : iv_ruleRestartStat= ruleRestartStat EOF ;
    public final EObject entryRuleRestartStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestartStat = null;


        try {
            // InternalReflex.g:1702:52: (iv_ruleRestartStat= ruleRestartStat EOF )
            // InternalReflex.g:1703:2: iv_ruleRestartStat= ruleRestartStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRestartStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRestartStat=ruleRestartStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRestartStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestartStat"


    // $ANTLR start "ruleRestartStat"
    // InternalReflex.g:1709:1: ruleRestartStat returns [EObject current=null] : ( () otherlv_1= 'restart' otherlv_2= ';' ) ;
    public final EObject ruleRestartStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1715:2: ( ( () otherlv_1= 'restart' otherlv_2= ';' ) )
            // InternalReflex.g:1716:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            {
            // InternalReflex.g:1716:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            // InternalReflex.g:1717:3: () otherlv_1= 'restart' otherlv_2= ';'
            {
            // InternalReflex.g:1717:3: ()
            // InternalReflex.g:1718:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRestartStatAccess().getRestartStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,72,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRestartStatAccess().getRestartKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRestartStatAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestartStat"


    // $ANTLR start "entryRuleResetStat"
    // InternalReflex.g:1736:1: entryRuleResetStat returns [EObject current=null] : iv_ruleResetStat= ruleResetStat EOF ;
    public final EObject entryRuleResetStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetStat = null;


        try {
            // InternalReflex.g:1736:50: (iv_ruleResetStat= ruleResetStat EOF )
            // InternalReflex.g:1737:2: iv_ruleResetStat= ruleResetStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResetStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleResetStat=ruleResetStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResetStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResetStat"


    // $ANTLR start "ruleResetStat"
    // InternalReflex.g:1743:1: ruleResetStat returns [EObject current=null] : ( () otherlv_1= 'reset' otherlv_2= 'timeout' otherlv_3= ';' ) ;
    public final EObject ruleResetStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1749:2: ( ( () otherlv_1= 'reset' otherlv_2= 'timeout' otherlv_3= ';' ) )
            // InternalReflex.g:1750:2: ( () otherlv_1= 'reset' otherlv_2= 'timeout' otherlv_3= ';' )
            {
            // InternalReflex.g:1750:2: ( () otherlv_1= 'reset' otherlv_2= 'timeout' otherlv_3= ';' )
            // InternalReflex.g:1751:3: () otherlv_1= 'reset' otherlv_2= 'timeout' otherlv_3= ';'
            {
            // InternalReflex.g:1751:3: ()
            // InternalReflex.g:1752:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getResetStatAccess().getResetStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,73,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getResetStatAccess().getResetKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,59,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getResetStatAccess().getTimeoutKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getResetStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResetStat"


    // $ANTLR start "entryRuleSetStateStat"
    // InternalReflex.g:1774:1: entryRuleSetStateStat returns [EObject current=null] : iv_ruleSetStateStat= ruleSetStateStat EOF ;
    public final EObject entryRuleSetStateStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStat = null;


        try {
            // InternalReflex.g:1774:53: (iv_ruleSetStateStat= ruleSetStateStat EOF )
            // InternalReflex.g:1775:2: iv_ruleSetStateStat= ruleSetStateStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetStateStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetStateStat=ruleSetStateStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetStateStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetStateStat"


    // $ANTLR start "ruleSetStateStat"
    // InternalReflex.g:1781:1: ruleSetStateStat returns [EObject current=null] : ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' ) ;
    public final EObject ruleSetStateStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_stateId_3_0=null;
        Token lv_next_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalReflex.g:1787:2: ( ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1788:2: ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1788:2: ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' )
            // InternalReflex.g:1789:3: () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';'
            {
            // InternalReflex.g:1789:3: ()
            // InternalReflex.g:1790:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetStateStatAccess().getSetStateStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,74,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetStateStatAccess().getSetKeyword_1());
              		
            }
            // InternalReflex.g:1800:3: ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==58) ) {
                alt19=1;
            }
            else if ( (LA19_0==75) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalReflex.g:1801:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    {
                    // InternalReflex.g:1801:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    // InternalReflex.g:1802:5: otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,58,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getSetStateStatAccess().getStateKeyword_2_0_0());
                      				
                    }
                    // InternalReflex.g:1806:5: ( (lv_stateId_3_0= RULE_ID ) )
                    // InternalReflex.g:1807:6: (lv_stateId_3_0= RULE_ID )
                    {
                    // InternalReflex.g:1807:6: (lv_stateId_3_0= RULE_ID )
                    // InternalReflex.g:1808:7: lv_stateId_3_0= RULE_ID
                    {
                    lv_stateId_3_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_stateId_3_0, grammarAccess.getSetStateStatAccess().getStateIdIDTerminalRuleCall_2_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getSetStateStatRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"stateId",
                      								lv_stateId_3_0,
                      								"org.eclipse.xtext.common.Terminals.ID");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1826:4: ( (lv_next_4_0= 'next' ) )
                    {
                    // InternalReflex.g:1826:4: ( (lv_next_4_0= 'next' ) )
                    // InternalReflex.g:1827:5: (lv_next_4_0= 'next' )
                    {
                    // InternalReflex.g:1827:5: (lv_next_4_0= 'next' )
                    // InternalReflex.g:1828:6: lv_next_4_0= 'next'
                    {
                    lv_next_4_0=(Token)match(input,75,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_next_4_0, grammarAccess.getSetStateStatAccess().getNextNextKeyword_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSetStateStatRule());
                      						}
                      						setWithLastConsumed(current, "next", true, "next");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getSetStateStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetStateStat"


    // $ANTLR start "entryRuleFunction"
    // InternalReflex.g:1849:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalReflex.g:1849:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalReflex.g:1850:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalReflex.g:1856:1: ruleFunction returns [EObject current=null] : ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_returnType_0_0 = null;

        EObject lv_argTypes_3_0 = null;

        EObject lv_argTypes_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1862:2: ( ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' ) )
            // InternalReflex.g:1863:2: ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            {
            // InternalReflex.g:1863:2: ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            // InternalReflex.g:1864:3: ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';'
            {
            // InternalReflex.g:1864:3: ( (lv_returnType_0_0= ruleCType ) )
            // InternalReflex.g:1865:4: (lv_returnType_0_0= ruleCType )
            {
            // InternalReflex.g:1865:4: (lv_returnType_0_0= ruleCType )
            // InternalReflex.g:1866:5: lv_returnType_0_0= ruleCType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeCTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_returnType_0_0=ruleCType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					set(
              						current,
              						"returnType",
              						lv_returnType_0_0,
              						"ru.iaie.reflex.Reflex.CType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1883:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1884:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1884:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1885:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,61,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalReflex.g:1905:3: ( (lv_argTypes_3_0= ruleCType ) )
            // InternalReflex.g:1906:4: (lv_argTypes_3_0= ruleCType )
            {
            // InternalReflex.g:1906:4: (lv_argTypes_3_0= ruleCType )
            // InternalReflex.g:1907:5: lv_argTypes_3_0= ruleCType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesCTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_35);
            lv_argTypes_3_0=ruleCType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					add(
              						current,
              						"argTypes",
              						lv_argTypes_3_0,
              						"ru.iaie.reflex.Reflex.CType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1924:3: (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==51) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalReflex.g:1925:4: otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) )
            	    {
            	    otherlv_4=(Token)match(input,51,FOLLOW_34); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:1929:4: ( (lv_argTypes_5_0= ruleCType ) )
            	    // InternalReflex.g:1930:5: (lv_argTypes_5_0= ruleCType )
            	    {
            	    // InternalReflex.g:1930:5: (lv_argTypes_5_0= ruleCType )
            	    // InternalReflex.g:1931:6: lv_argTypes_5_0= ruleCType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesCTypeParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_argTypes_5_0=ruleCType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"argTypes",
            	      							lv_argTypes_5_0,
            	      							"ru.iaie.reflex.Reflex.CType");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_6=(Token)match(input,62,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_7=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionAccess().getSemicolonKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleRegister"
    // InternalReflex.g:1961:1: entryRuleRegister returns [EObject current=null] : iv_ruleRegister= ruleRegister EOF ;
    public final EObject entryRuleRegister() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegister = null;


        try {
            // InternalReflex.g:1961:49: (iv_ruleRegister= ruleRegister EOF )
            // InternalReflex.g:1962:2: iv_ruleRegister= ruleRegister EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegister=ruleRegister();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegister; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegister"


    // $ANTLR start "ruleRegister"
    // InternalReflex.g:1968:1: ruleRegister returns [EObject current=null] : ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';' ) ;
    public final EObject ruleRegister() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_5=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_addr1_2_0 = null;

        EObject lv_addr2_3_0 = null;

        EObject lv_regSize_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1974:2: ( ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1975:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1975:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';' )
            // InternalReflex.g:1976:3: ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';'
            {
            // InternalReflex.g:1976:3: ( (lv_type_0_0= ruleRegisterType ) )
            // InternalReflex.g:1977:4: (lv_type_0_0= ruleRegisterType )
            {
            // InternalReflex.g:1977:4: (lv_type_0_0= ruleRegisterType )
            // InternalReflex.g:1978:5: lv_type_0_0= ruleRegisterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getTypeRegisterTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleRegisterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.RegisterType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1995:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1996:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1996:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1997:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRegisterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:2013:3: ( (lv_addr1_2_0= ruleInteger ) )
            // InternalReflex.g:2014:4: (lv_addr1_2_0= ruleInteger )
            {
            // InternalReflex.g:2014:4: (lv_addr1_2_0= ruleInteger )
            // InternalReflex.g:2015:5: lv_addr1_2_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getAddr1IntegerParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_addr1_2_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"addr1",
              						lv_addr1_2_0,
              						"ru.iaie.reflex.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2032:3: ( (lv_addr2_3_0= ruleInteger ) )
            // InternalReflex.g:2033:4: (lv_addr2_3_0= ruleInteger )
            {
            // InternalReflex.g:2033:4: (lv_addr2_3_0= ruleInteger )
            // InternalReflex.g:2034:5: lv_addr2_3_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getAddr2IntegerParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_addr2_3_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"addr2",
              						lv_addr2_3_0,
              						"ru.iaie.reflex.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2051:3: ( (lv_regSize_4_0= ruleInteger ) )
            // InternalReflex.g:2052:4: (lv_regSize_4_0= ruleInteger )
            {
            // InternalReflex.g:2052:4: (lv_regSize_4_0= ruleInteger )
            // InternalReflex.g:2053:5: lv_regSize_4_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getRegSizeIntegerParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_regSize_4_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"regSize",
              						lv_regSize_4_0,
              						"ru.iaie.reflex.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRegisterAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegister"


    // $ANTLR start "entryRuleConst"
    // InternalReflex.g:2078:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalReflex.g:2078:46: (iv_ruleConst= ruleConst EOF )
            // InternalReflex.g:2079:2: iv_ruleConst= ruleConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConst=ruleConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConst; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConst"


    // $ANTLR start "ruleConst"
    // InternalReflex.g:2085:1: ruleConst returns [EObject current=null] : (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constId_1_0=null;
        Token otherlv_3=null;
        EObject lv_constValue_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2091:2: ( (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // InternalReflex.g:2092:2: (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:2092:2: (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' )
            // InternalReflex.g:2093:3: otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstAccess().getConstKeyword_0());
              		
            }
            // InternalReflex.g:2097:3: ( (lv_constId_1_0= RULE_ID ) )
            // InternalReflex.g:2098:4: (lv_constId_1_0= RULE_ID )
            {
            // InternalReflex.g:2098:4: (lv_constId_1_0= RULE_ID )
            // InternalReflex.g:2099:5: lv_constId_1_0= RULE_ID
            {
            lv_constId_1_0=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_constId_1_0, grammarAccess.getConstAccess().getConstIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstRule());
              					}
              					setWithLastConsumed(
              						current,
              						"constId",
              						lv_constId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:2115:3: ( (lv_constValue_2_0= ruleExpression ) )
            // InternalReflex.g:2116:4: (lv_constValue_2_0= ruleExpression )
            {
            // InternalReflex.g:2116:4: (lv_constValue_2_0= ruleExpression )
            // InternalReflex.g:2117:5: lv_constValue_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getConstValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_constValue_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"constValue",
              						lv_constValue_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConst"


    // $ANTLR start "entryRuleEnum"
    // InternalReflex.g:2142:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // InternalReflex.g:2142:45: (iv_ruleEnum= ruleEnum EOF )
            // InternalReflex.g:2143:2: iv_ruleEnum= ruleEnum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnum=ruleEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnum; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnum"


    // $ANTLR start "ruleEnum"
    // InternalReflex.g:2149:1: ruleEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_enumId_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_enumMembers_3_0 = null;

        EObject lv_enumMembers_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2155:2: ( (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) )
            // InternalReflex.g:2156:2: (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:2156:2: (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            // InternalReflex.g:2157:3: otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalReflex.g:2161:3: ( (lv_enumId_1_0= RULE_ID ) )
            // InternalReflex.g:2162:4: (lv_enumId_1_0= RULE_ID )
            {
            // InternalReflex.g:2162:4: (lv_enumId_1_0= RULE_ID )
            // InternalReflex.g:2163:5: lv_enumId_1_0= RULE_ID
            {
            lv_enumId_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_enumId_1_0, grammarAccess.getEnumAccess().getEnumIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumRule());
              					}
              					setWithLastConsumed(
              						current,
              						"enumId",
              						lv_enumId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:2183:3: ( (lv_enumMembers_3_0= ruleEnumMember ) )
            // InternalReflex.g:2184:4: (lv_enumMembers_3_0= ruleEnumMember )
            {
            // InternalReflex.g:2184:4: (lv_enumMembers_3_0= ruleEnumMember )
            // InternalReflex.g:2185:5: lv_enumMembers_3_0= ruleEnumMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_enumMembers_3_0=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumRule());
              					}
              					add(
              						current,
              						"enumMembers",
              						lv_enumMembers_3_0,
              						"ru.iaie.reflex.Reflex.EnumMember");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2202:3: (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==51) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalReflex.g:2203:4: otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    {
            	    otherlv_4=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getEnumAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:2207:4: ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    // InternalReflex.g:2208:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    {
            	    // InternalReflex.g:2208:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    // InternalReflex.g:2209:6: lv_enumMembers_5_0= ruleEnumMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_enumMembers_5_0=ruleEnumMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEnumRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enumMembers",
            	      							lv_enumMembers_5_0,
            	      							"ru.iaie.reflex.Reflex.EnumMember");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEnumAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnum"


    // $ANTLR start "entryRuleEnumMember"
    // InternalReflex.g:2235:1: entryRuleEnumMember returns [EObject current=null] : iv_ruleEnumMember= ruleEnumMember EOF ;
    public final EObject entryRuleEnumMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumMember = null;


        try {
            // InternalReflex.g:2235:51: (iv_ruleEnumMember= ruleEnumMember EOF )
            // InternalReflex.g:2236:2: iv_ruleEnumMember= ruleEnumMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumMemberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumMember=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumMember; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumMember"


    // $ANTLR start "ruleEnumMember"
    // InternalReflex.g:2242:1: ruleEnumMember returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleEnumMember() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2248:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalReflex.g:2249:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalReflex.g:2249:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            // InternalReflex.g:2250:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalReflex.g:2250:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalReflex.g:2251:4: (lv_name_0_0= RULE_ID )
            {
            // InternalReflex.g:2251:4: (lv_name_0_0= RULE_ID )
            // InternalReflex.g:2252:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getEnumMemberAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumMemberRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,52,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEnumMemberAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalReflex.g:2272:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalReflex.g:2273:4: (lv_value_2_0= ruleExpression )
            {
            // InternalReflex.g:2273:4: (lv_value_2_0= ruleExpression )
            // InternalReflex.g:2274:5: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumMemberAccess().getValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumMemberRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumMember"


    // $ANTLR start "entryRuleInfixOp"
    // InternalReflex.g:2295:1: entryRuleInfixOp returns [EObject current=null] : iv_ruleInfixOp= ruleInfixOp EOF ;
    public final EObject entryRuleInfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOp = null;


        try {
            // InternalReflex.g:2295:48: (iv_ruleInfixOp= ruleInfixOp EOF )
            // InternalReflex.g:2296:2: iv_ruleInfixOp= ruleInfixOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInfixOp=ruleInfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixOp"


    // $ANTLR start "ruleInfixOp"
    // InternalReflex.g:2302:1: ruleInfixOp returns [EObject current=null] : ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_1_0=null;
        Enumerator lv_op_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2308:2: ( ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:2309:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:2309:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            // InternalReflex.g:2310:3: ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) )
            {
            // InternalReflex.g:2310:3: ( (lv_op_0_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2311:4: (lv_op_0_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2311:4: (lv_op_0_0= ruleInfixPostfixOp )
            // InternalReflex.g:2312:5: lv_op_0_0= ruleInfixPostfixOp
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInfixOpAccess().getOpInfixPostfixOpEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_op_0_0=ruleInfixPostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInfixOpRule());
              					}
              					set(
              						current,
              						"op",
              						lv_op_0_0,
              						"ru.iaie.reflex.Reflex.InfixPostfixOp");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2329:3: ( (lv_varId_1_0= RULE_ID ) )
            // InternalReflex.g:2330:4: (lv_varId_1_0= RULE_ID )
            {
            // InternalReflex.g:2330:4: (lv_varId_1_0= RULE_ID )
            // InternalReflex.g:2331:5: lv_varId_1_0= RULE_ID
            {
            lv_varId_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_varId_1_0, grammarAccess.getInfixOpAccess().getVarIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInfixOpRule());
              					}
              					setWithLastConsumed(
              						current,
              						"varId",
              						lv_varId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixOp"


    // $ANTLR start "entryRulePostfixOp"
    // InternalReflex.g:2351:1: entryRulePostfixOp returns [EObject current=null] : iv_rulePostfixOp= rulePostfixOp EOF ;
    public final EObject entryRulePostfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOp = null;


        try {
            // InternalReflex.g:2351:50: (iv_rulePostfixOp= rulePostfixOp EOF )
            // InternalReflex.g:2352:2: iv_rulePostfixOp= rulePostfixOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixOp=rulePostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixOp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostfixOp"


    // $ANTLR start "rulePostfixOp"
    // InternalReflex.g:2358:1: rulePostfixOp returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) ;
    public final EObject rulePostfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Enumerator lv_op_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2364:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) )
            // InternalReflex.g:2365:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            {
            // InternalReflex.g:2365:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            // InternalReflex.g:2366:3: ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) )
            {
            // InternalReflex.g:2366:3: ( (lv_varId_0_0= RULE_ID ) )
            // InternalReflex.g:2367:4: (lv_varId_0_0= RULE_ID )
            {
            // InternalReflex.g:2367:4: (lv_varId_0_0= RULE_ID )
            // InternalReflex.g:2368:5: lv_varId_0_0= RULE_ID
            {
            lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_varId_0_0, grammarAccess.getPostfixOpAccess().getVarIdIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPostfixOpRule());
              					}
              					setWithLastConsumed(
              						current,
              						"varId",
              						lv_varId_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:2384:3: ( (lv_op_1_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2385:4: (lv_op_1_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2385:4: (lv_op_1_0= ruleInfixPostfixOp )
            // InternalReflex.g:2386:5: lv_op_1_0= ruleInfixPostfixOp
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPostfixOpAccess().getOpInfixPostfixOpEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_op_1_0=ruleInfixPostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPostfixOpRule());
              					}
              					set(
              						current,
              						"op",
              						lv_op_1_0,
              						"ru.iaie.reflex.Reflex.InfixPostfixOp");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostfixOp"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalReflex.g:2407:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalReflex.g:2407:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalReflex.g:2408:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalReflex.g:2414:1: ruleFunctionCall returns [EObject current=null] : ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_funcId_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2420:2: ( ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalReflex.g:2421:2: ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalReflex.g:2421:2: ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            // InternalReflex.g:2422:3: ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalReflex.g:2422:3: ( (lv_funcId_0_0= RULE_ID ) )
            // InternalReflex.g:2423:4: (lv_funcId_0_0= RULE_ID )
            {
            // InternalReflex.g:2423:4: (lv_funcId_0_0= RULE_ID )
            // InternalReflex.g:2424:5: lv_funcId_0_0= RULE_ID
            {
            lv_funcId_0_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_funcId_0_0, grammarAccess.getFunctionCallAccess().getFuncIdIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionCallRule());
              					}
              					setWithLastConsumed(
              						current,
              						"funcId",
              						lv_funcId_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,61,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:2444:3: ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID||(LA23_0>=RULE_HEX && LA23_0<=RULE_DECIMAL)||(LA23_0>=RULE_DEC_FLOAT && LA23_0<=RULE_HEX_FLOAT)||LA23_0==61||(LA23_0>=82 && LA23_0<=83)||(LA23_0>=93 && LA23_0<=96)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalReflex.g:2445:4: ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    {
                    // InternalReflex.g:2445:4: ( (lv_args_2_0= ruleExpression ) )
                    // InternalReflex.g:2446:5: (lv_args_2_0= ruleExpression )
                    {
                    // InternalReflex.g:2446:5: (lv_args_2_0= ruleExpression )
                    // InternalReflex.g:2447:6: lv_args_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_35);
                    lv_args_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                      						}
                      						add(
                      							current,
                      							"args",
                      							lv_args_2_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalReflex.g:2464:4: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==51) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalReflex.g:2465:5: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,51,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalReflex.g:2469:5: ( (lv_args_4_0= ruleExpression ) )
                    	    // InternalReflex.g:2470:6: (lv_args_4_0= ruleExpression )
                    	    {
                    	    // InternalReflex.g:2470:6: (lv_args_4_0= ruleExpression )
                    	    // InternalReflex.g:2471:7: lv_args_4_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_35);
                    	    lv_args_4_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"args",
                    	      								lv_args_4_0,
                    	      								"ru.iaie.reflex.Reflex.Expression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalReflex.g:2498:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalReflex.g:2498:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalReflex.g:2499:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalReflex.g:2505:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) | this_Integer_1= ruleInteger | ( () ruleFloat ) | (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_Integer_1 = null;

        EObject lv_expr_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2511:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) | this_Integer_1= ruleInteger | ( () ruleFloat ) | (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) )
            // InternalReflex.g:2512:2: ( ( (lv_varId_0_0= RULE_ID ) ) | this_Integer_1= ruleInteger | ( () ruleFloat ) | (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            {
            // InternalReflex.g:2512:2: ( ( (lv_varId_0_0= RULE_ID ) ) | this_Integer_1= ruleInteger | ( () ruleFloat ) | (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt24=1;
                }
                break;
            case RULE_HEX:
            case RULE_OCTAL:
            case RULE_DECIMAL:
                {
                alt24=2;
                }
                break;
            case RULE_DEC_FLOAT:
            case RULE_HEX_FLOAT:
                {
                alt24=3;
                }
                break;
            case 61:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalReflex.g:2513:3: ( (lv_varId_0_0= RULE_ID ) )
                    {
                    // InternalReflex.g:2513:3: ( (lv_varId_0_0= RULE_ID ) )
                    // InternalReflex.g:2514:4: (lv_varId_0_0= RULE_ID )
                    {
                    // InternalReflex.g:2514:4: (lv_varId_0_0= RULE_ID )
                    // InternalReflex.g:2515:5: lv_varId_0_0= RULE_ID
                    {
                    lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_varId_0_0, grammarAccess.getPrimaryExpressionAccess().getVarIdIDTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"varId",
                      						lv_varId_0_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2532:3: this_Integer_1= ruleInteger
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIntegerParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Integer_1=ruleInteger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Integer_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:2541:3: ( () ruleFloat )
                    {
                    // InternalReflex.g:2541:3: ( () ruleFloat )
                    // InternalReflex.g:2542:4: () ruleFloat
                    {
                    // InternalReflex.g:2542:4: ()
                    // InternalReflex.g:2543:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_2_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFloatParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    ruleFloat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:2558:3: (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalReflex.g:2558:3: (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalReflex.g:2559:4: otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,61,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalReflex.g:2563:4: ( (lv_expr_5_0= ruleExpression ) )
                    // InternalReflex.g:2564:5: (lv_expr_5_0= ruleExpression )
                    {
                    // InternalReflex.g:2564:5: (lv_expr_5_0= ruleExpression )
                    // InternalReflex.g:2565:6: lv_expr_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExprExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_expr_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_5_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalReflex.g:2591:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalReflex.g:2591:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalReflex.g:2592:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalReflex.g:2598:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject this_FunctionCall_1 = null;

        EObject this_PostfixOp_2 = null;

        EObject this_InfixOp_3 = null;

        Enumerator lv_unaryOp_4_0 = null;

        EObject lv_rest_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2604:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2605:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2605:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) )
            int alt25=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 82:
                case 83:
                    {
                    alt25=3;
                    }
                    break;
                case EOF:
                case RULE_BIT_AND:
                case RULE_BIT_XOR:
                case RULE_BIT_OR:
                case RULE_LOGICAL_AND:
                case RULE_LOGICAL_OR:
                case 47:
                case 49:
                case 51:
                case 62:
                case 93:
                case 94:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                    {
                    alt25=1;
                    }
                    break;
                case 61:
                    {
                    alt25=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_HEX:
            case RULE_OCTAL:
            case RULE_DECIMAL:
            case RULE_DEC_FLOAT:
            case RULE_HEX_FLOAT:
            case 61:
                {
                alt25=1;
                }
                break;
            case 82:
            case 83:
                {
                alt25=4;
                }
                break;
            case 93:
            case 94:
            case 95:
            case 96:
                {
                alt25=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalReflex.g:2606:3: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrimaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2615:3: this_FunctionCall_1= ruleFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getFunctionCallParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionCall_1=ruleFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionCall_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:2624:3: this_PostfixOp_2= rulePostfixOp
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixOpParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostfixOp_2=rulePostfixOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostfixOp_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:2633:3: this_InfixOp_3= ruleInfixOp
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getInfixOpParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InfixOp_3=ruleInfixOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InfixOp_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalReflex.g:2642:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2642:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2643:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) )
                    {
                    // InternalReflex.g:2643:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) )
                    // InternalReflex.g:2644:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    {
                    // InternalReflex.g:2644:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    // InternalReflex.g:2645:6: lv_unaryOp_4_0= ruleUnaryOp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryOpUnaryOpEnumRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_38);
                    lv_unaryOp_4_0=ruleUnaryOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"unaryOp",
                      							lv_unaryOp_4_0,
                      							"ru.iaie.reflex.Reflex.UnaryOp");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalReflex.g:2662:4: ( (lv_rest_5_0= ruleCastExpression ) )
                    // InternalReflex.g:2663:5: (lv_rest_5_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2663:5: (lv_rest_5_0= ruleCastExpression )
                    // InternalReflex.g:2664:6: lv_rest_5_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getRestCastExpressionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_rest_5_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"rest",
                      							lv_rest_5_0,
                      							"ru.iaie.reflex.Reflex.CastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleCastExpression"
    // InternalReflex.g:2686:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalReflex.g:2686:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalReflex.g:2687:2: iv_ruleCastExpression= ruleCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCastExpression=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCastExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCastExpression"


    // $ANTLR start "ruleCastExpression"
    // InternalReflex.g:2693:1: ruleCastExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2699:2: ( (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2700:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2700:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||(LA26_0>=RULE_HEX && LA26_0<=RULE_DECIMAL)||(LA26_0>=RULE_DEC_FLOAT && LA26_0<=RULE_HEX_FLOAT)||(LA26_0>=82 && LA26_0<=83)||(LA26_0>=93 && LA26_0<=96)) ) {
                alt26=1;
            }
            else if ( (LA26_0==61) ) {
                int LA26_2 = input.LA(2);

                if ( (LA26_2==RULE_ID||(LA26_2>=RULE_HEX && LA26_2<=RULE_DECIMAL)||(LA26_2>=RULE_DEC_FLOAT && LA26_2<=RULE_HEX_FLOAT)||LA26_2==61||(LA26_2>=82 && LA26_2<=83)||(LA26_2>=93 && LA26_2<=96)) ) {
                    alt26=1;
                }
                else if ( ((LA26_2>=RULE_VOID_C_TYPE && LA26_2<=RULE_BOOL_TYPE)||(LA26_2>=108 && LA26_2<=109)) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalReflex.g:2701:3: this_UnaryExpression_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCastExpressionAccess().getUnaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpression_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2710:3: (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2710:3: (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2711:4: otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,61,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:2715:4: ( (lv_type_2_0= ruleReflexType ) )
                    // InternalReflex.g:2716:5: (lv_type_2_0= ruleReflexType )
                    {
                    // InternalReflex.g:2716:5: (lv_type_2_0= ruleReflexType )
                    // InternalReflex.g:2717:6: lv_type_2_0= ruleReflexType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeReflexTypeParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_type_2_0=ruleReflexType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_2_0,
                      							"ru.iaie.reflex.Reflex.ReflexType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,62,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalReflex.g:2738:4: ( (lv_right_4_0= ruleCastExpression ) )
                    // InternalReflex.g:2739:5: (lv_right_4_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2739:5: (lv_right_4_0= ruleCastExpression )
                    // InternalReflex.g:2740:6: lv_right_4_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getRightCastExpressionParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_4_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_4_0,
                      							"ru.iaie.reflex.Reflex.CastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCastExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalReflex.g:2762:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalReflex.g:2762:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalReflex.g:2763:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalReflex.g:2769:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CastExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2775:2: ( (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) )
            // InternalReflex.g:2776:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            {
            // InternalReflex.g:2776:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            // InternalReflex.g:2777:3: this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_40);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2785:3: ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=105 && LA27_0<=107)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalReflex.g:2786:4: () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) )
            	    {
            	    // InternalReflex.g:2786:4: ()
            	    // InternalReflex.g:2787:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2793:4: ( (lv_mulOp_2_0= ruleMultiplicativeOp ) )
            	    // InternalReflex.g:2794:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    {
            	    // InternalReflex.g:2794:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    // InternalReflex.g:2795:6: lv_mulOp_2_0= ruleMultiplicativeOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getMulOpMultiplicativeOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_mulOp_2_0=ruleMultiplicativeOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"mulOp",
            	      							lv_mulOp_2_0,
            	      							"ru.iaie.reflex.Reflex.MultiplicativeOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:2812:4: ( (lv_right_3_0= ruleCastExpression ) )
            	    // InternalReflex.g:2813:5: (lv_right_3_0= ruleCastExpression )
            	    {
            	    // InternalReflex.g:2813:5: (lv_right_3_0= ruleCastExpression )
            	    // InternalReflex.g:2814:6: lv_right_3_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightCastExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_right_3_0=ruleCastExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.CastExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalReflex.g:2836:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalReflex.g:2836:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalReflex.g:2837:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalReflex.g:2843:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_rightt_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2849:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalReflex.g:2850:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalReflex.g:2850:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* )
            // InternalReflex.g:2851:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_41);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2859:3: ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==93) ) {
                    alt28=1;
                }
                else if ( (LA28_0==94) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalReflex.g:2860:4: () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalReflex.g:2860:4: ()
            	    // InternalReflex.g:2861:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2867:4: ( (lv_addOp_2_0= ruleAdditiveOp ) )
            	    // InternalReflex.g:2868:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    {
            	    // InternalReflex.g:2868:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    // InternalReflex.g:2869:6: lv_addOp_2_0= ruleAdditiveOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getAddOpAdditiveOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_addOp_2_0=ruleAdditiveOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"addOp",
            	      							lv_addOp_2_0,
            	      							"ru.iaie.reflex.Reflex.AdditiveOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:2886:4: ( (lv_rightt_3_0= ruleAdditiveExpression ) )
            	    // InternalReflex.g:2887:5: (lv_rightt_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalReflex.g:2887:5: (lv_rightt_3_0= ruleAdditiveExpression )
            	    // InternalReflex.g:2888:6: lv_rightt_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRighttAdditiveExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
            	    lv_rightt_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightt",
            	      							lv_rightt_3_0,
            	      							"ru.iaie.reflex.Reflex.AdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalReflex.g:2910:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalReflex.g:2910:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalReflex.g:2911:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // InternalReflex.g:2917:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        Enumerator lv_shiftOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2923:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) )
            // InternalReflex.g:2924:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            {
            // InternalReflex.g:2924:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            // InternalReflex.g:2925:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_42);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2933:3: ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==103) ) {
                    alt29=1;
                }
                else if ( (LA29_0==104) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalReflex.g:2934:4: () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalReflex.g:2934:4: ()
            	    // InternalReflex.g:2935:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2941:4: ( (lv_shiftOp_2_0= ruleShiftOp ) )
            	    // InternalReflex.g:2942:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    {
            	    // InternalReflex.g:2942:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    // InternalReflex.g:2943:6: lv_shiftOp_2_0= ruleShiftOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getShiftOpShiftOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_shiftOp_2_0=ruleShiftOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"shiftOp",
            	      							lv_shiftOp_2_0,
            	      							"ru.iaie.reflex.Reflex.ShiftOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:2960:4: ( (lv_right_3_0= ruleShiftExpression ) )
            	    // InternalReflex.g:2961:5: (lv_right_3_0= ruleShiftExpression )
            	    {
            	    // InternalReflex.g:2961:5: (lv_right_3_0= ruleShiftExpression )
            	    // InternalReflex.g:2962:6: lv_right_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightShiftExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_right_3_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.ShiftExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleCompareExpression"
    // InternalReflex.g:2984:1: entryRuleCompareExpression returns [EObject current=null] : iv_ruleCompareExpression= ruleCompareExpression EOF ;
    public final EObject entryRuleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpression = null;


        try {
            // InternalReflex.g:2984:58: (iv_ruleCompareExpression= ruleCompareExpression EOF )
            // InternalReflex.g:2985:2: iv_ruleCompareExpression= ruleCompareExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompareExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompareExpression=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompareExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompareExpression"


    // $ANTLR start "ruleCompareExpression"
    // InternalReflex.g:2991:1: ruleCompareExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* ) ;
    public final EObject ruleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_cmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2997:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* ) )
            // InternalReflex.g:2998:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* )
            {
            // InternalReflex.g:2998:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* )
            // InternalReflex.g:2999:3: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCompareExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_43);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3007:3: ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                switch ( input.LA(1) ) {
                case 97:
                    {
                    alt30=1;
                    }
                    break;
                case 98:
                    {
                    alt30=1;
                    }
                    break;
                case 99:
                    {
                    alt30=1;
                    }
                    break;
                case 100:
                    {
                    alt30=1;
                    }
                    break;

                }

                switch (alt30) {
            	case 1 :
            	    // InternalReflex.g:3008:4: () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) )
            	    {
            	    // InternalReflex.g:3008:4: ()
            	    // InternalReflex.g:3009:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getCompareExpressionAccess().getCompareExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3015:4: ( (lv_cmpOp_2_0= ruleCompareOp ) )
            	    // InternalReflex.g:3016:5: (lv_cmpOp_2_0= ruleCompareOp )
            	    {
            	    // InternalReflex.g:3016:5: (lv_cmpOp_2_0= ruleCompareOp )
            	    // InternalReflex.g:3017:6: lv_cmpOp_2_0= ruleCompareOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCompareExpressionAccess().getCmpOpCompareOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_cmpOp_2_0=ruleCompareOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getCompareExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"cmpOp",
            	      							lv_cmpOp_2_0,
            	      							"ru.iaie.reflex.Reflex.CompareOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3034:4: ( (lv_right_3_0= ruleCompareExpression ) )
            	    // InternalReflex.g:3035:5: (lv_right_3_0= ruleCompareExpression )
            	    {
            	    // InternalReflex.g:3035:5: (lv_right_3_0= ruleCompareExpression )
            	    // InternalReflex.g:3036:6: lv_right_3_0= ruleCompareExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCompareExpressionAccess().getRightCompareExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_right_3_0=ruleCompareExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getCompareExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.CompareExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalReflex.g:3058:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalReflex.g:3058:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalReflex.g:3059:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalReflex.g:3065:1: ruleEqualityExpression returns [EObject current=null] : (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpression_0 = null;

        Enumerator lv_eqCmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3071:2: ( (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalReflex.g:3072:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalReflex.g:3072:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalReflex.g:3073:3: this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getCompareExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_44);
            this_CompareExpression_0=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CompareExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3081:3: ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==101) ) {
                    alt31=1;
                }
                else if ( (LA31_0==102) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalReflex.g:3082:4: () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalReflex.g:3082:4: ()
            	    // InternalReflex.g:3083:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3089:4: ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) )
            	    // InternalReflex.g:3090:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    {
            	    // InternalReflex.g:3090:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    // InternalReflex.g:3091:6: lv_eqCmpOp_2_0= ruleCompareEqOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getEqCmpOpCompareEqOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_eqCmpOp_2_0=ruleCompareEqOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"eqCmpOp",
            	      							lv_eqCmpOp_2_0,
            	      							"ru.iaie.reflex.Reflex.CompareEqOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3108:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalReflex.g:3109:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalReflex.g:3109:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalReflex.g:3110:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_44);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.EqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleBitAndExpression"
    // InternalReflex.g:3132:1: entryRuleBitAndExpression returns [EObject current=null] : iv_ruleBitAndExpression= ruleBitAndExpression EOF ;
    public final EObject entryRuleBitAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitAndExpression = null;


        try {
            // InternalReflex.g:3132:57: (iv_ruleBitAndExpression= ruleBitAndExpression EOF )
            // InternalReflex.g:3133:2: iv_ruleBitAndExpression= ruleBitAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitAndExpression=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitAndExpression"


    // $ANTLR start "ruleBitAndExpression"
    // InternalReflex.g:3139:1: ruleBitAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) ;
    public final EObject ruleBitAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_AND_2=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3145:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) )
            // InternalReflex.g:3146:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            {
            // InternalReflex.g:3146:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            // InternalReflex.g:3147:3: this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_45);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3155:3: ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_BIT_AND) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalReflex.g:3156:4: () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) )
            	    {
            	    // InternalReflex.g:3156:4: ()
            	    // InternalReflex.g:3157:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitAndExpressionAccess().getBitAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_AND_2=(Token)match(input,RULE_BIT_AND,FOLLOW_38); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_AND_2, grammarAccess.getBitAndExpressionAccess().getBIT_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3167:4: ( (lv_right_3_0= ruleBitAndExpression ) )
            	    // InternalReflex.g:3168:5: (lv_right_3_0= ruleBitAndExpression )
            	    {
            	    // InternalReflex.g:3168:5: (lv_right_3_0= ruleBitAndExpression )
            	    // InternalReflex.g:3169:6: lv_right_3_0= ruleBitAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitAndExpressionAccess().getRightBitAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_45);
            	    lv_right_3_0=ruleBitAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.BitAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitAndExpression"


    // $ANTLR start "entryRuleBitXorExpression"
    // InternalReflex.g:3191:1: entryRuleBitXorExpression returns [EObject current=null] : iv_ruleBitXorExpression= ruleBitXorExpression EOF ;
    public final EObject entryRuleBitXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitXorExpression = null;


        try {
            // InternalReflex.g:3191:57: (iv_ruleBitXorExpression= ruleBitXorExpression EOF )
            // InternalReflex.g:3192:2: iv_ruleBitXorExpression= ruleBitXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitXorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitXorExpression=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitXorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitXorExpression"


    // $ANTLR start "ruleBitXorExpression"
    // InternalReflex.g:3198:1: ruleBitXorExpression returns [EObject current=null] : (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) ;
    public final EObject ruleBitXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_XOR_2=null;
        EObject this_BitAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3204:2: ( (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) )
            // InternalReflex.g:3205:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            {
            // InternalReflex.g:3205:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            // InternalReflex.g:3206:3: this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitXorExpressionAccess().getBitAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_46);
            this_BitAndExpression_0=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3214:3: ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_BIT_XOR) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalReflex.g:3215:4: () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) )
            	    {
            	    // InternalReflex.g:3215:4: ()
            	    // InternalReflex.g:3216:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitXorExpressionAccess().getBitXorExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_XOR_2=(Token)match(input,RULE_BIT_XOR,FOLLOW_38); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_XOR_2, grammarAccess.getBitXorExpressionAccess().getBIT_XORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3226:4: ( (lv_right_3_0= ruleBitXorExpression ) )
            	    // InternalReflex.g:3227:5: (lv_right_3_0= ruleBitXorExpression )
            	    {
            	    // InternalReflex.g:3227:5: (lv_right_3_0= ruleBitXorExpression )
            	    // InternalReflex.g:3228:6: lv_right_3_0= ruleBitXorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitXorExpressionAccess().getRightBitXorExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_46);
            	    lv_right_3_0=ruleBitXorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitXorExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.BitXorExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitXorExpression"


    // $ANTLR start "entryRuleBitOrExpression"
    // InternalReflex.g:3250:1: entryRuleBitOrExpression returns [EObject current=null] : iv_ruleBitOrExpression= ruleBitOrExpression EOF ;
    public final EObject entryRuleBitOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitOrExpression = null;


        try {
            // InternalReflex.g:3250:56: (iv_ruleBitOrExpression= ruleBitOrExpression EOF )
            // InternalReflex.g:3251:2: iv_ruleBitOrExpression= ruleBitOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitOrExpression=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitOrExpression"


    // $ANTLR start "ruleBitOrExpression"
    // InternalReflex.g:3257:1: ruleBitOrExpression returns [EObject current=null] : (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) ;
    public final EObject ruleBitOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_OR_2=null;
        EObject this_BitXorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3263:2: ( (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) )
            // InternalReflex.g:3264:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            {
            // InternalReflex.g:3264:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            // InternalReflex.g:3265:3: this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitOrExpressionAccess().getBitXorExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_47);
            this_BitXorExpression_0=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitXorExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3273:3: ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_BIT_OR) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalReflex.g:3274:4: () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) )
            	    {
            	    // InternalReflex.g:3274:4: ()
            	    // InternalReflex.g:3275:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitOrExpressionAccess().getBitOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_OR_2=(Token)match(input,RULE_BIT_OR,FOLLOW_38); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_OR_2, grammarAccess.getBitOrExpressionAccess().getBIT_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3285:4: ( (lv_right_3_0= ruleBitOrExpression ) )
            	    // InternalReflex.g:3286:5: (lv_right_3_0= ruleBitOrExpression )
            	    {
            	    // InternalReflex.g:3286:5: (lv_right_3_0= ruleBitOrExpression )
            	    // InternalReflex.g:3287:6: lv_right_3_0= ruleBitOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitOrExpressionAccess().getRightBitOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_47);
            	    lv_right_3_0=ruleBitOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.BitOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalReflex.g:3309:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalReflex.g:3309:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalReflex.g:3310:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // InternalReflex.g:3316:1: ruleLogicalAndExpression returns [EObject current=null] : (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_AND_2=null;
        EObject this_BitOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3322:2: ( (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalReflex.g:3323:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalReflex.g:3323:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalReflex.g:3324:3: this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getBitOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_48);
            this_BitOrExpression_0=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3332:3: ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_LOGICAL_AND) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalReflex.g:3333:4: () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalReflex.g:3333:4: ()
            	    // InternalReflex.g:3334:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_AND_2=(Token)match(input,RULE_LOGICAL_AND,FOLLOW_38); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_AND_2, grammarAccess.getLogicalAndExpressionAccess().getLOGICAL_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3344:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    // InternalReflex.g:3345:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalReflex.g:3345:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    // InternalReflex.g:3346:6: lv_right_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
            	    lv_right_3_0=ruleLogicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.LogicalAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalReflex.g:3368:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalReflex.g:3368:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalReflex.g:3369:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // InternalReflex.g:3375:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_OR_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3381:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) )
            // InternalReflex.g:3382:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            {
            // InternalReflex.g:3382:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            // InternalReflex.g:3383:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_49);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3391:3: ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_LOGICAL_OR) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalReflex.g:3392:4: () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    {
            	    // InternalReflex.g:3392:4: ()
            	    // InternalReflex.g:3393:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_OR_2=(Token)match(input,RULE_LOGICAL_OR,FOLLOW_38); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_OR_2, grammarAccess.getLogicalOrExpressionAccess().getLOGICAL_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3403:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    // InternalReflex.g:3404:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    {
            	    // InternalReflex.g:3404:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    // InternalReflex.g:3405:6: lv_right_3_0= ruleLogicalOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_49);
            	    lv_right_3_0=ruleLogicalOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.LogicalOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalReflex.g:3427:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalReflex.g:3427:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalReflex.g:3428:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalReflex.g:3434:1: ruleAssignmentExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_assignVar_1_0=null;
        EObject this_LogicalOrExpression_0 = null;

        Enumerator lv_assignOp_2_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3440:2: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) ) )
            // InternalReflex.g:3441:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) )
            {
            // InternalReflex.g:3441:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==EOF||(LA37_1>=RULE_BIT_AND && LA37_1<=RULE_LOGICAL_OR)||LA37_1==47||LA37_1==49||LA37_1==51||(LA37_1>=61 && LA37_1<=62)||(LA37_1>=82 && LA37_1<=83)||(LA37_1>=93 && LA37_1<=94)||(LA37_1>=97 && LA37_1<=107)) ) {
                    alt37=1;
                }
                else if ( (LA37_1==52||(LA37_1>=84 && LA37_1<=92)) ) {
                    alt37=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA37_0>=RULE_HEX && LA37_0<=RULE_DECIMAL)||(LA37_0>=RULE_DEC_FLOAT && LA37_0<=RULE_HEX_FLOAT)||LA37_0==61||(LA37_0>=82 && LA37_0<=83)||(LA37_0>=93 && LA37_0<=96)) ) {
                alt37=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalReflex.g:3442:3: this_LogicalOrExpression_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getLogicalOrExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LogicalOrExpression_0=ruleLogicalOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LogicalOrExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3451:3: ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) )
                    {
                    // InternalReflex.g:3451:3: ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) )
                    // InternalReflex.g:3452:4: ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) )
                    {
                    // InternalReflex.g:3452:4: ( (lv_assignVar_1_0= RULE_ID ) )
                    // InternalReflex.g:3453:5: (lv_assignVar_1_0= RULE_ID )
                    {
                    // InternalReflex.g:3453:5: (lv_assignVar_1_0= RULE_ID )
                    // InternalReflex.g:3454:6: lv_assignVar_1_0= RULE_ID
                    {
                    lv_assignVar_1_0=(Token)match(input,RULE_ID,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_assignVar_1_0, grammarAccess.getAssignmentExpressionAccess().getAssignVarIDTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"assignVar",
                      							true,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3470:4: ( (lv_assignOp_2_0= ruleAssignOperator ) )
                    // InternalReflex.g:3471:5: (lv_assignOp_2_0= ruleAssignOperator )
                    {
                    // InternalReflex.g:3471:5: (lv_assignOp_2_0= ruleAssignOperator )
                    // InternalReflex.g:3472:6: lv_assignOp_2_0= ruleAssignOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getAssignOpAssignOperatorEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_38);
                    lv_assignOp_2_0=ruleAssignOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"assignOp",
                      							true,
                      							"ru.iaie.reflex.Reflex.AssignOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3489:4: ( (lv_expr_3_0= ruleLogicalOrExpression ) )
                    // InternalReflex.g:3490:5: (lv_expr_3_0= ruleLogicalOrExpression )
                    {
                    // InternalReflex.g:3490:5: (lv_expr_3_0= ruleLogicalOrExpression )
                    // InternalReflex.g:3491:6: lv_expr_3_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_3_0=ruleLogicalOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_3_0,
                      							"ru.iaie.reflex.Reflex.LogicalOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalReflex.g:3513:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalReflex.g:3513:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalReflex.g:3514:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalReflex.g:3520:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3526:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalReflex.g:3527:2: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AssignmentExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleCType"
    // InternalReflex.g:3538:1: entryRuleCType returns [EObject current=null] : iv_ruleCType= ruleCType EOF ;
    public final EObject entryRuleCType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCType = null;


        try {
            // InternalReflex.g:3538:46: (iv_ruleCType= ruleCType EOF )
            // InternalReflex.g:3539:2: iv_ruleCType= ruleCType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCType=ruleCType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCType"


    // $ANTLR start "ruleCType"
    // InternalReflex.g:3545:1: ruleCType returns [EObject current=null] : ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) ;
    public final EObject ruleCType() throws RecognitionException {
        EObject current = null;

        Token this_VOID_C_TYPE_1=null;
        Token this_FLOAT_C_TYPE_3=null;
        Token this_DOUBLE_C_TYPE_5=null;
        Token this_SHORT_C_TYPE_8=null;
        Token this_INT_C_TYPE_9=null;
        Token this_LONG_C_TYPE_10=null;
        Enumerator lv_signSpec_7_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3551:2: ( ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) )
            // InternalReflex.g:3552:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            {
            // InternalReflex.g:3552:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            int alt40=4;
            switch ( input.LA(1) ) {
            case RULE_VOID_C_TYPE:
                {
                alt40=1;
                }
                break;
            case RULE_FLOAT_C_TYPE:
                {
                alt40=2;
                }
                break;
            case RULE_DOUBLE_C_TYPE:
                {
                alt40=3;
                }
                break;
            case RULE_SHORT_C_TYPE:
            case RULE_INT_C_TYPE:
            case RULE_LONG_C_TYPE:
            case 108:
            case 109:
                {
                alt40=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalReflex.g:3553:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    {
                    // InternalReflex.g:3553:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    // InternalReflex.g:3554:4: () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE
                    {
                    // InternalReflex.g:3554:4: ()
                    // InternalReflex.g:3555:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    this_VOID_C_TYPE_1=(Token)match(input,RULE_VOID_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_VOID_C_TYPE_1, grammarAccess.getCTypeAccess().getVOID_C_TYPETerminalRuleCall_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3567:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    {
                    // InternalReflex.g:3567:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    // InternalReflex.g:3568:4: () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE
                    {
                    // InternalReflex.g:3568:4: ()
                    // InternalReflex.g:3569:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    this_FLOAT_C_TYPE_3=(Token)match(input,RULE_FLOAT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FLOAT_C_TYPE_3, grammarAccess.getCTypeAccess().getFLOAT_C_TYPETerminalRuleCall_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:3581:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    {
                    // InternalReflex.g:3581:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    // InternalReflex.g:3582:4: () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE
                    {
                    // InternalReflex.g:3582:4: ()
                    // InternalReflex.g:3583:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_2_0(),
                      						current);
                      				
                    }

                    }

                    this_DOUBLE_C_TYPE_5=(Token)match(input,RULE_DOUBLE_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_DOUBLE_C_TYPE_5, grammarAccess.getCTypeAccess().getDOUBLE_C_TYPETerminalRuleCall_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:3595:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    {
                    // InternalReflex.g:3595:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    // InternalReflex.g:3596:4: () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    {
                    // InternalReflex.g:3596:4: ()
                    // InternalReflex.g:3597:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:3603:4: ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( ((LA38_0>=108 && LA38_0<=109)) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalReflex.g:3604:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            {
                            // InternalReflex.g:3604:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            // InternalReflex.g:3605:6: lv_signSpec_7_0= ruleCTypeSignSpec
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getCTypeAccess().getSignSpecCTypeSignSpecEnumRuleCall_3_1_0());
                              					
                            }
                            pushFollow(FOLLOW_51);
                            lv_signSpec_7_0=ruleCTypeSignSpec();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getCTypeRule());
                              						}
                              						set(
                              							current,
                              							"signSpec",
                              							true,
                              							"ru.iaie.reflex.Reflex.CTypeSignSpec");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalReflex.g:3622:4: (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    int alt39=3;
                    switch ( input.LA(1) ) {
                    case RULE_SHORT_C_TYPE:
                        {
                        alt39=1;
                        }
                        break;
                    case RULE_INT_C_TYPE:
                        {
                        alt39=2;
                        }
                        break;
                    case RULE_LONG_C_TYPE:
                        {
                        alt39=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }

                    switch (alt39) {
                        case 1 :
                            // InternalReflex.g:3623:5: this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE
                            {
                            this_SHORT_C_TYPE_8=(Token)match(input,RULE_SHORT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_SHORT_C_TYPE_8, grammarAccess.getCTypeAccess().getSHORT_C_TYPETerminalRuleCall_3_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalReflex.g:3628:5: this_INT_C_TYPE_9= RULE_INT_C_TYPE
                            {
                            this_INT_C_TYPE_9=(Token)match(input,RULE_INT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_INT_C_TYPE_9, grammarAccess.getCTypeAccess().getINT_C_TYPETerminalRuleCall_3_2_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalReflex.g:3633:5: this_LONG_C_TYPE_10= RULE_LONG_C_TYPE
                            {
                            this_LONG_C_TYPE_10=(Token)match(input,RULE_LONG_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_LONG_C_TYPE_10, grammarAccess.getCTypeAccess().getLONG_C_TYPETerminalRuleCall_3_2_2());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCType"


    // $ANTLR start "entryRuleIntegerType"
    // InternalReflex.g:3643:1: entryRuleIntegerType returns [String current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final String entryRuleIntegerType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerType = null;


        try {
            // InternalReflex.g:3643:51: (iv_ruleIntegerType= ruleIntegerType EOF )
            // InternalReflex.g:3644:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerType.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerType"


    // $ANTLR start "ruleIntegerType"
    // InternalReflex.g:3650:1: ruleIntegerType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) ;
    public final AntlrDatatypeRuleToken ruleIntegerType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOL_TYPE_0=null;
        Token this_INT_C_TYPE_1=null;
        Token this_SHORT_C_TYPE_2=null;
        Token this_LONG_C_TYPE_3=null;


        	enterRule();

        try {
            // InternalReflex.g:3656:2: ( (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) )
            // InternalReflex.g:3657:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            {
            // InternalReflex.g:3657:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            int alt41=4;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                alt41=1;
                }
                break;
            case RULE_INT_C_TYPE:
                {
                alt41=2;
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                alt41=3;
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                alt41=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalReflex.g:3658:3: this_BOOL_TYPE_0= RULE_BOOL_TYPE
                    {
                    this_BOOL_TYPE_0=(Token)match(input,RULE_BOOL_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_BOOL_TYPE_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_BOOL_TYPE_0, grammarAccess.getIntegerTypeAccess().getBOOL_TYPETerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3666:3: this_INT_C_TYPE_1= RULE_INT_C_TYPE
                    {
                    this_INT_C_TYPE_1=(Token)match(input,RULE_INT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_INT_C_TYPE_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_INT_C_TYPE_1, grammarAccess.getIntegerTypeAccess().getINT_C_TYPETerminalRuleCall_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:3674:3: this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE
                    {
                    this_SHORT_C_TYPE_2=(Token)match(input,RULE_SHORT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_SHORT_C_TYPE_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_SHORT_C_TYPE_2, grammarAccess.getIntegerTypeAccess().getSHORT_C_TYPETerminalRuleCall_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:3682:3: this_LONG_C_TYPE_3= RULE_LONG_C_TYPE
                    {
                    this_LONG_C_TYPE_3=(Token)match(input,RULE_LONG_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_LONG_C_TYPE_3);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_LONG_C_TYPE_3, grammarAccess.getIntegerTypeAccess().getLONG_C_TYPETerminalRuleCall_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerType"


    // $ANTLR start "entryRuleReflexType"
    // InternalReflex.g:3693:1: entryRuleReflexType returns [EObject current=null] : iv_ruleReflexType= ruleReflexType EOF ;
    public final EObject entryRuleReflexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReflexType = null;


        try {
            // InternalReflex.g:3693:51: (iv_ruleReflexType= ruleReflexType EOF )
            // InternalReflex.g:3694:2: iv_ruleReflexType= ruleReflexType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReflexTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReflexType=ruleReflexType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReflexType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReflexType"


    // $ANTLR start "ruleReflexType"
    // InternalReflex.g:3700:1: ruleReflexType returns [EObject current=null] : (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) ;
    public final EObject ruleReflexType() throws RecognitionException {
        EObject current = null;

        Token this_BOOL_TYPE_2=null;
        EObject this_CType_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3706:2: ( (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) )
            // InternalReflex.g:3707:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            {
            // InternalReflex.g:3707:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_VOID_C_TYPE && LA42_0<=RULE_LONG_C_TYPE)||(LA42_0>=108 && LA42_0<=109)) ) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_BOOL_TYPE) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalReflex.g:3708:3: this_CType_0= ruleCType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReflexTypeAccess().getCTypeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CType_0=ruleCType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CType_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3717:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    {
                    // InternalReflex.g:3717:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    // InternalReflex.g:3718:4: () this_BOOL_TYPE_2= RULE_BOOL_TYPE
                    {
                    // InternalReflex.g:3718:4: ()
                    // InternalReflex.g:3719:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getReflexTypeAccess().getReflexTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    this_BOOL_TYPE_2=(Token)match(input,RULE_BOOL_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BOOL_TYPE_2, grammarAccess.getReflexTypeAccess().getBOOL_TYPETerminalRuleCall_1_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReflexType"


    // $ANTLR start "entryRuleInteger"
    // InternalReflex.g:3734:1: entryRuleInteger returns [EObject current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final EObject entryRuleInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteger = null;


        try {
            // InternalReflex.g:3734:48: (iv_ruleInteger= ruleInteger EOF )
            // InternalReflex.g:3735:2: iv_ruleInteger= ruleInteger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInteger=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInteger; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // InternalReflex.g:3741:1: ruleInteger returns [EObject current=null] : ( ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? ) ;
    public final EObject ruleInteger() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;
        Token lv_value_0_3=null;
        Token lv_qualfier_1_1=null;
        Token lv_qualfier_1_2=null;


        	enterRule();

        try {
            // InternalReflex.g:3747:2: ( ( ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? ) )
            // InternalReflex.g:3748:2: ( ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? )
            {
            // InternalReflex.g:3748:2: ( ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? )
            // InternalReflex.g:3749:3: ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )?
            {
            // InternalReflex.g:3749:3: ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) )
            // InternalReflex.g:3750:4: ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) )
            {
            // InternalReflex.g:3750:4: ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) )
            // InternalReflex.g:3751:5: (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL )
            {
            // InternalReflex.g:3751:5: (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL )
            int alt43=3;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt43=1;
                }
                break;
            case RULE_OCTAL:
                {
                alt43=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalReflex.g:3752:6: lv_value_0_1= RULE_HEX
                    {
                    lv_value_0_1=(Token)match(input,RULE_HEX,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_1, grammarAccess.getIntegerAccess().getValueHEXTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_1,
                      							"ru.iaie.reflex.Reflex.HEX");
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3767:6: lv_value_0_2= RULE_OCTAL
                    {
                    lv_value_0_2=(Token)match(input,RULE_OCTAL,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_2, grammarAccess.getIntegerAccess().getValueOCTALTerminalRuleCall_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_2,
                      							"ru.iaie.reflex.Reflex.OCTAL");
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:3782:6: lv_value_0_3= RULE_DECIMAL
                    {
                    lv_value_0_3=(Token)match(input,RULE_DECIMAL,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_3, grammarAccess.getIntegerAccess().getValueDECIMALTerminalRuleCall_0_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_3,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalReflex.g:3799:3: ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=RULE_LONG && LA45_0<=RULE_UNSIGNED)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalReflex.g:3800:4: ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) )
                    {
                    // InternalReflex.g:3800:4: ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) )
                    // InternalReflex.g:3801:5: (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED )
                    {
                    // InternalReflex.g:3801:5: (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==RULE_LONG) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==RULE_UNSIGNED) ) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalReflex.g:3802:6: lv_qualfier_1_1= RULE_LONG
                            {
                            lv_qualfier_1_1=(Token)match(input,RULE_LONG,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_qualfier_1_1, grammarAccess.getIntegerAccess().getQualfierLONGTerminalRuleCall_1_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIntegerRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"qualfier",
                              							true,
                              							"ru.iaie.reflex.Reflex.LONG");
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalReflex.g:3817:6: lv_qualfier_1_2= RULE_UNSIGNED
                            {
                            lv_qualfier_1_2=(Token)match(input,RULE_UNSIGNED,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_qualfier_1_2, grammarAccess.getIntegerAccess().getQualfierUNSIGNEDTerminalRuleCall_1_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIntegerRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"qualfier",
                              							true,
                              							"ru.iaie.reflex.Reflex.UNSIGNED");
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleFloat"
    // InternalReflex.g:3838:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // InternalReflex.g:3838:45: (iv_ruleFloat= ruleFloat EOF )
            // InternalReflex.g:3839:2: iv_ruleFloat= ruleFloat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFloat=ruleFloat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloat.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // InternalReflex.g:3845:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DEC_FLOAT_0= RULE_DEC_FLOAT | this_HEX_FLOAT_1= RULE_HEX_FLOAT ) ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DEC_FLOAT_0=null;
        Token this_HEX_FLOAT_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3851:2: ( (this_DEC_FLOAT_0= RULE_DEC_FLOAT | this_HEX_FLOAT_1= RULE_HEX_FLOAT ) )
            // InternalReflex.g:3852:2: (this_DEC_FLOAT_0= RULE_DEC_FLOAT | this_HEX_FLOAT_1= RULE_HEX_FLOAT )
            {
            // InternalReflex.g:3852:2: (this_DEC_FLOAT_0= RULE_DEC_FLOAT | this_HEX_FLOAT_1= RULE_HEX_FLOAT )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_DEC_FLOAT) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_HEX_FLOAT) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalReflex.g:3853:3: this_DEC_FLOAT_0= RULE_DEC_FLOAT
                    {
                    this_DEC_FLOAT_0=(Token)match(input,RULE_DEC_FLOAT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_DEC_FLOAT_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_DEC_FLOAT_0, grammarAccess.getFloatAccess().getDEC_FLOATTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3861:3: this_HEX_FLOAT_1= RULE_HEX_FLOAT
                    {
                    this_HEX_FLOAT_1=(Token)match(input,RULE_HEX_FLOAT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_HEX_FLOAT_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_HEX_FLOAT_1, grammarAccess.getFloatAccess().getHEX_FLOATTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleTime"
    // InternalReflex.g:3872:1: entryRuleTime returns [EObject current=null] : iv_ruleTime= ruleTime EOF ;
    public final EObject entryRuleTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTime = null;


        try {
            // InternalReflex.g:3872:45: (iv_ruleTime= ruleTime EOF )
            // InternalReflex.g:3873:2: iv_ruleTime= ruleTime EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTime=ruleTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTime; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTime"


    // $ANTLR start "ruleTime"
    // InternalReflex.g:3879:1: ruleTime returns [EObject current=null] : ( () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )? ) ;
    public final EObject ruleTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_isDay_3_0=null;
        Token lv_days_4_0=null;
        Token lv_isHour_5_0=null;
        Token lv_hours_6_0=null;


        	enterRule();

        try {
            // InternalReflex.g:3885:2: ( ( () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )? ) )
            // InternalReflex.g:3886:2: ( () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )? )
            {
            // InternalReflex.g:3886:2: ( () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )? )
            // InternalReflex.g:3887:3: () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )?
            {
            // InternalReflex.g:3887:3: ()
            // InternalReflex.g:3888:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTimeAccess().getTimeAction_0(),
              					current);
              			
            }

            }

            // InternalReflex.g:3894:3: (otherlv_1= '0t' | otherlv_2= '0T' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==78) ) {
                alt47=1;
            }
            else if ( (LA47_0==79) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalReflex.g:3895:4: otherlv_1= '0t'
                    {
                    otherlv_1=(Token)match(input,78,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTimeAccess().getTKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3900:4: otherlv_2= '0T'
                    {
                    otherlv_2=(Token)match(input,79,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getTimeAccess().getTKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalReflex.g:3905:3: ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_DAY) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalReflex.g:3906:4: ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) )
                    {
                    // InternalReflex.g:3906:4: ( (lv_isDay_3_0= RULE_DAY ) )
                    // InternalReflex.g:3907:5: (lv_isDay_3_0= RULE_DAY )
                    {
                    // InternalReflex.g:3907:5: (lv_isDay_3_0= RULE_DAY )
                    // InternalReflex.g:3908:6: lv_isDay_3_0= RULE_DAY
                    {
                    lv_isDay_3_0=(Token)match(input,RULE_DAY,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isDay_3_0, grammarAccess.getTimeAccess().getIsDayDAYTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"isDay",
                      							true,
                      							"ru.iaie.reflex.Reflex.DAY");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3924:4: ( (lv_days_4_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3925:5: (lv_days_4_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3925:5: (lv_days_4_0= RULE_DECIMAL )
                    // InternalReflex.g:3926:6: lv_days_4_0= RULE_DECIMAL
                    {
                    lv_days_4_0=(Token)match(input,RULE_DECIMAL,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_days_4_0, grammarAccess.getTimeAccess().getDaysDECIMALTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"days",
                      							lv_days_4_0,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:3943:3: ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_HOUR) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalReflex.g:3944:4: ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) )
                    {
                    // InternalReflex.g:3944:4: ( (lv_isHour_5_0= RULE_HOUR ) )
                    // InternalReflex.g:3945:5: (lv_isHour_5_0= RULE_HOUR )
                    {
                    // InternalReflex.g:3945:5: (lv_isHour_5_0= RULE_HOUR )
                    // InternalReflex.g:3946:6: lv_isHour_5_0= RULE_HOUR
                    {
                    lv_isHour_5_0=(Token)match(input,RULE_HOUR,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isHour_5_0, grammarAccess.getTimeAccess().getIsHourHOURTerminalRuleCall_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"isHour",
                      							true,
                      							"ru.iaie.reflex.Reflex.HOUR");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3962:4: ( (lv_hours_6_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3963:5: (lv_hours_6_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3963:5: (lv_hours_6_0= RULE_DECIMAL )
                    // InternalReflex.g:3964:6: lv_hours_6_0= RULE_DECIMAL
                    {
                    lv_hours_6_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_hours_6_0, grammarAccess.getTimeAccess().getHoursDECIMALTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"hours",
                      							lv_hours_6_0,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTime"


    // $ANTLR start "ruleRegisterType"
    // InternalReflex.g:3985:1: ruleRegisterType returns [Enumerator current=null] : ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) ;
    public final Enumerator ruleRegisterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3991:2: ( ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) )
            // InternalReflex.g:3992:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            {
            // InternalReflex.g:3992:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==80) ) {
                alt50=1;
            }
            else if ( (LA50_0==81) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalReflex.g:3993:3: (enumLiteral_0= 'input' )
                    {
                    // InternalReflex.g:3993:3: (enumLiteral_0= 'input' )
                    // InternalReflex.g:3994:4: enumLiteral_0= 'input'
                    {
                    enumLiteral_0=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4001:3: (enumLiteral_1= 'output' )
                    {
                    // InternalReflex.g:4001:3: (enumLiteral_1= 'output' )
                    // InternalReflex.g:4002:4: enumLiteral_1= 'output'
                    {
                    enumLiteral_1=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getOUTPUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegisterTypeAccess().getOUTPUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegisterType"


    // $ANTLR start "ruleInfixPostfixOp"
    // InternalReflex.g:4012:1: ruleInfixPostfixOp returns [Enumerator current=null] : ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) ;
    public final Enumerator ruleInfixPostfixOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4018:2: ( ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) )
            // InternalReflex.g:4019:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            {
            // InternalReflex.g:4019:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==82) ) {
                alt51=1;
            }
            else if ( (LA51_0==83) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalReflex.g:4020:3: (enumLiteral_0= '++' )
                    {
                    // InternalReflex.g:4020:3: (enumLiteral_0= '++' )
                    // InternalReflex.g:4021:4: enumLiteral_0= '++'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4028:3: (enumLiteral_1= '--' )
                    {
                    // InternalReflex.g:4028:3: (enumLiteral_1= '--' )
                    // InternalReflex.g:4029:4: enumLiteral_1= '--'
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getDECEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getInfixPostfixOpAccess().getDECEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixPostfixOp"


    // $ANTLR start "ruleAssignOperator"
    // InternalReflex.g:4039:1: ruleAssignOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) ;
    public final Enumerator ruleAssignOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;


        	enterRule();

        try {
            // InternalReflex.g:4045:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) )
            // InternalReflex.g:4046:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            {
            // InternalReflex.g:4046:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            int alt52=10;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt52=1;
                }
                break;
            case 84:
                {
                alt52=2;
                }
                break;
            case 85:
                {
                alt52=3;
                }
                break;
            case 86:
                {
                alt52=4;
                }
                break;
            case 87:
                {
                alt52=5;
                }
                break;
            case 88:
                {
                alt52=6;
                }
                break;
            case 89:
                {
                alt52=7;
                }
                break;
            case 90:
                {
                alt52=8;
                }
                break;
            case 91:
                {
                alt52=9;
                }
                break;
            case 92:
                {
                alt52=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalReflex.g:4047:3: (enumLiteral_0= '=' )
                    {
                    // InternalReflex.g:4047:3: (enumLiteral_0= '=' )
                    // InternalReflex.g:4048:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4055:3: (enumLiteral_1= '*=' )
                    {
                    // InternalReflex.g:4055:3: (enumLiteral_1= '*=' )
                    // InternalReflex.g:4056:4: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4063:3: (enumLiteral_2= '/=' )
                    {
                    // InternalReflex.g:4063:3: (enumLiteral_2= '/=' )
                    // InternalReflex.g:4064:4: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4071:3: (enumLiteral_3= '+=' )
                    {
                    // InternalReflex.g:4071:3: (enumLiteral_3= '+=' )
                    // InternalReflex.g:4072:4: enumLiteral_3= '+='
                    {
                    enumLiteral_3=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:4079:3: (enumLiteral_4= '-=' )
                    {
                    // InternalReflex.g:4079:3: (enumLiteral_4= '-=' )
                    // InternalReflex.g:4080:4: enumLiteral_4= '-='
                    {
                    enumLiteral_4=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:4087:3: (enumLiteral_5= '<<=' )
                    {
                    // InternalReflex.g:4087:3: (enumLiteral_5= '<<=' )
                    // InternalReflex.g:4088:4: enumLiteral_5= '<<='
                    {
                    enumLiteral_5=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:4095:3: (enumLiteral_6= '>>=' )
                    {
                    // InternalReflex.g:4095:3: (enumLiteral_6= '>>=' )
                    // InternalReflex.g:4096:4: enumLiteral_6= '>>='
                    {
                    enumLiteral_6=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalReflex.g:4103:3: (enumLiteral_7= '&=' )
                    {
                    // InternalReflex.g:4103:3: (enumLiteral_7= '&=' )
                    // InternalReflex.g:4104:4: enumLiteral_7= '&='
                    {
                    enumLiteral_7=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalReflex.g:4111:3: (enumLiteral_8= '^=' )
                    {
                    // InternalReflex.g:4111:3: (enumLiteral_8= '^=' )
                    // InternalReflex.g:4112:4: enumLiteral_8= '^='
                    {
                    enumLiteral_8=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:4119:3: (enumLiteral_9= '|=' )
                    {
                    // InternalReflex.g:4119:3: (enumLiteral_9= '|=' )
                    // InternalReflex.g:4120:4: enumLiteral_9= '|='
                    {
                    enumLiteral_9=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_OREnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getAssignOperatorAccess().getBIT_OREnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignOperator"


    // $ANTLR start "ruleUnaryOp"
    // InternalReflex.g:4130:1: ruleUnaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) ;
    public final Enumerator ruleUnaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4136:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) )
            // InternalReflex.g:4137:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            {
            // InternalReflex.g:4137:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            int alt53=4;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt53=1;
                }
                break;
            case 94:
                {
                alt53=2;
                }
                break;
            case 95:
                {
                alt53=3;
                }
                break;
            case 96:
                {
                alt53=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalReflex.g:4138:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4138:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4139:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4146:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4146:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4147:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4154:3: (enumLiteral_2= '~' )
                    {
                    // InternalReflex.g:4154:3: (enumLiteral_2= '~' )
                    // InternalReflex.g:4155:4: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4162:3: (enumLiteral_3= '!' )
                    {
                    // InternalReflex.g:4162:3: (enumLiteral_3= '!' )
                    // InternalReflex.g:4163:4: enumLiteral_3= '!'
                    {
                    enumLiteral_3=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getLOGICAL_NOTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getUnaryOpAccess().getLOGICAL_NOTEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOp"


    // $ANTLR start "ruleCompareOp"
    // InternalReflex.g:4173:1: ruleCompareOp returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4179:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) )
            // InternalReflex.g:4180:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalReflex.g:4180:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            int alt54=4;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt54=1;
                }
                break;
            case 98:
                {
                alt54=2;
                }
                break;
            case 99:
                {
                alt54=3;
                }
                break;
            case 100:
                {
                alt54=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalReflex.g:4181:3: (enumLiteral_0= '<' )
                    {
                    // InternalReflex.g:4181:3: (enumLiteral_0= '<' )
                    // InternalReflex.g:4182:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4189:3: (enumLiteral_1= '>' )
                    {
                    // InternalReflex.g:4189:3: (enumLiteral_1= '>' )
                    // InternalReflex.g:4190:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4197:3: (enumLiteral_2= '=<' )
                    {
                    // InternalReflex.g:4197:3: (enumLiteral_2= '=<' )
                    // InternalReflex.g:4198:4: enumLiteral_2= '=<'
                    {
                    enumLiteral_2=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4205:3: (enumLiteral_3= '>=' )
                    {
                    // InternalReflex.g:4205:3: (enumLiteral_3= '>=' )
                    // InternalReflex.g:4206:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATER_EQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getCompareOpAccess().getGREATER_EQEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareOp"


    // $ANTLR start "ruleCompareEqOp"
    // InternalReflex.g:4216:1: ruleCompareEqOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleCompareEqOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4222:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // InternalReflex.g:4223:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // InternalReflex.g:4223:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==101) ) {
                alt55=1;
            }
            else if ( (LA55_0==102) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalReflex.g:4224:3: (enumLiteral_0= '==' )
                    {
                    // InternalReflex.g:4224:3: (enumLiteral_0= '==' )
                    // InternalReflex.g:4225:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4232:3: (enumLiteral_1= '!=' )
                    {
                    // InternalReflex.g:4232:3: (enumLiteral_1= '!=' )
                    // InternalReflex.g:4233:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getNOT_EQEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareEqOpAccess().getNOT_EQEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareEqOp"


    // $ANTLR start "ruleShiftOp"
    // InternalReflex.g:4243:1: ruleShiftOp returns [Enumerator current=null] : ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) ;
    public final Enumerator ruleShiftOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4249:2: ( ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) )
            // InternalReflex.g:4250:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            {
            // InternalReflex.g:4250:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==103) ) {
                alt56=1;
            }
            else if ( (LA56_0==104) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalReflex.g:4251:3: (enumLiteral_0= '>>' )
                    {
                    // InternalReflex.g:4251:3: (enumLiteral_0= '>>' )
                    // InternalReflex.g:4252:4: enumLiteral_0= '>>'
                    {
                    enumLiteral_0=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4259:3: (enumLiteral_1= '<<' )
                    {
                    // InternalReflex.g:4259:3: (enumLiteral_1= '<<' )
                    // InternalReflex.g:4260:4: enumLiteral_1= '<<'
                    {
                    enumLiteral_1=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getRIGHT_SHIFTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getShiftOpAccess().getRIGHT_SHIFTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftOp"


    // $ANTLR start "ruleAdditiveOp"
    // InternalReflex.g:4270:1: ruleAdditiveOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4276:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalReflex.g:4277:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalReflex.g:4277:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==93) ) {
                alt57=1;
            }
            else if ( (LA57_0==94) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalReflex.g:4278:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4278:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4279:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4286:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4286:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4287:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAdditiveOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOp"


    // $ANTLR start "ruleMultiplicativeOp"
    // InternalReflex.g:4297:1: ruleMultiplicativeOp returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalReflex.g:4303:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalReflex.g:4304:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalReflex.g:4304:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt58=3;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt58=1;
                }
                break;
            case 106:
                {
                alt58=2;
                }
                break;
            case 107:
                {
                alt58=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalReflex.g:4305:3: (enumLiteral_0= '*' )
                    {
                    // InternalReflex.g:4305:3: (enumLiteral_0= '*' )
                    // InternalReflex.g:4306:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4313:3: (enumLiteral_1= '/' )
                    {
                    // InternalReflex.g:4313:3: (enumLiteral_1= '/' )
                    // InternalReflex.g:4314:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4321:3: (enumLiteral_2= '%' )
                    {
                    // InternalReflex.g:4321:3: (enumLiteral_2= '%' )
                    // InternalReflex.g:4322:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMODEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getMultiplicativeOpAccess().getMODEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOp"


    // $ANTLR start "ruleCTypeSignSpec"
    // InternalReflex.g:4332:1: ruleCTypeSignSpec returns [Enumerator current=null] : ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) ;
    public final Enumerator ruleCTypeSignSpec() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4338:2: ( ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) )
            // InternalReflex.g:4339:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            {
            // InternalReflex.g:4339:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==108) ) {
                alt59=1;
            }
            else if ( (LA59_0==109) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalReflex.g:4340:3: (enumLiteral_0= 'signed' )
                    {
                    // InternalReflex.g:4340:3: (enumLiteral_0= 'signed' )
                    // InternalReflex.g:4341:4: enumLiteral_0= 'signed'
                    {
                    enumLiteral_0=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4348:3: (enumLiteral_1= 'unsigned' )
                    {
                    // InternalReflex.g:4348:3: (enumLiteral_1= 'unsigned' )
                    // InternalReflex.g:4349:4: enumLiteral_1= 'unsigned'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCTypeSignSpecAccess().getUNSIGNEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCTypeSignSpecAccess().getUNSIGNEDEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCTypeSignSpec"

    // $ANTLR start synpred1_InternalReflex
    public final void synpred1_InternalReflex_fragment() throws RecognitionException {   
        // InternalReflex.g:1295:5: ( 'else' )
        // InternalReflex.g:1295:6: 'else'
        {
        match(input,63,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalReflex

    // Delegated rules

    public final boolean synpred1_InternalReflex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalReflex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000180000001F820L,0x0000300000033000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000180000001F800L,0x0000300000033000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x040480000003F800L,0x0000300000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0400800000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0380000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x3802C000019C0010L,0x00000001E00C07F1L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0800800000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x30024000019C0012L,0x00000001E00C07F1L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x3002C000019C0010L,0x00000001E00C07F1L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x30024000019C0010L,0x00000001E00C07F1L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x30024000019C0010L,0x00000001E00C07F9L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0400000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000000001F800L,0x0000300000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x4008000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x70024000019C0010L,0x00000001E00C07F1L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x20000000019C0010L,0x00000001E00C0000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x000400000003F800L,0x0000300000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000002L,0x00000E0000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000002L,0x0000000060000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000018000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000001E00000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000002L,0x0000006000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0010000000000000L,0x000000001FF00000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000004000002L});

}