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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGER", "RULE_FLOAT", "RULE_BIT_AND", "RULE_BIT_XOR", "RULE_BIT_OR", "RULE_LOGICAL_AND", "RULE_LOGICAL_OR", "RULE_VOID_C_TYPE", "RULE_FLOAT_C_TYPE", "RULE_DOUBLE_C_TYPE", "RULE_SHORT_C_TYPE", "RULE_INT_C_TYPE", "RULE_LONG_C_TYPE", "RULE_BOOL_TYPE", "RULE_HEX", "RULE_OCTAL", "RULE_DECIMAL", "RULE_LONG", "RULE_UNSIGNED", "RULE_DEC_FLOAT", "RULE_HEX_FLOAT", "RULE_DEC_SEQUENCE", "RULE_EXPONENT", "RULE_SIGN", "RULE_FLOAT_SUFFIX", "RULE_HEX_SEQUENCE", "RULE_BIN_EXPONENT", "RULE_HEX_PREFIX", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'program'", "'{'", "'}'", "'['", "'annotation'", "']'", "'process'", "'looped'", "'state'", "';'", "'from'", "','", "'='", "'timeout'", "'if'", "'('", "')'", "'else'", "'switch'", "'case'", "':'", "'break'", "'start'", "'stop'", "'error'", "'restart'", "'reset'", "'timer'", "'set'", "'next'", "'const'", "'enum'", "'tact'", "'local'", "'shared'", "'input'", "'output'", "'++'", "'--'", "'*='", "'/='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'+'", "'-'", "'~'", "'!'", "'<'", "'>'", "'=<'", "'>='", "'=='", "'!='", "'>>'", "'<<'", "'*'", "'/'", "'%'", "'signed'", "'unsigned'"
    };
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
    public static final int RULE_ID=4;
    public static final int RULE_HEX_FLOAT=25;
    public static final int RULE_INT_C_TYPE=16;
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
    public static final int RULE_VOID_C_TYPE=12;
    public static final int RULE_HEX_SEQUENCE=30;
    public static final int RULE_UNSIGNED=23;
    public static final int RULE_DOUBLE_C_TYPE=14;
    public static final int RULE_BIN_EXPONENT=31;
    public static final int RULE_LOGICAL_AND=10;
    public static final int RULE_EXPONENT=27;
    public static final int T__48=48;
    public static final int RULE_DEC_FLOAT=24;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=6;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int RULE_BIT_AND=7;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int RULE_BOOL_TYPE=18;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_FLOAT_C_TYPE=13;
    public static final int RULE_OCTAL=20;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_SHORT_C_TYPE=15;
    public static final int RULE_DECIMAL=21;
    public static final int RULE_LOGICAL_OR=11;
    public static final int RULE_LONG_C_TYPE=17;
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
    public static final int RULE_BIT_XOR=8;
    public static final int T__89=89;
    public static final int RULE_BIT_OR=9;
    public static final int RULE_LONG=22;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=5;
    public static final int T__86=86;
    public static final int T__87=87;

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
    // InternalReflex.g:72:1: ruleProgram returns [EObject current=null] : (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= ruleTact ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_globalVars_7_0= ruleGlobalVariable ) ) | ( (lv_registers_8_0= ruleRegister ) ) | ( (lv_processes_9_0= ruleProcess ) ) )* otherlv_10= '}' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_10=null;
        EObject lv_ticks_3_0 = null;

        EObject lv_consts_4_0 = null;

        EObject lv_enums_5_0 = null;

        EObject lv_functions_6_0 = null;

        EObject lv_globalVars_7_0 = null;

        EObject lv_registers_8_0 = null;

        EObject lv_processes_9_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:78:2: ( (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= ruleTact ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_globalVars_7_0= ruleGlobalVariable ) ) | ( (lv_registers_8_0= ruleRegister ) ) | ( (lv_processes_9_0= ruleProcess ) ) )* otherlv_10= '}' ) )
            // InternalReflex.g:79:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= ruleTact ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_globalVars_7_0= ruleGlobalVariable ) ) | ( (lv_registers_8_0= ruleRegister ) ) | ( (lv_processes_9_0= ruleProcess ) ) )* otherlv_10= '}' )
            {
            // InternalReflex.g:79:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= ruleTact ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_globalVars_7_0= ruleGlobalVariable ) ) | ( (lv_registers_8_0= ruleRegister ) ) | ( (lv_processes_9_0= ruleProcess ) ) )* otherlv_10= '}' )
            // InternalReflex.g:80:3: otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= ruleTact ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_globalVars_7_0= ruleGlobalVariable ) ) | ( (lv_registers_8_0= ruleRegister ) ) | ( (lv_processes_9_0= ruleProcess ) ) )* otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,40,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProgramAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:106:3: ( (lv_ticks_3_0= ruleTact ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==71) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalReflex.g:107:4: (lv_ticks_3_0= ruleTact )
                    {
                    // InternalReflex.g:107:4: (lv_ticks_3_0= ruleTact )
                    // InternalReflex.g:108:5: lv_ticks_3_0= ruleTact
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getProgramAccess().getTicksTactParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_6);
                    lv_ticks_3_0=ruleTact();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getProgramRule());
                      					}
                      					set(
                      						current,
                      						"ticks",
                      						lv_ticks_3_0,
                      						"ru.iaie.reflex.Reflex.Tact");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:125:3: ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_globalVars_7_0= ruleGlobalVariable ) ) | ( (lv_registers_8_0= ruleRegister ) ) | ( (lv_processes_9_0= ruleProcess ) ) )*
            loop2:
            do {
                int alt2=7;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalReflex.g:126:4: ( (lv_consts_4_0= ruleConst ) )
            	    {
            	    // InternalReflex.g:126:4: ( (lv_consts_4_0= ruleConst ) )
            	    // InternalReflex.g:127:5: (lv_consts_4_0= ruleConst )
            	    {
            	    // InternalReflex.g:127:5: (lv_consts_4_0= ruleConst )
            	    // InternalReflex.g:128:6: lv_consts_4_0= ruleConst
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
            	    // InternalReflex.g:146:4: ( (lv_enums_5_0= ruleEnum ) )
            	    {
            	    // InternalReflex.g:146:4: ( (lv_enums_5_0= ruleEnum ) )
            	    // InternalReflex.g:147:5: (lv_enums_5_0= ruleEnum )
            	    {
            	    // InternalReflex.g:147:5: (lv_enums_5_0= ruleEnum )
            	    // InternalReflex.g:148:6: lv_enums_5_0= ruleEnum
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
            	    // InternalReflex.g:166:4: ( (lv_functions_6_0= ruleFunction ) )
            	    {
            	    // InternalReflex.g:166:4: ( (lv_functions_6_0= ruleFunction ) )
            	    // InternalReflex.g:167:5: (lv_functions_6_0= ruleFunction )
            	    {
            	    // InternalReflex.g:167:5: (lv_functions_6_0= ruleFunction )
            	    // InternalReflex.g:168:6: lv_functions_6_0= ruleFunction
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
            	    // InternalReflex.g:186:4: ( (lv_globalVars_7_0= ruleGlobalVariable ) )
            	    {
            	    // InternalReflex.g:186:4: ( (lv_globalVars_7_0= ruleGlobalVariable ) )
            	    // InternalReflex.g:187:5: (lv_globalVars_7_0= ruleGlobalVariable )
            	    {
            	    // InternalReflex.g:187:5: (lv_globalVars_7_0= ruleGlobalVariable )
            	    // InternalReflex.g:188:6: lv_globalVars_7_0= ruleGlobalVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getGlobalVarsGlobalVariableParserRuleCall_4_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_globalVars_7_0=ruleGlobalVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"globalVars",
            	      							lv_globalVars_7_0,
            	      							"ru.iaie.reflex.Reflex.GlobalVariable");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalReflex.g:206:4: ( (lv_registers_8_0= ruleRegister ) )
            	    {
            	    // InternalReflex.g:206:4: ( (lv_registers_8_0= ruleRegister ) )
            	    // InternalReflex.g:207:5: (lv_registers_8_0= ruleRegister )
            	    {
            	    // InternalReflex.g:207:5: (lv_registers_8_0= ruleRegister )
            	    // InternalReflex.g:208:6: lv_registers_8_0= ruleRegister
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getRegistersRegisterParserRuleCall_4_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_registers_8_0=ruleRegister();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"registers",
            	      							lv_registers_8_0,
            	      							"ru.iaie.reflex.Reflex.Register");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalReflex.g:226:4: ( (lv_processes_9_0= ruleProcess ) )
            	    {
            	    // InternalReflex.g:226:4: ( (lv_processes_9_0= ruleProcess ) )
            	    // InternalReflex.g:227:5: (lv_processes_9_0= ruleProcess )
            	    {
            	    // InternalReflex.g:227:5: (lv_processes_9_0= ruleProcess )
            	    // InternalReflex.g:228:6: lv_processes_9_0= ruleProcess
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getProcessesProcessParserRuleCall_4_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_processes_9_0=ruleProcess();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"processes",
            	      							lv_processes_9_0,
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

            otherlv_10=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getProgramAccess().getRightCurlyBracketKeyword_5());
              		
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
    // InternalReflex.g:254:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalReflex.g:254:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalReflex.g:255:2: iv_ruleProcess= ruleProcess EOF
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
    // InternalReflex.g:261:1: ruleProcess returns [EObject current=null] : ( (otherlv_0= '[' otherlv_1= 'annotation' otherlv_2= ']' )? otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_variables_7_0= ruleProcessVariable ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= '}' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token lv_looped_5_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_variables_7_0 = null;

        EObject lv_states_8_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:267:2: ( ( (otherlv_0= '[' otherlv_1= 'annotation' otherlv_2= ']' )? otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_variables_7_0= ruleProcessVariable ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= '}' ) )
            // InternalReflex.g:268:2: ( (otherlv_0= '[' otherlv_1= 'annotation' otherlv_2= ']' )? otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_variables_7_0= ruleProcessVariable ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= '}' )
            {
            // InternalReflex.g:268:2: ( (otherlv_0= '[' otherlv_1= 'annotation' otherlv_2= ']' )? otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_variables_7_0= ruleProcessVariable ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= '}' )
            // InternalReflex.g:269:3: (otherlv_0= '[' otherlv_1= 'annotation' otherlv_2= ']' )? otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_variables_7_0= ruleProcessVariable ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= '}'
            {
            // InternalReflex.g:269:3: (otherlv_0= '[' otherlv_1= 'annotation' otherlv_2= ']' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==42) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalReflex.g:270:4: otherlv_0= '[' otherlv_1= 'annotation' otherlv_2= ']'
                    {
                    otherlv_0=(Token)match(input,42,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    otherlv_1=(Token)match(input,43,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getProcessAccess().getAnnotationKeyword_0_1());
                      			
                    }
                    otherlv_2=(Token)match(input,44,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getRightSquareBracketKeyword_0_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_3=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getProcessAccess().getProcessKeyword_1());
              		
            }
            // InternalReflex.g:287:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalReflex.g:288:4: (lv_name_4_0= RULE_ID )
            {
            // InternalReflex.g:288:4: (lv_name_4_0= RULE_ID )
            // InternalReflex.g:289:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProcessRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:305:3: ( (lv_looped_5_0= 'looped' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==46) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalReflex.g:306:4: (lv_looped_5_0= 'looped' )
                    {
                    // InternalReflex.g:306:4: (lv_looped_5_0= 'looped' )
                    // InternalReflex.g:307:5: lv_looped_5_0= 'looped'
                    {
                    lv_looped_5_0=(Token)match(input,46,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_looped_5_0, grammarAccess.getProcessAccess().getLoopedLoopedKeyword_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getProcessRule());
                      					}
                      					setWithLastConsumed(current, "looped", true, "looped");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,40,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:323:3: ( (lv_variables_7_0= ruleProcessVariable ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=RULE_VOID_C_TYPE && LA5_0<=RULE_BOOL_TYPE)||LA5_0==49||(LA5_0>=102 && LA5_0<=103)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalReflex.g:324:4: (lv_variables_7_0= ruleProcessVariable )
            	    {
            	    // InternalReflex.g:324:4: (lv_variables_7_0= ruleProcessVariable )
            	    // InternalReflex.g:325:5: lv_variables_7_0= ruleProcessVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getVariablesProcessVariableParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_variables_7_0=ruleProcessVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"variables",
            	      						lv_variables_7_0,
            	      						"ru.iaie.reflex.Reflex.ProcessVariable");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalReflex.g:342:3: ( (lv_states_8_0= ruleState ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==47) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReflex.g:343:4: (lv_states_8_0= ruleState )
            	    {
            	    // InternalReflex.g:343:4: (lv_states_8_0= ruleState )
            	    // InternalReflex.g:344:5: lv_states_8_0= ruleState
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_6_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_states_8_0=ruleState();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"states",
            	      						lv_states_8_0,
            	      						"ru.iaie.reflex.Reflex.State");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_9=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_7());
              		
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


    // $ANTLR start "entryRuleState"
    // InternalReflex.g:369:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalReflex.g:369:46: (iv_ruleState= ruleState EOF )
            // InternalReflex.g:370:2: iv_ruleState= ruleState EOF
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
    // InternalReflex.g:376:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' ) ;
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
            // InternalReflex.g:382:2: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' ) )
            // InternalReflex.g:383:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' )
            {
            // InternalReflex.g:383:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' )
            // InternalReflex.g:384:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
              		
            }
            // InternalReflex.g:388:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:389:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:389:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:390:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,40,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:410:3: ( (lv_stateFunction_3_0= ruleStatementSequence ) )
            // InternalReflex.g:411:4: (lv_stateFunction_3_0= ruleStatementSequence )
            {
            // InternalReflex.g:411:4: (lv_stateFunction_3_0= ruleStatementSequence )
            // InternalReflex.g:412:5: lv_stateFunction_3_0= ruleStatementSequence
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStateAccess().getStateFunctionStatementSequenceParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_14);
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

            // InternalReflex.g:429:3: ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==52) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalReflex.g:430:4: (lv_timeoutFunction_4_0= ruleTimeoutFunction )
                    {
                    // InternalReflex.g:430:4: (lv_timeoutFunction_4_0= ruleTimeoutFunction )
                    // InternalReflex.g:431:5: lv_timeoutFunction_4_0= ruleTimeoutFunction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStateAccess().getTimeoutFunctionTimeoutFunctionParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_15);
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

            otherlv_5=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleProcessVariable"
    // InternalReflex.g:456:1: entryRuleProcessVariable returns [EObject current=null] : iv_ruleProcessVariable= ruleProcessVariable EOF ;
    public final EObject entryRuleProcessVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVariable = null;


        try {
            // InternalReflex.g:456:56: (iv_ruleProcessVariable= ruleProcessVariable EOF )
            // InternalReflex.g:457:2: iv_ruleProcessVariable= ruleProcessVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcessVariable=ruleProcessVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessVariable; 
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
    // $ANTLR end "entryRuleProcessVariable"


    // $ANTLR start "ruleProcessVariable"
    // InternalReflex.g:463:1: ruleProcessVariable returns [EObject current=null] : ( (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' ) ;
    public final EObject ruleProcessVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ImportedVariable_0 = null;

        EObject this_DeclaredVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:469:2: ( ( (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' ) )
            // InternalReflex.g:470:2: ( (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' )
            {
            // InternalReflex.g:470:2: ( (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' )
            // InternalReflex.g:471:3: (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';'
            {
            // InternalReflex.g:471:3: (this_ImportedVariable_0= ruleImportedVariable | this_DeclaredVariable_1= ruleDeclaredVariable )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==49) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=RULE_VOID_C_TYPE && LA8_0<=RULE_BOOL_TYPE)||(LA8_0>=102 && LA8_0<=103)) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalReflex.g:472:4: this_ImportedVariable_0= ruleImportedVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getProcessVariableAccess().getImportedVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_16);
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
                    // InternalReflex.g:481:4: this_DeclaredVariable_1= ruleDeclaredVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getProcessVariableAccess().getDeclaredVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_16);
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

            otherlv_2=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProcessVariableAccess().getSemicolonKeyword_1());
              		
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
    // $ANTLR end "ruleProcessVariable"


    // $ANTLR start "entryRuleImportedVariable"
    // InternalReflex.g:498:1: entryRuleImportedVariable returns [EObject current=null] : iv_ruleImportedVariable= ruleImportedVariable EOF ;
    public final EObject entryRuleImportedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedVariable = null;


        try {
            // InternalReflex.g:498:57: (iv_ruleImportedVariable= ruleImportedVariable EOF )
            // InternalReflex.g:499:2: iv_ruleImportedVariable= ruleImportedVariable EOF
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
    // InternalReflex.g:505:1: ruleImportedVariable returns [EObject current=null] : (otherlv_0= 'from' otherlv_1= 'process' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )* ) ;
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
            // InternalReflex.g:511:2: ( (otherlv_0= 'from' otherlv_1= 'process' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )* ) )
            // InternalReflex.g:512:2: (otherlv_0= 'from' otherlv_1= 'process' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )* )
            {
            // InternalReflex.g:512:2: (otherlv_0= 'from' otherlv_1= 'process' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )* )
            // InternalReflex.g:513:3: otherlv_0= 'from' otherlv_1= 'process' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,49,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportedVariableAccess().getFromKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getImportedVariableAccess().getProcessKeyword_1());
              		
            }
            // InternalReflex.g:521:3: ( (lv_procId_2_0= RULE_ID ) )
            // InternalReflex.g:522:4: (lv_procId_2_0= RULE_ID )
            {
            // InternalReflex.g:522:4: (lv_procId_2_0= RULE_ID )
            // InternalReflex.g:523:5: lv_procId_2_0= RULE_ID
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

            // InternalReflex.g:539:3: ( (lv_varNames_3_0= RULE_ID ) )
            // InternalReflex.g:540:4: (lv_varNames_3_0= RULE_ID )
            {
            // InternalReflex.g:540:4: (lv_varNames_3_0= RULE_ID )
            // InternalReflex.g:541:5: lv_varNames_3_0= RULE_ID
            {
            lv_varNames_3_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
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

            // InternalReflex.g:557:3: (otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==50) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalReflex.g:558:4: otherlv_4= ',' ( (lv_varNames_5_0= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getImportedVariableAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:562:4: ( (lv_varNames_5_0= RULE_ID ) )
            	    // InternalReflex.g:563:5: (lv_varNames_5_0= RULE_ID )
            	    {
            	    // InternalReflex.g:563:5: (lv_varNames_5_0= RULE_ID )
            	    // InternalReflex.g:564:6: lv_varNames_5_0= RULE_ID
            	    {
            	    lv_varNames_5_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
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
            	    break loop9;
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
    // InternalReflex.g:585:1: entryRuleDeclaredVariable returns [EObject current=null] : iv_ruleDeclaredVariable= ruleDeclaredVariable EOF ;
    public final EObject entryRuleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredVariable = null;


        try {
            // InternalReflex.g:585:57: (iv_ruleDeclaredVariable= ruleDeclaredVariable EOF )
            // InternalReflex.g:586:2: iv_ruleDeclaredVariable= ruleDeclaredVariable EOF
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
    // InternalReflex.g:592:1: ruleDeclaredVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) ) ;
    public final EObject ruleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;

        Enumerator lv_visibility_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:598:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) ) )
            // InternalReflex.g:599:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) )
            {
            // InternalReflex.g:599:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) )
            // InternalReflex.g:600:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) )
            {
            // InternalReflex.g:600:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt10=2;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==RULE_ID) ) {
                    int LA10_6 = input.LA(3);

                    if ( (LA10_6==51) ) {
                        alt10=1;
                    }
                    else if ( ((LA10_6>=72 && LA10_6<=73)) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT_C_TYPE:
                {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==RULE_ID) ) {
                    int LA10_6 = input.LA(3);

                    if ( (LA10_6==51) ) {
                        alt10=1;
                    }
                    else if ( ((LA10_6>=72 && LA10_6<=73)) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                int LA10_3 = input.LA(2);

                if ( (LA10_3==RULE_ID) ) {
                    int LA10_6 = input.LA(3);

                    if ( (LA10_6==51) ) {
                        alt10=1;
                    }
                    else if ( ((LA10_6>=72 && LA10_6<=73)) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                int LA10_4 = input.LA(2);

                if ( (LA10_4==RULE_ID) ) {
                    int LA10_6 = input.LA(3);

                    if ( (LA10_6==51) ) {
                        alt10=1;
                    }
                    else if ( ((LA10_6>=72 && LA10_6<=73)) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VOID_C_TYPE:
            case RULE_FLOAT_C_TYPE:
            case RULE_DOUBLE_C_TYPE:
            case 102:
            case 103:
                {
                alt10=2;
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
                    // InternalReflex.g:601:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_18);
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
                    // InternalReflex.g:610:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_18);
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

            // InternalReflex.g:619:3: ( (lv_visibility_2_0= ruleVisibility ) )
            // InternalReflex.g:620:4: (lv_visibility_2_0= ruleVisibility )
            {
            // InternalReflex.g:620:4: (lv_visibility_2_0= ruleVisibility )
            // InternalReflex.g:621:5: lv_visibility_2_0= ruleVisibility
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclaredVariableAccess().getVisibilityVisibilityEnumRuleCall_1_0());
              				
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


    // $ANTLR start "entryRuleGlobalVariable"
    // InternalReflex.g:642:1: entryRuleGlobalVariable returns [EObject current=null] : iv_ruleGlobalVariable= ruleGlobalVariable EOF ;
    public final EObject entryRuleGlobalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVariable = null;


        try {
            // InternalReflex.g:642:55: (iv_ruleGlobalVariable= ruleGlobalVariable EOF )
            // InternalReflex.g:643:2: iv_ruleGlobalVariable= ruleGlobalVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGlobalVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGlobalVariable=ruleGlobalVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGlobalVariable; 
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
    // $ANTLR end "entryRuleGlobalVariable"


    // $ANTLR start "ruleGlobalVariable"
    // InternalReflex.g:649:1: ruleGlobalVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' ) ;
    public final EObject ruleGlobalVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:655:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' ) )
            // InternalReflex.g:656:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' )
            {
            // InternalReflex.g:656:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' )
            // InternalReflex.g:657:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';'
            {
            // InternalReflex.g:657:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt11=2;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==RULE_ID) ) {
                    int LA11_6 = input.LA(3);

                    if ( (LA11_6==51) ) {
                        alt11=1;
                    }
                    else if ( (LA11_6==48) ) {
                        alt11=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT_C_TYPE:
                {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==RULE_ID) ) {
                    int LA11_6 = input.LA(3);

                    if ( (LA11_6==51) ) {
                        alt11=1;
                    }
                    else if ( (LA11_6==48) ) {
                        alt11=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                int LA11_3 = input.LA(2);

                if ( (LA11_3==RULE_ID) ) {
                    int LA11_6 = input.LA(3);

                    if ( (LA11_6==51) ) {
                        alt11=1;
                    }
                    else if ( (LA11_6==48) ) {
                        alt11=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                int LA11_4 = input.LA(2);

                if ( (LA11_4==RULE_ID) ) {
                    int LA11_6 = input.LA(3);

                    if ( (LA11_6==51) ) {
                        alt11=1;
                    }
                    else if ( (LA11_6==48) ) {
                        alt11=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VOID_C_TYPE:
            case RULE_FLOAT_C_TYPE:
            case RULE_DOUBLE_C_TYPE:
            case 102:
            case 103:
                {
                alt11=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalReflex.g:658:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getGlobalVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_16);
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
                    // InternalReflex.g:667:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getGlobalVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_16);
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

            otherlv_2=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getGlobalVariableAccess().getSemicolonKeyword_1());
              		
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
    // $ANTLR end "ruleGlobalVariable"


    // $ANTLR start "entryRulePhysicalVariable"
    // InternalReflex.g:684:1: entryRulePhysicalVariable returns [EObject current=null] : iv_rulePhysicalVariable= rulePhysicalVariable EOF ;
    public final EObject entryRulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalVariable = null;


        try {
            // InternalReflex.g:684:57: (iv_rulePhysicalVariable= rulePhysicalVariable EOF )
            // InternalReflex.g:685:2: iv_rulePhysicalVariable= rulePhysicalVariable EOF
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
    // InternalReflex.g:691:1: rulePhysicalVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) ) ) ;
    public final EObject rulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_port_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:697:2: ( ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) ) ) )
            // InternalReflex.g:698:2: ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) ) )
            {
            // InternalReflex.g:698:2: ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) ) )
            // InternalReflex.g:699:3: ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) )
            {
            // InternalReflex.g:699:3: ( (lv_type_0_0= ruleIntegerType ) )
            // InternalReflex.g:700:4: (lv_type_0_0= ruleIntegerType )
            {
            // InternalReflex.g:700:4: (lv_type_0_0= ruleIntegerType )
            // InternalReflex.g:701:5: lv_type_0_0= ruleIntegerType
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

            // InternalReflex.g:718:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:719:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:719:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:720:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPhysicalVariableAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalReflex.g:740:3: ( (lv_port_3_0= ruleRegisterPortMapping ) )
            // InternalReflex.g:741:4: (lv_port_3_0= ruleRegisterPortMapping )
            {
            // InternalReflex.g:741:4: (lv_port_3_0= ruleRegisterPortMapping )
            // InternalReflex.g:742:5: lv_port_3_0= ruleRegisterPortMapping
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getPortRegisterPortMappingParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_port_3_0=ruleRegisterPortMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					set(
              						current,
              						"port",
              						lv_port_3_0,
              						"ru.iaie.reflex.Reflex.RegisterPortMapping");
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
    // $ANTLR end "rulePhysicalVariable"


    // $ANTLR start "entryRuleRegisterPortMapping"
    // InternalReflex.g:763:1: entryRuleRegisterPortMapping returns [EObject current=null] : iv_ruleRegisterPortMapping= ruleRegisterPortMapping EOF ;
    public final EObject entryRuleRegisterPortMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegisterPortMapping = null;


        try {
            // InternalReflex.g:763:60: (iv_ruleRegisterPortMapping= ruleRegisterPortMapping EOF )
            // InternalReflex.g:764:2: iv_ruleRegisterPortMapping= ruleRegisterPortMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterPortMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegisterPortMapping=ruleRegisterPortMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegisterPortMapping; 
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
    // $ANTLR end "entryRuleRegisterPortMapping"


    // $ANTLR start "ruleRegisterPortMapping"
    // InternalReflex.g:770:1: ruleRegisterPortMapping returns [EObject current=null] : ( ( (lv_regName_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )? ) ;
    public final EObject ruleRegisterPortMapping() throws RecognitionException {
        EObject current = null;

        Token lv_regName_0_0=null;
        Token otherlv_1=null;
        Token lv_portBit_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:776:2: ( ( ( (lv_regName_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )? ) )
            // InternalReflex.g:777:2: ( ( (lv_regName_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )? )
            {
            // InternalReflex.g:777:2: ( ( (lv_regName_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )? )
            // InternalReflex.g:778:3: ( (lv_regName_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )?
            {
            // InternalReflex.g:778:3: ( (lv_regName_0_0= RULE_ID ) )
            // InternalReflex.g:779:4: (lv_regName_0_0= RULE_ID )
            {
            // InternalReflex.g:779:4: (lv_regName_0_0= RULE_ID )
            // InternalReflex.g:780:5: lv_regName_0_0= RULE_ID
            {
            lv_regName_0_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_regName_0_0, grammarAccess.getRegisterPortMappingAccess().getRegNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterPortMappingRule());
              					}
              					setWithLastConsumed(
              						current,
              						"regName",
              						lv_regName_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:796:3: (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==42) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalReflex.g:797:4: otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,42,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getRegisterPortMappingAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:801:4: ( (lv_portBit_2_0= RULE_INTEGER ) )
                    // InternalReflex.g:802:5: (lv_portBit_2_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:802:5: (lv_portBit_2_0= RULE_INTEGER )
                    // InternalReflex.g:803:6: lv_portBit_2_0= RULE_INTEGER
                    {
                    lv_portBit_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_portBit_2_0, grammarAccess.getRegisterPortMappingAccess().getPortBitINTEGERTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRegisterPortMappingRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"portBit",
                      							lv_portBit_2_0,
                      							"ru.iaie.reflex.Reflex.INTEGER");
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getRegisterPortMappingAccess().getRightSquareBracketKeyword_1_2());
                      			
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
    // $ANTLR end "ruleRegisterPortMapping"


    // $ANTLR start "entryRuleProgramVariable"
    // InternalReflex.g:828:1: entryRuleProgramVariable returns [EObject current=null] : iv_ruleProgramVariable= ruleProgramVariable EOF ;
    public final EObject entryRuleProgramVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramVariable = null;


        try {
            // InternalReflex.g:828:56: (iv_ruleProgramVariable= ruleProgramVariable EOF )
            // InternalReflex.g:829:2: iv_ruleProgramVariable= ruleProgramVariable EOF
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
    // InternalReflex.g:835:1: ruleProgramVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProgramVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:841:2: ( ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:842:2: ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:842:2: ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalReflex.g:843:3: ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalReflex.g:843:3: ( (lv_type_0_0= ruleReflexType ) )
            // InternalReflex.g:844:4: (lv_type_0_0= ruleReflexType )
            {
            // InternalReflex.g:844:4: (lv_type_0_0= ruleReflexType )
            // InternalReflex.g:845:5: lv_type_0_0= ruleReflexType
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

            // InternalReflex.g:862:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:863:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:863:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:864:5: lv_name_1_0= RULE_ID
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


    // $ANTLR start "entryRuleStatementSequence"
    // InternalReflex.g:884:1: entryRuleStatementSequence returns [EObject current=null] : iv_ruleStatementSequence= ruleStatementSequence EOF ;
    public final EObject entryRuleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementSequence = null;


        try {
            // InternalReflex.g:884:58: (iv_ruleStatementSequence= ruleStatementSequence EOF )
            // InternalReflex.g:885:2: iv_ruleStatementSequence= ruleStatementSequence EOF
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
    // InternalReflex.g:891:1: ruleStatementSequence returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:897:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalReflex.g:898:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalReflex.g:898:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalReflex.g:899:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalReflex.g:899:3: ()
            // InternalReflex.g:900:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStatementSequenceAccess().getStatementSequenceAction_0(),
              					current);
              			
            }

            }

            // InternalReflex.g:906:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_FLOAT)||LA13_0==40||LA13_0==48||(LA13_0>=53 && LA13_0<=54)||LA13_0==57||(LA13_0>=61 && LA13_0<=65)||LA13_0==67||(LA13_0>=76 && LA13_0<=77)||(LA13_0>=87 && LA13_0<=90)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalReflex.g:907:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalReflex.g:907:4: (lv_statements_1_0= ruleStatement )
            	    // InternalReflex.g:908:5: lv_statements_1_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStatementSequenceAccess().getStatementsStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_22);
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
            	    break loop13;
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
    // InternalReflex.g:929:1: entryRuleStatementBlock returns [EObject current=null] : iv_ruleStatementBlock= ruleStatementBlock EOF ;
    public final EObject entryRuleStatementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementBlock = null;


        try {
            // InternalReflex.g:929:55: (iv_ruleStatementBlock= ruleStatementBlock EOF )
            // InternalReflex.g:930:2: iv_ruleStatementBlock= ruleStatementBlock EOF
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
    // InternalReflex.g:936:1: ruleStatementBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleStatementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:942:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // InternalReflex.g:943:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // InternalReflex.g:943:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // InternalReflex.g:944:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // InternalReflex.g:944:3: ()
            // InternalReflex.g:945:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStatementBlockAccess().getStatementBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,40,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStatementBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalReflex.g:955:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_ID && LA14_0<=RULE_FLOAT)||LA14_0==40||LA14_0==48||(LA14_0>=53 && LA14_0<=54)||LA14_0==57||(LA14_0>=61 && LA14_0<=65)||LA14_0==67||(LA14_0>=76 && LA14_0<=77)||(LA14_0>=87 && LA14_0<=90)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalReflex.g:956:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalReflex.g:956:4: (lv_statements_2_0= ruleStatement )
            	    // InternalReflex.g:957:5: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStatementBlockAccess().getStatementsStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_23);
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
            	    break loop14;
                }
            } while (true);

            otherlv_3=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:982:1: entryRuleTimeoutFunction returns [EObject current=null] : iv_ruleTimeoutFunction= ruleTimeoutFunction EOF ;
    public final EObject entryRuleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutFunction = null;


        try {
            // InternalReflex.g:982:56: (iv_ruleTimeoutFunction= ruleTimeoutFunction EOF )
            // InternalReflex.g:983:2: iv_ruleTimeoutFunction= ruleTimeoutFunction EOF
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
    // InternalReflex.g:989:1: ruleTimeoutFunction returns [EObject current=null] : (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) ) ;
    public final EObject ruleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_time_1_0 = null;

        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:995:2: ( (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) ) )
            // InternalReflex.g:996:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) )
            {
            // InternalReflex.g:996:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) )
            // InternalReflex.g:997:3: otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTimeoutFunctionAccess().getTimeoutKeyword_0());
              		
            }
            // InternalReflex.g:1001:3: ( (lv_time_1_0= ruleTime ) )
            // InternalReflex.g:1002:4: (lv_time_1_0= ruleTime )
            {
            // InternalReflex.g:1002:4: (lv_time_1_0= ruleTime )
            // InternalReflex.g:1003:5: lv_time_1_0= ruleTime
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

            // InternalReflex.g:1020:3: ( (lv_body_2_0= ruleStatement ) )
            // InternalReflex.g:1021:4: (lv_body_2_0= ruleStatement )
            {
            // InternalReflex.g:1021:4: (lv_body_2_0= ruleStatement )
            // InternalReflex.g:1022:5: lv_body_2_0= ruleStatement
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
    // InternalReflex.g:1043:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalReflex.g:1043:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalReflex.g:1044:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalReflex.g:1050:1: ruleStatement returns [EObject current=null] : ( ( () otherlv_1= ';' ) | this_StatementBlock_2= ruleStatementBlock | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_12=null;
        EObject this_StatementBlock_2 = null;

        EObject this_StartProcStat_3 = null;

        EObject this_StopProcStat_4 = null;

        EObject this_ErrorStat_5 = null;

        EObject this_RestartStat_6 = null;

        EObject this_ResetStat_7 = null;

        EObject this_SetStateStat_8 = null;

        EObject this_IfElseStat_9 = null;

        EObject this_SwitchStat_10 = null;

        EObject this_Expression_11 = null;



        	enterRule();

        try {
            // InternalReflex.g:1056:2: ( ( ( () otherlv_1= ';' ) | this_StatementBlock_2= ruleStatementBlock | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) ) )
            // InternalReflex.g:1057:2: ( ( () otherlv_1= ';' ) | this_StatementBlock_2= ruleStatementBlock | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) )
            {
            // InternalReflex.g:1057:2: ( ( () otherlv_1= ';' ) | this_StatementBlock_2= ruleStatementBlock | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) )
            int alt15=11;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt15=1;
                }
                break;
            case 40:
                {
                alt15=2;
                }
                break;
            case 61:
                {
                alt15=3;
                }
                break;
            case 62:
                {
                alt15=4;
                }
                break;
            case 63:
                {
                alt15=5;
                }
                break;
            case 64:
                {
                alt15=6;
                }
                break;
            case 65:
                {
                alt15=7;
                }
                break;
            case 67:
                {
                alt15=8;
                }
                break;
            case 53:
                {
                alt15=9;
                }
                break;
            case 57:
                {
                alt15=10;
                }
                break;
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case 54:
            case 76:
            case 77:
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt15=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalReflex.g:1058:3: ( () otherlv_1= ';' )
                    {
                    // InternalReflex.g:1058:3: ( () otherlv_1= ';' )
                    // InternalReflex.g:1059:4: () otherlv_1= ';'
                    {
                    // InternalReflex.g:1059:4: ()
                    // InternalReflex.g:1060:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getStatementAccess().getStatementAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1072:3: this_StatementBlock_2= ruleStatementBlock
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
                    // InternalReflex.g:1081:3: this_StartProcStat_3= ruleStartProcStat
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
                    // InternalReflex.g:1090:3: this_StopProcStat_4= ruleStopProcStat
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
                    // InternalReflex.g:1099:3: this_ErrorStat_5= ruleErrorStat
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
                    // InternalReflex.g:1108:3: this_RestartStat_6= ruleRestartStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getRestartStatParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RestartStat_6=ruleRestartStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RestartStat_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalReflex.g:1117:3: this_ResetStat_7= ruleResetStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getResetStatParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ResetStat_7=ruleResetStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ResetStat_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalReflex.g:1126:3: this_SetStateStat_8= ruleSetStateStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSetStateStatParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SetStateStat_8=ruleSetStateStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetStateStat_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalReflex.g:1135:3: this_IfElseStat_9= ruleIfElseStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getIfElseStatParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfElseStat_9=ruleIfElseStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfElseStat_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalReflex.g:1144:3: this_SwitchStat_10= ruleSwitchStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSwitchStatParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SwitchStat_10=ruleSwitchStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SwitchStat_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalReflex.g:1153:3: (this_Expression_11= ruleExpression otherlv_12= ';' )
                    {
                    // InternalReflex.g:1153:3: (this_Expression_11= ruleExpression otherlv_12= ';' )
                    // InternalReflex.g:1154:4: this_Expression_11= ruleExpression otherlv_12= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStatementAccess().getExpressionParserRuleCall_10_0());
                      			
                    }
                    pushFollow(FOLLOW_16);
                    this_Expression_11=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_11;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_12=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getStatementAccess().getSemicolonKeyword_10_1());
                      			
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
    // InternalReflex.g:1171:1: entryRuleIfElseStat returns [EObject current=null] : iv_ruleIfElseStat= ruleIfElseStat EOF ;
    public final EObject entryRuleIfElseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfElseStat = null;


        try {
            // InternalReflex.g:1171:51: (iv_ruleIfElseStat= ruleIfElseStat EOF )
            // InternalReflex.g:1172:2: iv_ruleIfElseStat= ruleIfElseStat EOF
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
    // InternalReflex.g:1178:1: ruleIfElseStat returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) ;
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
            // InternalReflex.g:1184:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) )
            // InternalReflex.g:1185:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            {
            // InternalReflex.g:1185:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            // InternalReflex.g:1186:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,53,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfElseStatAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,54,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfElseStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1194:3: ( (lv_cond_2_0= ruleExpression ) )
            // InternalReflex.g:1195:4: (lv_cond_2_0= ruleExpression )
            {
            // InternalReflex.g:1195:4: (lv_cond_2_0= ruleExpression )
            // InternalReflex.g:1196:5: lv_cond_2_0= ruleExpression
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

            otherlv_3=(Token)match(input,55,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfElseStatAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalReflex.g:1217:3: ( (lv_then_4_0= ruleStatement ) )
            // InternalReflex.g:1218:4: (lv_then_4_0= ruleStatement )
            {
            // InternalReflex.g:1218:4: (lv_then_4_0= ruleStatement )
            // InternalReflex.g:1219:5: lv_then_4_0= ruleStatement
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

            // InternalReflex.g:1236:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==56) ) {
                int LA16_1 = input.LA(2);

                if ( (synpred1_InternalReflex()) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // InternalReflex.g:1237:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) )
                    {
                    // InternalReflex.g:1237:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalReflex.g:1238:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,56,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfElseStatAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalReflex.g:1244:4: ( (lv_else_6_0= ruleStatement ) )
                    // InternalReflex.g:1245:5: (lv_else_6_0= ruleStatement )
                    {
                    // InternalReflex.g:1245:5: (lv_else_6_0= ruleStatement )
                    // InternalReflex.g:1246:6: lv_else_6_0= ruleStatement
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
    // InternalReflex.g:1268:1: entryRuleSwitchStat returns [EObject current=null] : iv_ruleSwitchStat= ruleSwitchStat EOF ;
    public final EObject entryRuleSwitchStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStat = null;


        try {
            // InternalReflex.g:1268:51: (iv_ruleSwitchStat= ruleSwitchStat EOF )
            // InternalReflex.g:1269:2: iv_ruleSwitchStat= ruleSwitchStat EOF
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
    // InternalReflex.g:1275:1: ruleSwitchStat returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) ;
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
            // InternalReflex.g:1281:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) )
            // InternalReflex.g:1282:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:1282:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            // InternalReflex.g:1283:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,54,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1291:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalReflex.g:1292:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalReflex.g:1292:4: (lv_expr_2_0= ruleExpression )
            // InternalReflex.g:1293:5: lv_expr_2_0= ruleExpression
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

            otherlv_3=(Token)match(input,55,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,40,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:1318:3: ( (lv_options_5_0= ruleCaseStat ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==58) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalReflex.g:1319:4: (lv_options_5_0= ruleCaseStat )
            	    {
            	    // InternalReflex.g:1319:4: (lv_options_5_0= ruleCaseStat )
            	    // InternalReflex.g:1320:5: lv_options_5_0= ruleCaseStat
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
            	    break loop17;
                }
            } while (true);

            otherlv_6=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1345:1: entryRuleCaseStat returns [EObject current=null] : iv_ruleCaseStat= ruleCaseStat EOF ;
    public final EObject entryRuleCaseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStat = null;


        try {
            // InternalReflex.g:1345:49: (iv_ruleCaseStat= ruleCaseStat EOF )
            // InternalReflex.g:1346:2: iv_ruleCaseStat= ruleCaseStat EOF
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
    // InternalReflex.g:1352:1: ruleCaseStat returns [EObject current=null] : (otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' ) ;
    public final EObject ruleCaseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_option_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_body_3_0 = null;

        AntlrDatatypeRuleToken lv_hasBreak_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1358:2: ( (otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' ) )
            // InternalReflex.g:1359:2: (otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' )
            {
            // InternalReflex.g:1359:2: (otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' )
            // InternalReflex.g:1360:3: otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCaseStatAccess().getCaseKeyword_0());
              		
            }
            // InternalReflex.g:1364:3: ( (lv_option_1_0= RULE_INTEGER ) )
            // InternalReflex.g:1365:4: (lv_option_1_0= RULE_INTEGER )
            {
            // InternalReflex.g:1365:4: (lv_option_1_0= RULE_INTEGER )
            // InternalReflex.g:1366:5: lv_option_1_0= RULE_INTEGER
            {
            lv_option_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_option_1_0, grammarAccess.getCaseStatAccess().getOptionINTEGERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCaseStatRule());
              					}
              					setWithLastConsumed(
              						current,
              						"option",
              						lv_option_1_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,59,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCaseStatAccess().getColonKeyword_2());
              		
            }
            // InternalReflex.g:1386:3: ( (lv_body_3_0= ruleStatementSequence ) )
            // InternalReflex.g:1387:4: (lv_body_3_0= ruleStatementSequence )
            {
            // InternalReflex.g:1387:4: (lv_body_3_0= ruleStatementSequence )
            // InternalReflex.g:1388:5: lv_body_3_0= ruleStatementSequence
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

            // InternalReflex.g:1405:3: ( (lv_hasBreak_4_0= ruleBreakStat ) )
            // InternalReflex.g:1406:4: (lv_hasBreak_4_0= ruleBreakStat )
            {
            // InternalReflex.g:1406:4: (lv_hasBreak_4_0= ruleBreakStat )
            // InternalReflex.g:1407:5: lv_hasBreak_4_0= ruleBreakStat
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getHasBreakBreakStatParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_15);
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

            otherlv_5=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1432:1: entryRuleBreakStat returns [String current=null] : iv_ruleBreakStat= ruleBreakStat EOF ;
    public final String entryRuleBreakStat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBreakStat = null;


        try {
            // InternalReflex.g:1432:49: (iv_ruleBreakStat= ruleBreakStat EOF )
            // InternalReflex.g:1433:2: iv_ruleBreakStat= ruleBreakStat EOF
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
    // InternalReflex.g:1439:1: ruleBreakStat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'break' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleBreakStat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalReflex.g:1445:2: ( (kw= 'break' kw= ';' ) )
            // InternalReflex.g:1446:2: (kw= 'break' kw= ';' )
            {
            // InternalReflex.g:1446:2: (kw= 'break' kw= ';' )
            // InternalReflex.g:1447:3: kw= 'break' kw= ';'
            {
            kw=(Token)match(input,60,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getBreakStatAccess().getBreakKeyword_0());
              		
            }
            kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1461:1: entryRuleStartProcStat returns [EObject current=null] : iv_ruleStartProcStat= ruleStartProcStat EOF ;
    public final EObject entryRuleStartProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcStat = null;


        try {
            // InternalReflex.g:1461:54: (iv_ruleStartProcStat= ruleStartProcStat EOF )
            // InternalReflex.g:1462:2: iv_ruleStartProcStat= ruleStartProcStat EOF
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
    // InternalReflex.g:1468:1: ruleStartProcStat returns [EObject current=null] : (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleStartProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_procId_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1474:2: ( (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalReflex.g:1475:2: (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalReflex.g:1475:2: (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalReflex.g:1476:3: otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStartProcStatAccess().getStartKeyword_0());
              		
            }
            // InternalReflex.g:1480:3: ( (lv_procId_1_0= RULE_ID ) )
            // InternalReflex.g:1481:4: (lv_procId_1_0= RULE_ID )
            {
            // InternalReflex.g:1481:4: (lv_procId_1_0= RULE_ID )
            // InternalReflex.g:1482:5: lv_procId_1_0= RULE_ID
            {
            lv_procId_1_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1506:1: entryRuleStopProcStat returns [EObject current=null] : iv_ruleStopProcStat= ruleStopProcStat EOF ;
    public final EObject entryRuleStopProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcStat = null;


        try {
            // InternalReflex.g:1506:53: (iv_ruleStopProcStat= ruleStopProcStat EOF )
            // InternalReflex.g:1507:2: iv_ruleStopProcStat= ruleStopProcStat EOF
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
    // InternalReflex.g:1513:1: ruleStopProcStat returns [EObject current=null] : ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) ;
    public final EObject ruleStopProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1519:2: ( ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) )
            // InternalReflex.g:1520:2: ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            {
            // InternalReflex.g:1520:2: ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            // InternalReflex.g:1521:3: () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';'
            {
            // InternalReflex.g:1521:3: ()
            // InternalReflex.g:1522:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStopProcStatAccess().getStopProcStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStopProcStatAccess().getStopKeyword_1());
              		
            }
            // InternalReflex.g:1532:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalReflex.g:1533:4: (lv_procId_2_0= RULE_ID )
                    {
                    // InternalReflex.g:1533:4: (lv_procId_2_0= RULE_ID )
                    // InternalReflex.g:1534:5: lv_procId_2_0= RULE_ID
                    {
                    lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1558:1: entryRuleErrorStat returns [EObject current=null] : iv_ruleErrorStat= ruleErrorStat EOF ;
    public final EObject entryRuleErrorStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorStat = null;


        try {
            // InternalReflex.g:1558:50: (iv_ruleErrorStat= ruleErrorStat EOF )
            // InternalReflex.g:1559:2: iv_ruleErrorStat= ruleErrorStat EOF
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
    // InternalReflex.g:1565:1: ruleErrorStat returns [EObject current=null] : ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) ;
    public final EObject ruleErrorStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1571:2: ( ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) )
            // InternalReflex.g:1572:2: ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            {
            // InternalReflex.g:1572:2: ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            // InternalReflex.g:1573:3: () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';'
            {
            // InternalReflex.g:1573:3: ()
            // InternalReflex.g:1574:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getErrorStatAccess().getErrorStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getErrorStatAccess().getErrorKeyword_1());
              		
            }
            // InternalReflex.g:1584:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalReflex.g:1585:4: (lv_procId_2_0= RULE_ID )
                    {
                    // InternalReflex.g:1585:4: (lv_procId_2_0= RULE_ID )
                    // InternalReflex.g:1586:5: lv_procId_2_0= RULE_ID
                    {
                    lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleRestartStat"
    // InternalReflex.g:1610:1: entryRuleRestartStat returns [EObject current=null] : iv_ruleRestartStat= ruleRestartStat EOF ;
    public final EObject entryRuleRestartStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestartStat = null;


        try {
            // InternalReflex.g:1610:52: (iv_ruleRestartStat= ruleRestartStat EOF )
            // InternalReflex.g:1611:2: iv_ruleRestartStat= ruleRestartStat EOF
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
    // InternalReflex.g:1617:1: ruleRestartStat returns [EObject current=null] : ( () otherlv_1= 'restart' otherlv_2= ';' ) ;
    public final EObject ruleRestartStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1623:2: ( ( () otherlv_1= 'restart' otherlv_2= ';' ) )
            // InternalReflex.g:1624:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            {
            // InternalReflex.g:1624:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            // InternalReflex.g:1625:3: () otherlv_1= 'restart' otherlv_2= ';'
            {
            // InternalReflex.g:1625:3: ()
            // InternalReflex.g:1626:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRestartStatAccess().getRestartStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,64,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRestartStatAccess().getRestartKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1644:1: entryRuleResetStat returns [EObject current=null] : iv_ruleResetStat= ruleResetStat EOF ;
    public final EObject entryRuleResetStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetStat = null;


        try {
            // InternalReflex.g:1644:50: (iv_ruleResetStat= ruleResetStat EOF )
            // InternalReflex.g:1645:2: iv_ruleResetStat= ruleResetStat EOF
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
    // InternalReflex.g:1651:1: ruleResetStat returns [EObject current=null] : ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' ) ;
    public final EObject ruleResetStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1657:2: ( ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' ) )
            // InternalReflex.g:1658:2: ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' )
            {
            // InternalReflex.g:1658:2: ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' )
            // InternalReflex.g:1659:3: () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';'
            {
            // InternalReflex.g:1659:3: ()
            // InternalReflex.g:1660:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getResetStatAccess().getResetStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getResetStatAccess().getResetKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,66,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getResetStatAccess().getTimerKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1682:1: entryRuleSetStateStat returns [EObject current=null] : iv_ruleSetStateStat= ruleSetStateStat EOF ;
    public final EObject entryRuleSetStateStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStat = null;


        try {
            // InternalReflex.g:1682:53: (iv_ruleSetStateStat= ruleSetStateStat EOF )
            // InternalReflex.g:1683:2: iv_ruleSetStateStat= ruleSetStateStat EOF
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
    // InternalReflex.g:1689:1: ruleSetStateStat returns [EObject current=null] : ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' ) ;
    public final EObject ruleSetStateStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_stateId_3_0=null;
        Token lv_next_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalReflex.g:1695:2: ( ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1696:2: ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1696:2: ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' )
            // InternalReflex.g:1697:3: () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';'
            {
            // InternalReflex.g:1697:3: ()
            // InternalReflex.g:1698:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetStateStatAccess().getSetStateStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetStateStatAccess().getSetKeyword_1());
              		
            }
            // InternalReflex.g:1708:3: ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==47) ) {
                alt20=1;
            }
            else if ( (LA20_0==68) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalReflex.g:1709:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    {
                    // InternalReflex.g:1709:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    // InternalReflex.g:1710:5: otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getSetStateStatAccess().getStateKeyword_2_0_0());
                      				
                    }
                    // InternalReflex.g:1714:5: ( (lv_stateId_3_0= RULE_ID ) )
                    // InternalReflex.g:1715:6: (lv_stateId_3_0= RULE_ID )
                    {
                    // InternalReflex.g:1715:6: (lv_stateId_3_0= RULE_ID )
                    // InternalReflex.g:1716:7: lv_stateId_3_0= RULE_ID
                    {
                    lv_stateId_3_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
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
                    // InternalReflex.g:1734:4: ( (lv_next_4_0= 'next' ) )
                    {
                    // InternalReflex.g:1734:4: ( (lv_next_4_0= 'next' ) )
                    // InternalReflex.g:1735:5: (lv_next_4_0= 'next' )
                    {
                    // InternalReflex.g:1735:5: (lv_next_4_0= 'next' )
                    // InternalReflex.g:1736:6: lv_next_4_0= 'next'
                    {
                    lv_next_4_0=(Token)match(input,68,FOLLOW_16); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1757:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalReflex.g:1757:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalReflex.g:1758:2: iv_ruleFunction= ruleFunction EOF
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
    // InternalReflex.g:1764:1: ruleFunction returns [EObject current=null] : ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' ) ;
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
            // InternalReflex.g:1770:2: ( ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' ) )
            // InternalReflex.g:1771:2: ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            {
            // InternalReflex.g:1771:2: ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            // InternalReflex.g:1772:3: ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';'
            {
            // InternalReflex.g:1772:3: ( (lv_returnType_0_0= ruleCType ) )
            // InternalReflex.g:1773:4: (lv_returnType_0_0= ruleCType )
            {
            // InternalReflex.g:1773:4: (lv_returnType_0_0= ruleCType )
            // InternalReflex.g:1774:5: lv_returnType_0_0= ruleCType
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

            // InternalReflex.g:1791:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1792:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1792:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1793:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,54,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalReflex.g:1813:3: ( (lv_argTypes_3_0= ruleCType ) )
            // InternalReflex.g:1814:4: (lv_argTypes_3_0= ruleCType )
            {
            // InternalReflex.g:1814:4: (lv_argTypes_3_0= ruleCType )
            // InternalReflex.g:1815:5: lv_argTypes_3_0= ruleCType
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

            // InternalReflex.g:1832:3: (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==50) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalReflex.g:1833:4: otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) )
            	    {
            	    otherlv_4=(Token)match(input,50,FOLLOW_34); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:1837:4: ( (lv_argTypes_5_0= ruleCType ) )
            	    // InternalReflex.g:1838:5: (lv_argTypes_5_0= ruleCType )
            	    {
            	    // InternalReflex.g:1838:5: (lv_argTypes_5_0= ruleCType )
            	    // InternalReflex.g:1839:6: lv_argTypes_5_0= ruleCType
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
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,55,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_7=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1869:1: entryRuleRegister returns [EObject current=null] : iv_ruleRegister= ruleRegister EOF ;
    public final EObject entryRuleRegister() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegister = null;


        try {
            // InternalReflex.g:1869:49: (iv_ruleRegister= ruleRegister EOF )
            // InternalReflex.g:1870:2: iv_ruleRegister= ruleRegister EOF
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
    // InternalReflex.g:1876:1: ruleRegister returns [EObject current=null] : ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';' ) ;
    public final EObject ruleRegister() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_addr1_2_0=null;
        Token lv_addr2_3_0=null;
        Token lv_regSize_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1882:2: ( ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1883:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1883:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';' )
            // InternalReflex.g:1884:3: ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';'
            {
            // InternalReflex.g:1884:3: ( (lv_type_0_0= ruleRegisterType ) )
            // InternalReflex.g:1885:4: (lv_type_0_0= ruleRegisterType )
            {
            // InternalReflex.g:1885:4: (lv_type_0_0= ruleRegisterType )
            // InternalReflex.g:1886:5: lv_type_0_0= ruleRegisterType
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

            // InternalReflex.g:1903:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1904:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1904:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1905:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
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

            // InternalReflex.g:1921:3: ( (lv_addr1_2_0= RULE_INTEGER ) )
            // InternalReflex.g:1922:4: (lv_addr1_2_0= RULE_INTEGER )
            {
            // InternalReflex.g:1922:4: (lv_addr1_2_0= RULE_INTEGER )
            // InternalReflex.g:1923:5: lv_addr1_2_0= RULE_INTEGER
            {
            lv_addr1_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_addr1_2_0, grammarAccess.getRegisterAccess().getAddr1INTEGERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"addr1",
              						lv_addr1_2_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            // InternalReflex.g:1939:3: ( (lv_addr2_3_0= RULE_INTEGER ) )
            // InternalReflex.g:1940:4: (lv_addr2_3_0= RULE_INTEGER )
            {
            // InternalReflex.g:1940:4: (lv_addr2_3_0= RULE_INTEGER )
            // InternalReflex.g:1941:5: lv_addr2_3_0= RULE_INTEGER
            {
            lv_addr2_3_0=(Token)match(input,RULE_INTEGER,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_addr2_3_0, grammarAccess.getRegisterAccess().getAddr2INTEGERTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"addr2",
              						lv_addr2_3_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            // InternalReflex.g:1957:3: ( (lv_regSize_4_0= RULE_INTEGER ) )
            // InternalReflex.g:1958:4: (lv_regSize_4_0= RULE_INTEGER )
            {
            // InternalReflex.g:1958:4: (lv_regSize_4_0= RULE_INTEGER )
            // InternalReflex.g:1959:5: lv_regSize_4_0= RULE_INTEGER
            {
            lv_regSize_4_0=(Token)match(input,RULE_INTEGER,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_regSize_4_0, grammarAccess.getRegisterAccess().getRegSizeINTEGERTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"regSize",
              						lv_regSize_4_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1983:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalReflex.g:1983:46: (iv_ruleConst= ruleConst EOF )
            // InternalReflex.g:1984:2: iv_ruleConst= ruleConst EOF
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
    // InternalReflex.g:1990:1: ruleConst returns [EObject current=null] : (otherlv_0= 'const' ( (lv_type_1_0= ruleReflexType ) ) ( (lv_constId_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constId_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        EObject lv_constValue_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1996:2: ( (otherlv_0= 'const' ( (lv_type_1_0= ruleReflexType ) ) ( (lv_constId_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1997:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleReflexType ) ) ( (lv_constId_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1997:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleReflexType ) ) ( (lv_constId_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalReflex.g:1998:3: otherlv_0= 'const' ( (lv_type_1_0= ruleReflexType ) ) ( (lv_constId_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstAccess().getConstKeyword_0());
              		
            }
            // InternalReflex.g:2002:3: ( (lv_type_1_0= ruleReflexType ) )
            // InternalReflex.g:2003:4: (lv_type_1_0= ruleReflexType )
            {
            // InternalReflex.g:2003:4: (lv_type_1_0= ruleReflexType )
            // InternalReflex.g:2004:5: lv_type_1_0= ruleReflexType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getTypeReflexTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_1_0=ruleReflexType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"ru.iaie.reflex.Reflex.ReflexType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2021:3: ( (lv_constId_2_0= RULE_ID ) )
            // InternalReflex.g:2022:4: (lv_constId_2_0= RULE_ID )
            {
            // InternalReflex.g:2022:4: (lv_constId_2_0= RULE_ID )
            // InternalReflex.g:2023:5: lv_constId_2_0= RULE_ID
            {
            lv_constId_2_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_constId_2_0, grammarAccess.getConstAccess().getConstIdIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstRule());
              					}
              					setWithLastConsumed(
              						current,
              						"constId",
              						lv_constId_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,51,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstAccess().getEqualsSignKeyword_3());
              		
            }
            // InternalReflex.g:2043:3: ( (lv_constValue_4_0= ruleExpression ) )
            // InternalReflex.g:2044:4: (lv_constValue_4_0= ruleExpression )
            {
            // InternalReflex.g:2044:4: (lv_constValue_4_0= ruleExpression )
            // InternalReflex.g:2045:5: lv_constValue_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getConstValueExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_constValue_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"constValue",
              						lv_constValue_4_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getConstAccess().getSemicolonKeyword_5());
              		
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
    // InternalReflex.g:2070:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // InternalReflex.g:2070:45: (iv_ruleEnum= ruleEnum EOF )
            // InternalReflex.g:2071:2: iv_ruleEnum= ruleEnum EOF
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
    // InternalReflex.g:2077:1: ruleEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) ;
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
            // InternalReflex.g:2083:2: ( (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) )
            // InternalReflex.g:2084:2: (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:2084:2: (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            // InternalReflex.g:2085:3: otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,70,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalReflex.g:2089:3: ( (lv_enumId_1_0= RULE_ID ) )
            // InternalReflex.g:2090:4: (lv_enumId_1_0= RULE_ID )
            {
            // InternalReflex.g:2090:4: (lv_enumId_1_0= RULE_ID )
            // InternalReflex.g:2091:5: lv_enumId_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,40,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:2111:3: ( (lv_enumMembers_3_0= ruleEnumMember ) )
            // InternalReflex.g:2112:4: (lv_enumMembers_3_0= ruleEnumMember )
            {
            // InternalReflex.g:2112:4: (lv_enumMembers_3_0= ruleEnumMember )
            // InternalReflex.g:2113:5: lv_enumMembers_3_0= ruleEnumMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_37);
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

            // InternalReflex.g:2130:3: (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==50) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalReflex.g:2131:4: otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    {
            	    otherlv_4=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getEnumAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:2135:4: ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    // InternalReflex.g:2136:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    {
            	    // InternalReflex.g:2136:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    // InternalReflex.g:2137:6: lv_enumMembers_5_0= ruleEnumMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
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
            	    break loop22;
                }
            } while (true);

            otherlv_6=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:2163:1: entryRuleEnumMember returns [EObject current=null] : iv_ruleEnumMember= ruleEnumMember EOF ;
    public final EObject entryRuleEnumMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumMember = null;


        try {
            // InternalReflex.g:2163:51: (iv_ruleEnumMember= ruleEnumMember EOF )
            // InternalReflex.g:2164:2: iv_ruleEnumMember= ruleEnumMember EOF
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
    // InternalReflex.g:2170:1: ruleEnumMember returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEnumMember() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2176:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? ) )
            // InternalReflex.g:2177:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? )
            {
            // InternalReflex.g:2177:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? )
            // InternalReflex.g:2178:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )?
            {
            // InternalReflex.g:2178:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalReflex.g:2179:4: (lv_name_0_0= RULE_ID )
            {
            // InternalReflex.g:2179:4: (lv_name_0_0= RULE_ID )
            // InternalReflex.g:2180:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_38); if (state.failed) return current;
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

            // InternalReflex.g:2196:3: (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==51) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalReflex.g:2197:4: otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getEnumMemberAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:2201:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalReflex.g:2202:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalReflex.g:2202:5: (lv_value_2_0= ruleExpression )
                    // InternalReflex.g:2203:6: lv_value_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEnumMemberAccess().getValueExpressionParserRuleCall_1_1_0());
                      					
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
    // $ANTLR end "ruleEnumMember"


    // $ANTLR start "entryRuleInfixOp"
    // InternalReflex.g:2225:1: entryRuleInfixOp returns [EObject current=null] : iv_ruleInfixOp= ruleInfixOp EOF ;
    public final EObject entryRuleInfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOp = null;


        try {
            // InternalReflex.g:2225:48: (iv_ruleInfixOp= ruleInfixOp EOF )
            // InternalReflex.g:2226:2: iv_ruleInfixOp= ruleInfixOp EOF
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
    // InternalReflex.g:2232:1: ruleInfixOp returns [EObject current=null] : ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_1_0=null;
        Enumerator lv_op_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2238:2: ( ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:2239:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:2239:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            // InternalReflex.g:2240:3: ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) )
            {
            // InternalReflex.g:2240:3: ( (lv_op_0_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2241:4: (lv_op_0_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2241:4: (lv_op_0_0= ruleInfixPostfixOp )
            // InternalReflex.g:2242:5: lv_op_0_0= ruleInfixPostfixOp
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

            // InternalReflex.g:2259:3: ( (lv_varId_1_0= RULE_ID ) )
            // InternalReflex.g:2260:4: (lv_varId_1_0= RULE_ID )
            {
            // InternalReflex.g:2260:4: (lv_varId_1_0= RULE_ID )
            // InternalReflex.g:2261:5: lv_varId_1_0= RULE_ID
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
    // InternalReflex.g:2281:1: entryRulePostfixOp returns [EObject current=null] : iv_rulePostfixOp= rulePostfixOp EOF ;
    public final EObject entryRulePostfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOp = null;


        try {
            // InternalReflex.g:2281:50: (iv_rulePostfixOp= rulePostfixOp EOF )
            // InternalReflex.g:2282:2: iv_rulePostfixOp= rulePostfixOp EOF
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
    // InternalReflex.g:2288:1: rulePostfixOp returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) ;
    public final EObject rulePostfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Enumerator lv_op_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2294:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) )
            // InternalReflex.g:2295:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            {
            // InternalReflex.g:2295:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            // InternalReflex.g:2296:3: ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) )
            {
            // InternalReflex.g:2296:3: ( (lv_varId_0_0= RULE_ID ) )
            // InternalReflex.g:2297:4: (lv_varId_0_0= RULE_ID )
            {
            // InternalReflex.g:2297:4: (lv_varId_0_0= RULE_ID )
            // InternalReflex.g:2298:5: lv_varId_0_0= RULE_ID
            {
            lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_39); if (state.failed) return current;
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

            // InternalReflex.g:2314:3: ( (lv_op_1_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2315:4: (lv_op_1_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2315:4: (lv_op_1_0= ruleInfixPostfixOp )
            // InternalReflex.g:2316:5: lv_op_1_0= ruleInfixPostfixOp
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
    // InternalReflex.g:2337:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalReflex.g:2337:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalReflex.g:2338:2: iv_ruleFunctionCall= ruleFunctionCall EOF
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
    // InternalReflex.g:2344:1: ruleFunctionCall returns [EObject current=null] : ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalReflex.g:2350:2: ( ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalReflex.g:2351:2: ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalReflex.g:2351:2: ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            // InternalReflex.g:2352:3: ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalReflex.g:2352:3: ( (lv_funcId_0_0= RULE_ID ) )
            // InternalReflex.g:2353:4: (lv_funcId_0_0= RULE_ID )
            {
            // InternalReflex.g:2353:4: (lv_funcId_0_0= RULE_ID )
            // InternalReflex.g:2354:5: lv_funcId_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,54,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:2374:3: ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_FLOAT)||LA25_0==54||(LA25_0>=76 && LA25_0<=77)||(LA25_0>=87 && LA25_0<=90)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalReflex.g:2375:4: ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    {
                    // InternalReflex.g:2375:4: ( (lv_args_2_0= ruleExpression ) )
                    // InternalReflex.g:2376:5: (lv_args_2_0= ruleExpression )
                    {
                    // InternalReflex.g:2376:5: (lv_args_2_0= ruleExpression )
                    // InternalReflex.g:2377:6: lv_args_2_0= ruleExpression
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

                    // InternalReflex.g:2394:4: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==50) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalReflex.g:2395:5: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,50,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalReflex.g:2399:5: ( (lv_args_4_0= ruleExpression ) )
                    	    // InternalReflex.g:2400:6: (lv_args_4_0= ruleExpression )
                    	    {
                    	    // InternalReflex.g:2400:6: (lv_args_4_0= ruleExpression )
                    	    // InternalReflex.g:2401:7: lv_args_4_0= ruleExpression
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
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:2428:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalReflex.g:2428:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalReflex.g:2429:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalReflex.g:2435:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) | ( () this_INTEGER_2= RULE_INTEGER ) | ( () this_FLOAT_4= RULE_FLOAT ) | (otherlv_5= '(' ( (lv_nestedExpr_6_0= ruleExpression ) ) otherlv_7= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Token this_INTEGER_2=null;
        Token this_FLOAT_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_nestedExpr_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2441:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) | ( () this_INTEGER_2= RULE_INTEGER ) | ( () this_FLOAT_4= RULE_FLOAT ) | (otherlv_5= '(' ( (lv_nestedExpr_6_0= ruleExpression ) ) otherlv_7= ')' ) ) )
            // InternalReflex.g:2442:2: ( ( (lv_varId_0_0= RULE_ID ) ) | ( () this_INTEGER_2= RULE_INTEGER ) | ( () this_FLOAT_4= RULE_FLOAT ) | (otherlv_5= '(' ( (lv_nestedExpr_6_0= ruleExpression ) ) otherlv_7= ')' ) )
            {
            // InternalReflex.g:2442:2: ( ( (lv_varId_0_0= RULE_ID ) ) | ( () this_INTEGER_2= RULE_INTEGER ) | ( () this_FLOAT_4= RULE_FLOAT ) | (otherlv_5= '(' ( (lv_nestedExpr_6_0= ruleExpression ) ) otherlv_7= ')' ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt26=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt26=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt26=3;
                }
                break;
            case 54:
                {
                alt26=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalReflex.g:2443:3: ( (lv_varId_0_0= RULE_ID ) )
                    {
                    // InternalReflex.g:2443:3: ( (lv_varId_0_0= RULE_ID ) )
                    // InternalReflex.g:2444:4: (lv_varId_0_0= RULE_ID )
                    {
                    // InternalReflex.g:2444:4: (lv_varId_0_0= RULE_ID )
                    // InternalReflex.g:2445:5: lv_varId_0_0= RULE_ID
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
                    // InternalReflex.g:2462:3: ( () this_INTEGER_2= RULE_INTEGER )
                    {
                    // InternalReflex.g:2462:3: ( () this_INTEGER_2= RULE_INTEGER )
                    // InternalReflex.g:2463:4: () this_INTEGER_2= RULE_INTEGER
                    {
                    // InternalReflex.g:2463:4: ()
                    // InternalReflex.g:2464:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    this_INTEGER_2=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INTEGER_2, grammarAccess.getPrimaryExpressionAccess().getINTEGERTerminalRuleCall_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:2476:3: ( () this_FLOAT_4= RULE_FLOAT )
                    {
                    // InternalReflex.g:2476:3: ( () this_FLOAT_4= RULE_FLOAT )
                    // InternalReflex.g:2477:4: () this_FLOAT_4= RULE_FLOAT
                    {
                    // InternalReflex.g:2477:4: ()
                    // InternalReflex.g:2478:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_2_0(),
                      						current);
                      				
                    }

                    }

                    this_FLOAT_4=(Token)match(input,RULE_FLOAT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FLOAT_4, grammarAccess.getPrimaryExpressionAccess().getFLOATTerminalRuleCall_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:2490:3: (otherlv_5= '(' ( (lv_nestedExpr_6_0= ruleExpression ) ) otherlv_7= ')' )
                    {
                    // InternalReflex.g:2490:3: (otherlv_5= '(' ( (lv_nestedExpr_6_0= ruleExpression ) ) otherlv_7= ')' )
                    // InternalReflex.g:2491:4: otherlv_5= '(' ( (lv_nestedExpr_6_0= ruleExpression ) ) otherlv_7= ')'
                    {
                    otherlv_5=(Token)match(input,54,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalReflex.g:2495:4: ( (lv_nestedExpr_6_0= ruleExpression ) )
                    // InternalReflex.g:2496:5: (lv_nestedExpr_6_0= ruleExpression )
                    {
                    // InternalReflex.g:2496:5: (lv_nestedExpr_6_0= ruleExpression )
                    // InternalReflex.g:2497:6: lv_nestedExpr_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNestedExprExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_nestedExpr_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"nestedExpr",
                      							lv_nestedExpr_6_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
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
    // InternalReflex.g:2523:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalReflex.g:2523:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalReflex.g:2524:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalReflex.g:2530:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject this_FunctionCall_1 = null;

        EObject this_PostfixOp_2 = null;

        EObject this_InfixOp_3 = null;

        Enumerator lv_unaryOp_4_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2536:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2537:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2537:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) )
            int alt27=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case EOF:
                case RULE_BIT_AND:
                case RULE_BIT_XOR:
                case RULE_BIT_OR:
                case RULE_LOGICAL_AND:
                case RULE_LOGICAL_OR:
                case 41:
                case 48:
                case 50:
                case 55:
                case 87:
                case 88:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                    {
                    alt27=1;
                    }
                    break;
                case 54:
                    {
                    alt27=2;
                    }
                    break;
                case 76:
                case 77:
                    {
                    alt27=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_INTEGER:
            case RULE_FLOAT:
            case 54:
                {
                alt27=1;
                }
                break;
            case 76:
            case 77:
                {
                alt27=4;
                }
                break;
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt27=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalReflex.g:2538:3: this_PrimaryExpression_0= rulePrimaryExpression
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
                    // InternalReflex.g:2547:3: this_FunctionCall_1= ruleFunctionCall
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
                    // InternalReflex.g:2556:3: this_PostfixOp_2= rulePostfixOp
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
                    // InternalReflex.g:2565:3: this_InfixOp_3= ruleInfixOp
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
                    // InternalReflex.g:2574:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2574:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2575:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) )
                    {
                    // InternalReflex.g:2575:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) )
                    // InternalReflex.g:2576:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    {
                    // InternalReflex.g:2576:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    // InternalReflex.g:2577:6: lv_unaryOp_4_0= ruleUnaryOp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryOpUnaryOpEnumRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
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

                    // InternalReflex.g:2594:4: ( (lv_right_5_0= ruleCastExpression ) )
                    // InternalReflex.g:2595:5: (lv_right_5_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2595:5: (lv_right_5_0= ruleCastExpression )
                    // InternalReflex.g:2596:6: lv_right_5_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getRightCastExpressionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_5_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_5_0,
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
    // InternalReflex.g:2618:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalReflex.g:2618:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalReflex.g:2619:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalReflex.g:2625:1: ruleCastExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2631:2: ( (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2632:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2632:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_FLOAT)||(LA28_0>=76 && LA28_0<=77)||(LA28_0>=87 && LA28_0<=90)) ) {
                alt28=1;
            }
            else if ( (LA28_0==54) ) {
                int LA28_2 = input.LA(2);

                if ( ((LA28_2>=RULE_ID && LA28_2<=RULE_FLOAT)||LA28_2==54||(LA28_2>=76 && LA28_2<=77)||(LA28_2>=87 && LA28_2<=90)) ) {
                    alt28=1;
                }
                else if ( ((LA28_2>=RULE_VOID_C_TYPE && LA28_2<=RULE_BOOL_TYPE)||(LA28_2>=102 && LA28_2<=103)) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalReflex.g:2633:3: this_UnaryExpression_0= ruleUnaryExpression
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
                    // InternalReflex.g:2642:3: (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2642:3: (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2643:4: otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,54,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:2647:4: ( (lv_type_2_0= ruleReflexType ) )
                    // InternalReflex.g:2648:5: (lv_type_2_0= ruleReflexType )
                    {
                    // InternalReflex.g:2648:5: (lv_type_2_0= ruleReflexType )
                    // InternalReflex.g:2649:6: lv_type_2_0= ruleReflexType
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

                    otherlv_3=(Token)match(input,55,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalReflex.g:2670:4: ( (lv_right_4_0= ruleCastExpression ) )
                    // InternalReflex.g:2671:5: (lv_right_4_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2671:5: (lv_right_4_0= ruleCastExpression )
                    // InternalReflex.g:2672:6: lv_right_4_0= ruleCastExpression
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
    // InternalReflex.g:2694:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalReflex.g:2694:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalReflex.g:2695:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalReflex.g:2701:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CastExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2707:2: ( (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) )
            // InternalReflex.g:2708:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            {
            // InternalReflex.g:2708:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            // InternalReflex.g:2709:3: this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_41);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2717:3: ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=99 && LA29_0<=101)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalReflex.g:2718:4: () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) )
            	    {
            	    // InternalReflex.g:2718:4: ()
            	    // InternalReflex.g:2719:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2725:4: ( (lv_mulOp_2_0= ruleMultiplicativeOp ) )
            	    // InternalReflex.g:2726:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    {
            	    // InternalReflex.g:2726:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    // InternalReflex.g:2727:6: lv_mulOp_2_0= ruleMultiplicativeOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getMulOpMultiplicativeOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
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

            	    // InternalReflex.g:2744:4: ( (lv_right_3_0= ruleCastExpression ) )
            	    // InternalReflex.g:2745:5: (lv_right_3_0= ruleCastExpression )
            	    {
            	    // InternalReflex.g:2745:5: (lv_right_3_0= ruleCastExpression )
            	    // InternalReflex.g:2746:6: lv_right_3_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightCastExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalReflex.g:2768:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalReflex.g:2768:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalReflex.g:2769:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalReflex.g:2775:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2781:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalReflex.g:2782:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalReflex.g:2782:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalReflex.g:2783:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_42);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2791:3: ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==87) ) {
                    alt30=1;
                }
                else if ( (LA30_0==88) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalReflex.g:2792:4: () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalReflex.g:2792:4: ()
            	    // InternalReflex.g:2793:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2799:4: ( (lv_addOp_2_0= ruleAdditiveOp ) )
            	    // InternalReflex.g:2800:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    {
            	    // InternalReflex.g:2800:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    // InternalReflex.g:2801:6: lv_addOp_2_0= ruleAdditiveOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getAddOpAdditiveOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
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

            	    // InternalReflex.g:2818:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalReflex.g:2819:5: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalReflex.g:2819:5: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalReflex.g:2820:6: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_right_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.AdditiveExpression");
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalReflex.g:2842:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalReflex.g:2842:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalReflex.g:2843:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalReflex.g:2849:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        Enumerator lv_shiftOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2855:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) )
            // InternalReflex.g:2856:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            {
            // InternalReflex.g:2856:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            // InternalReflex.g:2857:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_43);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2865:3: ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==97) ) {
                    alt31=1;
                }
                else if ( (LA31_0==98) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalReflex.g:2866:4: () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalReflex.g:2866:4: ()
            	    // InternalReflex.g:2867:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2873:4: ( (lv_shiftOp_2_0= ruleShiftOp ) )
            	    // InternalReflex.g:2874:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    {
            	    // InternalReflex.g:2874:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    // InternalReflex.g:2875:6: lv_shiftOp_2_0= ruleShiftOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getShiftOpShiftOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
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

            	    // InternalReflex.g:2892:4: ( (lv_right_3_0= ruleShiftExpression ) )
            	    // InternalReflex.g:2893:5: (lv_right_3_0= ruleShiftExpression )
            	    {
            	    // InternalReflex.g:2893:5: (lv_right_3_0= ruleShiftExpression )
            	    // InternalReflex.g:2894:6: lv_right_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightShiftExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_43);
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
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleCompareExpression"
    // InternalReflex.g:2916:1: entryRuleCompareExpression returns [EObject current=null] : iv_ruleCompareExpression= ruleCompareExpression EOF ;
    public final EObject entryRuleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpression = null;


        try {
            // InternalReflex.g:2916:58: (iv_ruleCompareExpression= ruleCompareExpression EOF )
            // InternalReflex.g:2917:2: iv_ruleCompareExpression= ruleCompareExpression EOF
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
    // InternalReflex.g:2923:1: ruleCompareExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* ) ;
    public final EObject ruleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_cmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2929:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* ) )
            // InternalReflex.g:2930:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* )
            {
            // InternalReflex.g:2930:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* )
            // InternalReflex.g:2931:3: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCompareExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_44);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2939:3: ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                switch ( input.LA(1) ) {
                case 91:
                    {
                    alt32=1;
                    }
                    break;
                case 92:
                    {
                    alt32=1;
                    }
                    break;
                case 93:
                    {
                    alt32=1;
                    }
                    break;
                case 94:
                    {
                    alt32=1;
                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // InternalReflex.g:2940:4: () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) )
            	    {
            	    // InternalReflex.g:2940:4: ()
            	    // InternalReflex.g:2941:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getCompareExpressionAccess().getCompareExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2947:4: ( (lv_cmpOp_2_0= ruleCompareOp ) )
            	    // InternalReflex.g:2948:5: (lv_cmpOp_2_0= ruleCompareOp )
            	    {
            	    // InternalReflex.g:2948:5: (lv_cmpOp_2_0= ruleCompareOp )
            	    // InternalReflex.g:2949:6: lv_cmpOp_2_0= ruleCompareOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCompareExpressionAccess().getCmpOpCompareOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
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

            	    // InternalReflex.g:2966:4: ( (lv_right_3_0= ruleCompareExpression ) )
            	    // InternalReflex.g:2967:5: (lv_right_3_0= ruleCompareExpression )
            	    {
            	    // InternalReflex.g:2967:5: (lv_right_3_0= ruleCompareExpression )
            	    // InternalReflex.g:2968:6: lv_right_3_0= ruleCompareExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCompareExpressionAccess().getRightCompareExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_44);
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
    // $ANTLR end "ruleCompareExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalReflex.g:2990:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalReflex.g:2990:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalReflex.g:2991:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalReflex.g:2997:1: ruleEqualityExpression returns [EObject current=null] : (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpression_0 = null;

        Enumerator lv_eqCmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3003:2: ( (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalReflex.g:3004:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalReflex.g:3004:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalReflex.g:3005:3: this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getCompareExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_45);
            this_CompareExpression_0=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CompareExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3013:3: ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==95) ) {
                    alt33=1;
                }
                else if ( (LA33_0==96) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalReflex.g:3014:4: () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalReflex.g:3014:4: ()
            	    // InternalReflex.g:3015:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3021:4: ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) )
            	    // InternalReflex.g:3022:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    {
            	    // InternalReflex.g:3022:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    // InternalReflex.g:3023:6: lv_eqCmpOp_2_0= ruleCompareEqOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getEqCmpOpCompareEqOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
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

            	    // InternalReflex.g:3040:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalReflex.g:3041:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalReflex.g:3041:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalReflex.g:3042:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_45);
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleBitAndExpression"
    // InternalReflex.g:3064:1: entryRuleBitAndExpression returns [EObject current=null] : iv_ruleBitAndExpression= ruleBitAndExpression EOF ;
    public final EObject entryRuleBitAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitAndExpression = null;


        try {
            // InternalReflex.g:3064:57: (iv_ruleBitAndExpression= ruleBitAndExpression EOF )
            // InternalReflex.g:3065:2: iv_ruleBitAndExpression= ruleBitAndExpression EOF
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
    // InternalReflex.g:3071:1: ruleBitAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) ;
    public final EObject ruleBitAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_AND_2=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3077:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) )
            // InternalReflex.g:3078:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            {
            // InternalReflex.g:3078:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            // InternalReflex.g:3079:3: this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_46);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3087:3: ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_BIT_AND) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalReflex.g:3088:4: () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) )
            	    {
            	    // InternalReflex.g:3088:4: ()
            	    // InternalReflex.g:3089:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitAndExpressionAccess().getBitAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_AND_2=(Token)match(input,RULE_BIT_AND,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_AND_2, grammarAccess.getBitAndExpressionAccess().getBIT_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3099:4: ( (lv_right_3_0= ruleBitAndExpression ) )
            	    // InternalReflex.g:3100:5: (lv_right_3_0= ruleBitAndExpression )
            	    {
            	    // InternalReflex.g:3100:5: (lv_right_3_0= ruleBitAndExpression )
            	    // InternalReflex.g:3101:6: lv_right_3_0= ruleBitAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitAndExpressionAccess().getRightBitAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_46);
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
    // $ANTLR end "ruleBitAndExpression"


    // $ANTLR start "entryRuleBitXorExpression"
    // InternalReflex.g:3123:1: entryRuleBitXorExpression returns [EObject current=null] : iv_ruleBitXorExpression= ruleBitXorExpression EOF ;
    public final EObject entryRuleBitXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitXorExpression = null;


        try {
            // InternalReflex.g:3123:57: (iv_ruleBitXorExpression= ruleBitXorExpression EOF )
            // InternalReflex.g:3124:2: iv_ruleBitXorExpression= ruleBitXorExpression EOF
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
    // InternalReflex.g:3130:1: ruleBitXorExpression returns [EObject current=null] : (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) ;
    public final EObject ruleBitXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_XOR_2=null;
        EObject this_BitAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3136:2: ( (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) )
            // InternalReflex.g:3137:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            {
            // InternalReflex.g:3137:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            // InternalReflex.g:3138:3: this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitXorExpressionAccess().getBitAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_47);
            this_BitAndExpression_0=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3146:3: ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_BIT_XOR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalReflex.g:3147:4: () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) )
            	    {
            	    // InternalReflex.g:3147:4: ()
            	    // InternalReflex.g:3148:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitXorExpressionAccess().getBitXorExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_XOR_2=(Token)match(input,RULE_BIT_XOR,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_XOR_2, grammarAccess.getBitXorExpressionAccess().getBIT_XORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3158:4: ( (lv_right_3_0= ruleBitXorExpression ) )
            	    // InternalReflex.g:3159:5: (lv_right_3_0= ruleBitXorExpression )
            	    {
            	    // InternalReflex.g:3159:5: (lv_right_3_0= ruleBitXorExpression )
            	    // InternalReflex.g:3160:6: lv_right_3_0= ruleBitXorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitXorExpressionAccess().getRightBitXorExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_47);
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
    // $ANTLR end "ruleBitXorExpression"


    // $ANTLR start "entryRuleBitOrExpression"
    // InternalReflex.g:3182:1: entryRuleBitOrExpression returns [EObject current=null] : iv_ruleBitOrExpression= ruleBitOrExpression EOF ;
    public final EObject entryRuleBitOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitOrExpression = null;


        try {
            // InternalReflex.g:3182:56: (iv_ruleBitOrExpression= ruleBitOrExpression EOF )
            // InternalReflex.g:3183:2: iv_ruleBitOrExpression= ruleBitOrExpression EOF
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
    // InternalReflex.g:3189:1: ruleBitOrExpression returns [EObject current=null] : (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) ;
    public final EObject ruleBitOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_OR_2=null;
        EObject this_BitXorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3195:2: ( (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) )
            // InternalReflex.g:3196:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            {
            // InternalReflex.g:3196:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            // InternalReflex.g:3197:3: this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitOrExpressionAccess().getBitXorExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_48);
            this_BitXorExpression_0=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitXorExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3205:3: ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_BIT_OR) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalReflex.g:3206:4: () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) )
            	    {
            	    // InternalReflex.g:3206:4: ()
            	    // InternalReflex.g:3207:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitOrExpressionAccess().getBitOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_OR_2=(Token)match(input,RULE_BIT_OR,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_OR_2, grammarAccess.getBitOrExpressionAccess().getBIT_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3217:4: ( (lv_right_3_0= ruleBitOrExpression ) )
            	    // InternalReflex.g:3218:5: (lv_right_3_0= ruleBitOrExpression )
            	    {
            	    // InternalReflex.g:3218:5: (lv_right_3_0= ruleBitOrExpression )
            	    // InternalReflex.g:3219:6: lv_right_3_0= ruleBitOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitOrExpressionAccess().getRightBitOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
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
    // $ANTLR end "ruleBitOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalReflex.g:3241:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalReflex.g:3241:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalReflex.g:3242:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalReflex.g:3248:1: ruleLogicalAndExpression returns [EObject current=null] : (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_AND_2=null;
        EObject this_BitOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3254:2: ( (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalReflex.g:3255:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalReflex.g:3255:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalReflex.g:3256:3: this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getBitOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_49);
            this_BitOrExpression_0=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3264:3: ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_LOGICAL_AND) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalReflex.g:3265:4: () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalReflex.g:3265:4: ()
            	    // InternalReflex.g:3266:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_AND_2=(Token)match(input,RULE_LOGICAL_AND,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_AND_2, grammarAccess.getLogicalAndExpressionAccess().getLOGICAL_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3276:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    // InternalReflex.g:3277:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalReflex.g:3277:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    // InternalReflex.g:3278:6: lv_right_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_49);
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
            	    break loop37;
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
    // InternalReflex.g:3300:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalReflex.g:3300:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalReflex.g:3301:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalReflex.g:3307:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_OR_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3313:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) )
            // InternalReflex.g:3314:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            {
            // InternalReflex.g:3314:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            // InternalReflex.g:3315:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_50);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3323:3: ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_LOGICAL_OR) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalReflex.g:3324:4: () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    {
            	    // InternalReflex.g:3324:4: ()
            	    // InternalReflex.g:3325:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_OR_2=(Token)match(input,RULE_LOGICAL_OR,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_OR_2, grammarAccess.getLogicalOrExpressionAccess().getLOGICAL_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3335:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    // InternalReflex.g:3336:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    {
            	    // InternalReflex.g:3336:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    // InternalReflex.g:3337:6: lv_right_3_0= ruleLogicalOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_50);
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
            	    break loop38;
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
    // InternalReflex.g:3359:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalReflex.g:3359:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalReflex.g:3360:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalReflex.g:3366:1: ruleAssignmentExpression returns [EObject current=null] : ( ( ( (lv_assignVar_0_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_assignVar_0_0=null;
        Enumerator lv_assignOp_1_0 = null;

        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3372:2: ( ( ( ( (lv_assignVar_0_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) ) )
            // InternalReflex.g:3373:2: ( ( ( (lv_assignVar_0_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) )
            {
            // InternalReflex.g:3373:2: ( ( ( (lv_assignVar_0_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) )
            // InternalReflex.g:3374:3: ( ( (lv_assignVar_0_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) )
            {
            // InternalReflex.g:3374:3: ( ( (lv_assignVar_0_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==51||(LA39_1>=78 && LA39_1<=86)) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // InternalReflex.g:3375:4: ( (lv_assignVar_0_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) )
                    {
                    // InternalReflex.g:3375:4: ( (lv_assignVar_0_0= RULE_ID ) )
                    // InternalReflex.g:3376:5: (lv_assignVar_0_0= RULE_ID )
                    {
                    // InternalReflex.g:3376:5: (lv_assignVar_0_0= RULE_ID )
                    // InternalReflex.g:3377:6: lv_assignVar_0_0= RULE_ID
                    {
                    lv_assignVar_0_0=(Token)match(input,RULE_ID,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_assignVar_0_0, grammarAccess.getAssignmentExpressionAccess().getAssignVarIDTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"assignVar",
                      							lv_assignVar_0_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3393:4: ( (lv_assignOp_1_0= ruleAssignOperator ) )
                    // InternalReflex.g:3394:5: (lv_assignOp_1_0= ruleAssignOperator )
                    {
                    // InternalReflex.g:3394:5: (lv_assignOp_1_0= ruleAssignOperator )
                    // InternalReflex.g:3395:6: lv_assignOp_1_0= ruleAssignOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getAssignOpAssignOperatorEnumRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_assignOp_1_0=ruleAssignOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"assignOp",
                      							lv_assignOp_1_0,
                      							"ru.iaie.reflex.Reflex.AssignOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:3413:3: ( (lv_expr_2_0= ruleLogicalOrExpression ) )
            // InternalReflex.g:3414:4: (lv_expr_2_0= ruleLogicalOrExpression )
            {
            // InternalReflex.g:3414:4: (lv_expr_2_0= ruleLogicalOrExpression )
            // InternalReflex.g:3415:5: lv_expr_2_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"ru.iaie.reflex.Reflex.LogicalOrExpression");
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
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalReflex.g:3436:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalReflex.g:3436:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalReflex.g:3437:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalReflex.g:3443:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3449:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalReflex.g:3450:2: this_AssignmentExpression_0= ruleAssignmentExpression
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
    // InternalReflex.g:3461:1: entryRuleCType returns [EObject current=null] : iv_ruleCType= ruleCType EOF ;
    public final EObject entryRuleCType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCType = null;


        try {
            // InternalReflex.g:3461:46: (iv_ruleCType= ruleCType EOF )
            // InternalReflex.g:3462:2: iv_ruleCType= ruleCType EOF
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
    // InternalReflex.g:3468:1: ruleCType returns [EObject current=null] : ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) ;
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
            // InternalReflex.g:3474:2: ( ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) )
            // InternalReflex.g:3475:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            {
            // InternalReflex.g:3475:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            int alt42=4;
            switch ( input.LA(1) ) {
            case RULE_VOID_C_TYPE:
                {
                alt42=1;
                }
                break;
            case RULE_FLOAT_C_TYPE:
                {
                alt42=2;
                }
                break;
            case RULE_DOUBLE_C_TYPE:
                {
                alt42=3;
                }
                break;
            case RULE_SHORT_C_TYPE:
            case RULE_INT_C_TYPE:
            case RULE_LONG_C_TYPE:
            case 102:
            case 103:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalReflex.g:3476:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    {
                    // InternalReflex.g:3476:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    // InternalReflex.g:3477:4: () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE
                    {
                    // InternalReflex.g:3477:4: ()
                    // InternalReflex.g:3478:5: 
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
                    // InternalReflex.g:3490:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    {
                    // InternalReflex.g:3490:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    // InternalReflex.g:3491:4: () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE
                    {
                    // InternalReflex.g:3491:4: ()
                    // InternalReflex.g:3492:5: 
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
                    // InternalReflex.g:3504:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    {
                    // InternalReflex.g:3504:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    // InternalReflex.g:3505:4: () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE
                    {
                    // InternalReflex.g:3505:4: ()
                    // InternalReflex.g:3506:5: 
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
                    // InternalReflex.g:3518:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    {
                    // InternalReflex.g:3518:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    // InternalReflex.g:3519:4: () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    {
                    // InternalReflex.g:3519:4: ()
                    // InternalReflex.g:3520:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:3526:4: ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( ((LA40_0>=102 && LA40_0<=103)) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalReflex.g:3527:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            {
                            // InternalReflex.g:3527:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            // InternalReflex.g:3528:6: lv_signSpec_7_0= ruleCTypeSignSpec
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getCTypeAccess().getSignSpecCTypeSignSpecEnumRuleCall_3_1_0());
                              					
                            }
                            pushFollow(FOLLOW_52);
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

                    // InternalReflex.g:3545:4: (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    int alt41=3;
                    switch ( input.LA(1) ) {
                    case RULE_SHORT_C_TYPE:
                        {
                        alt41=1;
                        }
                        break;
                    case RULE_INT_C_TYPE:
                        {
                        alt41=2;
                        }
                        break;
                    case RULE_LONG_C_TYPE:
                        {
                        alt41=3;
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
                            // InternalReflex.g:3546:5: this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE
                            {
                            this_SHORT_C_TYPE_8=(Token)match(input,RULE_SHORT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_SHORT_C_TYPE_8, grammarAccess.getCTypeAccess().getSHORT_C_TYPETerminalRuleCall_3_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalReflex.g:3551:5: this_INT_C_TYPE_9= RULE_INT_C_TYPE
                            {
                            this_INT_C_TYPE_9=(Token)match(input,RULE_INT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_INT_C_TYPE_9, grammarAccess.getCTypeAccess().getINT_C_TYPETerminalRuleCall_3_2_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalReflex.g:3556:5: this_LONG_C_TYPE_10= RULE_LONG_C_TYPE
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
    // InternalReflex.g:3566:1: entryRuleIntegerType returns [String current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final String entryRuleIntegerType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerType = null;


        try {
            // InternalReflex.g:3566:51: (iv_ruleIntegerType= ruleIntegerType EOF )
            // InternalReflex.g:3567:2: iv_ruleIntegerType= ruleIntegerType EOF
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
    // InternalReflex.g:3573:1: ruleIntegerType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) ;
    public final AntlrDatatypeRuleToken ruleIntegerType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOL_TYPE_0=null;
        Token this_INT_C_TYPE_1=null;
        Token this_SHORT_C_TYPE_2=null;
        Token this_LONG_C_TYPE_3=null;


        	enterRule();

        try {
            // InternalReflex.g:3579:2: ( (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) )
            // InternalReflex.g:3580:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            {
            // InternalReflex.g:3580:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            int alt43=4;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                alt43=1;
                }
                break;
            case RULE_INT_C_TYPE:
                {
                alt43=2;
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                alt43=3;
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                alt43=4;
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
                    // InternalReflex.g:3581:3: this_BOOL_TYPE_0= RULE_BOOL_TYPE
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
                    // InternalReflex.g:3589:3: this_INT_C_TYPE_1= RULE_INT_C_TYPE
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
                    // InternalReflex.g:3597:3: this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE
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
                    // InternalReflex.g:3605:3: this_LONG_C_TYPE_3= RULE_LONG_C_TYPE
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
    // InternalReflex.g:3616:1: entryRuleReflexType returns [EObject current=null] : iv_ruleReflexType= ruleReflexType EOF ;
    public final EObject entryRuleReflexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReflexType = null;


        try {
            // InternalReflex.g:3616:51: (iv_ruleReflexType= ruleReflexType EOF )
            // InternalReflex.g:3617:2: iv_ruleReflexType= ruleReflexType EOF
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
    // InternalReflex.g:3623:1: ruleReflexType returns [EObject current=null] : (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) ;
    public final EObject ruleReflexType() throws RecognitionException {
        EObject current = null;

        Token this_BOOL_TYPE_2=null;
        EObject this_CType_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3629:2: ( (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) )
            // InternalReflex.g:3630:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            {
            // InternalReflex.g:3630:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_VOID_C_TYPE && LA44_0<=RULE_LONG_C_TYPE)||(LA44_0>=102 && LA44_0<=103)) ) {
                alt44=1;
            }
            else if ( (LA44_0==RULE_BOOL_TYPE) ) {
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
                    // InternalReflex.g:3631:3: this_CType_0= ruleCType
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
                    // InternalReflex.g:3640:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    {
                    // InternalReflex.g:3640:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    // InternalReflex.g:3641:4: () this_BOOL_TYPE_2= RULE_BOOL_TYPE
                    {
                    // InternalReflex.g:3641:4: ()
                    // InternalReflex.g:3642:5: 
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


    // $ANTLR start "entryRuleTact"
    // InternalReflex.g:3657:1: entryRuleTact returns [EObject current=null] : iv_ruleTact= ruleTact EOF ;
    public final EObject entryRuleTact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTact = null;


        try {
            // InternalReflex.g:3657:45: (iv_ruleTact= ruleTact EOF )
            // InternalReflex.g:3658:2: iv_ruleTact= ruleTact EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTactRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTact=ruleTact();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTact; 
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
    // $ANTLR end "entryRuleTact"


    // $ANTLR start "ruleTact"
    // InternalReflex.g:3664:1: ruleTact returns [EObject current=null] : (otherlv_0= 'tact' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';' ) ;
    public final EObject ruleTact() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:3670:2: ( (otherlv_0= 'tact' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';' ) )
            // InternalReflex.g:3671:2: (otherlv_0= 'tact' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';' )
            {
            // InternalReflex.g:3671:2: (otherlv_0= 'tact' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';' )
            // InternalReflex.g:3672:3: otherlv_0= 'tact' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTactAccess().getTactKeyword_0());
              		
            }
            // InternalReflex.g:3676:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // InternalReflex.g:3677:4: (lv_value_1_0= RULE_INTEGER )
            {
            // InternalReflex.g:3677:4: (lv_value_1_0= RULE_INTEGER )
            // InternalReflex.g:3678:5: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getTactAccess().getValueINTEGERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTactRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTactAccess().getSemicolonKeyword_2());
              		
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
    // $ANTLR end "ruleTact"


    // $ANTLR start "entryRuleTime"
    // InternalReflex.g:3702:1: entryRuleTime returns [EObject current=null] : iv_ruleTime= ruleTime EOF ;
    public final EObject entryRuleTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTime = null;


        try {
            // InternalReflex.g:3702:45: (iv_ruleTime= ruleTime EOF )
            // InternalReflex.g:3703:2: iv_ruleTime= ruleTime EOF
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
    // InternalReflex.g:3709:1: ruleTime returns [EObject current=null] : ( (lv_ticks_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleTime() throws RecognitionException {
        EObject current = null;

        Token lv_ticks_0_0=null;


        	enterRule();

        try {
            // InternalReflex.g:3715:2: ( ( (lv_ticks_0_0= RULE_INTEGER ) ) )
            // InternalReflex.g:3716:2: ( (lv_ticks_0_0= RULE_INTEGER ) )
            {
            // InternalReflex.g:3716:2: ( (lv_ticks_0_0= RULE_INTEGER ) )
            // InternalReflex.g:3717:3: (lv_ticks_0_0= RULE_INTEGER )
            {
            // InternalReflex.g:3717:3: (lv_ticks_0_0= RULE_INTEGER )
            // InternalReflex.g:3718:4: lv_ticks_0_0= RULE_INTEGER
            {
            lv_ticks_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_ticks_0_0, grammarAccess.getTimeAccess().getTicksINTEGERTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getTimeRule());
              				}
              				setWithLastConsumed(
              					current,
              					"ticks",
              					lv_ticks_0_0,
              					"ru.iaie.reflex.Reflex.INTEGER");
              			
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
    // $ANTLR end "ruleTime"


    // $ANTLR start "ruleVisibility"
    // InternalReflex.g:3737:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'shared' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3743:2: ( ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'shared' ) ) )
            // InternalReflex.g:3744:2: ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'shared' ) )
            {
            // InternalReflex.g:3744:2: ( (enumLiteral_0= 'local' ) | (enumLiteral_1= 'shared' ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==72) ) {
                alt45=1;
            }
            else if ( (LA45_0==73) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalReflex.g:3745:3: (enumLiteral_0= 'local' )
                    {
                    // InternalReflex.g:3745:3: (enumLiteral_0= 'local' )
                    // InternalReflex.g:3746:4: enumLiteral_0= 'local'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVisibilityAccess().getLOCALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getLOCALEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3753:3: (enumLiteral_1= 'shared' )
                    {
                    // InternalReflex.g:3753:3: (enumLiteral_1= 'shared' )
                    // InternalReflex.g:3754:4: enumLiteral_1= 'shared'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVisibilityAccess().getSHAREDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getSHAREDEnumLiteralDeclaration_1());
                      			
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
    // $ANTLR end "ruleVisibility"


    // $ANTLR start "ruleRegisterType"
    // InternalReflex.g:3764:1: ruleRegisterType returns [Enumerator current=null] : ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) ;
    public final Enumerator ruleRegisterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3770:2: ( ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) )
            // InternalReflex.g:3771:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            {
            // InternalReflex.g:3771:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==74) ) {
                alt46=1;
            }
            else if ( (LA46_0==75) ) {
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
                    // InternalReflex.g:3772:3: (enumLiteral_0= 'input' )
                    {
                    // InternalReflex.g:3772:3: (enumLiteral_0= 'input' )
                    // InternalReflex.g:3773:4: enumLiteral_0= 'input'
                    {
                    enumLiteral_0=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3780:3: (enumLiteral_1= 'output' )
                    {
                    // InternalReflex.g:3780:3: (enumLiteral_1= 'output' )
                    // InternalReflex.g:3781:4: enumLiteral_1= 'output'
                    {
                    enumLiteral_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:3791:1: ruleInfixPostfixOp returns [Enumerator current=null] : ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) ;
    public final Enumerator ruleInfixPostfixOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3797:2: ( ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) )
            // InternalReflex.g:3798:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            {
            // InternalReflex.g:3798:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==76) ) {
                alt47=1;
            }
            else if ( (LA47_0==77) ) {
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
                    // InternalReflex.g:3799:3: (enumLiteral_0= '++' )
                    {
                    // InternalReflex.g:3799:3: (enumLiteral_0= '++' )
                    // InternalReflex.g:3800:4: enumLiteral_0= '++'
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3807:3: (enumLiteral_1= '--' )
                    {
                    // InternalReflex.g:3807:3: (enumLiteral_1= '--' )
                    // InternalReflex.g:3808:4: enumLiteral_1= '--'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:3818:1: ruleAssignOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) ;
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
            // InternalReflex.g:3824:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) )
            // InternalReflex.g:3825:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            {
            // InternalReflex.g:3825:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            int alt48=10;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt48=1;
                }
                break;
            case 78:
                {
                alt48=2;
                }
                break;
            case 79:
                {
                alt48=3;
                }
                break;
            case 80:
                {
                alt48=4;
                }
                break;
            case 81:
                {
                alt48=5;
                }
                break;
            case 82:
                {
                alt48=6;
                }
                break;
            case 83:
                {
                alt48=7;
                }
                break;
            case 84:
                {
                alt48=8;
                }
                break;
            case 85:
                {
                alt48=9;
                }
                break;
            case 86:
                {
                alt48=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalReflex.g:3826:3: (enumLiteral_0= '=' )
                    {
                    // InternalReflex.g:3826:3: (enumLiteral_0= '=' )
                    // InternalReflex.g:3827:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3834:3: (enumLiteral_1= '*=' )
                    {
                    // InternalReflex.g:3834:3: (enumLiteral_1= '*=' )
                    // InternalReflex.g:3835:4: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:3842:3: (enumLiteral_2= '/=' )
                    {
                    // InternalReflex.g:3842:3: (enumLiteral_2= '/=' )
                    // InternalReflex.g:3843:4: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:3850:3: (enumLiteral_3= '+=' )
                    {
                    // InternalReflex.g:3850:3: (enumLiteral_3= '+=' )
                    // InternalReflex.g:3851:4: enumLiteral_3= '+='
                    {
                    enumLiteral_3=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:3858:3: (enumLiteral_4= '-=' )
                    {
                    // InternalReflex.g:3858:3: (enumLiteral_4= '-=' )
                    // InternalReflex.g:3859:4: enumLiteral_4= '-='
                    {
                    enumLiteral_4=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:3866:3: (enumLiteral_5= '<<=' )
                    {
                    // InternalReflex.g:3866:3: (enumLiteral_5= '<<=' )
                    // InternalReflex.g:3867:4: enumLiteral_5= '<<='
                    {
                    enumLiteral_5=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:3874:3: (enumLiteral_6= '>>=' )
                    {
                    // InternalReflex.g:3874:3: (enumLiteral_6= '>>=' )
                    // InternalReflex.g:3875:4: enumLiteral_6= '>>='
                    {
                    enumLiteral_6=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalReflex.g:3882:3: (enumLiteral_7= '&=' )
                    {
                    // InternalReflex.g:3882:3: (enumLiteral_7= '&=' )
                    // InternalReflex.g:3883:4: enumLiteral_7= '&='
                    {
                    enumLiteral_7=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalReflex.g:3890:3: (enumLiteral_8= '^=' )
                    {
                    // InternalReflex.g:3890:3: (enumLiteral_8= '^=' )
                    // InternalReflex.g:3891:4: enumLiteral_8= '^='
                    {
                    enumLiteral_8=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:3898:3: (enumLiteral_9= '|=' )
                    {
                    // InternalReflex.g:3898:3: (enumLiteral_9= '|=' )
                    // InternalReflex.g:3899:4: enumLiteral_9= '|='
                    {
                    enumLiteral_9=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:3909:1: ruleUnaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) ;
    public final Enumerator ruleUnaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:3915:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) )
            // InternalReflex.g:3916:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            {
            // InternalReflex.g:3916:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            int alt49=4;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt49=1;
                }
                break;
            case 88:
                {
                alt49=2;
                }
                break;
            case 89:
                {
                alt49=3;
                }
                break;
            case 90:
                {
                alt49=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalReflex.g:3917:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:3917:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:3918:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3925:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:3925:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:3926:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:3933:3: (enumLiteral_2= '~' )
                    {
                    // InternalReflex.g:3933:3: (enumLiteral_2= '~' )
                    // InternalReflex.g:3934:4: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:3941:3: (enumLiteral_3= '!' )
                    {
                    // InternalReflex.g:3941:3: (enumLiteral_3= '!' )
                    // InternalReflex.g:3942:4: enumLiteral_3= '!'
                    {
                    enumLiteral_3=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:3952:1: ruleCompareOp returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:3958:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) )
            // InternalReflex.g:3959:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalReflex.g:3959:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            int alt50=4;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt50=1;
                }
                break;
            case 92:
                {
                alt50=2;
                }
                break;
            case 93:
                {
                alt50=3;
                }
                break;
            case 94:
                {
                alt50=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalReflex.g:3960:3: (enumLiteral_0= '<' )
                    {
                    // InternalReflex.g:3960:3: (enumLiteral_0= '<' )
                    // InternalReflex.g:3961:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3968:3: (enumLiteral_1= '>' )
                    {
                    // InternalReflex.g:3968:3: (enumLiteral_1= '>' )
                    // InternalReflex.g:3969:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:3976:3: (enumLiteral_2= '=<' )
                    {
                    // InternalReflex.g:3976:3: (enumLiteral_2= '=<' )
                    // InternalReflex.g:3977:4: enumLiteral_2= '=<'
                    {
                    enumLiteral_2=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:3984:3: (enumLiteral_3= '>=' )
                    {
                    // InternalReflex.g:3984:3: (enumLiteral_3= '>=' )
                    // InternalReflex.g:3985:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:3995:1: ruleCompareEqOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleCompareEqOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4001:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // InternalReflex.g:4002:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // InternalReflex.g:4002:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==95) ) {
                alt51=1;
            }
            else if ( (LA51_0==96) ) {
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
                    // InternalReflex.g:4003:3: (enumLiteral_0= '==' )
                    {
                    // InternalReflex.g:4003:3: (enumLiteral_0= '==' )
                    // InternalReflex.g:4004:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4011:3: (enumLiteral_1= '!=' )
                    {
                    // InternalReflex.g:4011:3: (enumLiteral_1= '!=' )
                    // InternalReflex.g:4012:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4022:1: ruleShiftOp returns [Enumerator current=null] : ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) ;
    public final Enumerator ruleShiftOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4028:2: ( ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) )
            // InternalReflex.g:4029:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            {
            // InternalReflex.g:4029:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==97) ) {
                alt52=1;
            }
            else if ( (LA52_0==98) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalReflex.g:4030:3: (enumLiteral_0= '>>' )
                    {
                    // InternalReflex.g:4030:3: (enumLiteral_0= '>>' )
                    // InternalReflex.g:4031:4: enumLiteral_0= '>>'
                    {
                    enumLiteral_0=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4038:3: (enumLiteral_1= '<<' )
                    {
                    // InternalReflex.g:4038:3: (enumLiteral_1= '<<' )
                    // InternalReflex.g:4039:4: enumLiteral_1= '<<'
                    {
                    enumLiteral_1=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4049:1: ruleAdditiveOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4055:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalReflex.g:4056:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalReflex.g:4056:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==87) ) {
                alt53=1;
            }
            else if ( (LA53_0==88) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalReflex.g:4057:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4057:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4058:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4065:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4065:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4066:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4076:1: ruleMultiplicativeOp returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalReflex.g:4082:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalReflex.g:4083:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalReflex.g:4083:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt54=3;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt54=1;
                }
                break;
            case 100:
                {
                alt54=2;
                }
                break;
            case 101:
                {
                alt54=3;
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
                    // InternalReflex.g:4084:3: (enumLiteral_0= '*' )
                    {
                    // InternalReflex.g:4084:3: (enumLiteral_0= '*' )
                    // InternalReflex.g:4085:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4092:3: (enumLiteral_1= '/' )
                    {
                    // InternalReflex.g:4092:3: (enumLiteral_1= '/' )
                    // InternalReflex.g:4093:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4100:3: (enumLiteral_2= '%' )
                    {
                    // InternalReflex.g:4100:3: (enumLiteral_2= '%' )
                    // InternalReflex.g:4101:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4111:1: ruleCTypeSignSpec returns [Enumerator current=null] : ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) ;
    public final Enumerator ruleCTypeSignSpec() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4117:2: ( ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) )
            // InternalReflex.g:4118:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            {
            // InternalReflex.g:4118:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==102) ) {
                alt55=1;
            }
            else if ( (LA55_0==103) ) {
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
                    // InternalReflex.g:4119:3: (enumLiteral_0= 'signed' )
                    {
                    // InternalReflex.g:4119:3: (enumLiteral_0= 'signed' )
                    // InternalReflex.g:4120:4: enumLiteral_0= 'signed'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4127:3: (enumLiteral_1= 'unsigned' )
                    {
                    // InternalReflex.g:4127:3: (enumLiteral_1= 'unsigned' )
                    // InternalReflex.g:4128:4: enumLiteral_1= 'unsigned'
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
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
        // InternalReflex.g:1238:5: ( 'else' )
        // InternalReflex.g:1238:6: 'else'
        {
        match(input,56,FOLLOW_2); if (state.failed) return ;

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


    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\25\uffff";
    static final String dfa_2s = "\1\14\3\uffff\3\4\2\17\3\4\3\uffff\1\60\3\4\1\60\1\uffff";
    static final String dfa_3s = "\1\147\3\uffff\3\4\2\21\3\4\3\uffff\1\66\3\4\1\66\1\uffff";
    static final String dfa_4s = "\1\uffff\1\7\1\1\1\2\10\uffff\1\4\1\5\1\6\5\uffff\1\3";
    static final String dfa_5s = "\25\uffff}>";
    static final String[] dfa_6s = {
            "\1\4\1\5\1\6\1\11\1\12\1\13\1\14\26\uffff\1\1\1\16\2\uffff\1\16\27\uffff\1\2\1\3\3\uffff\2\15\32\uffff\1\7\1\10",
            "",
            "",
            "",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\20\1\21\1\22",
            "\1\20\1\21\1\22",
            "\1\23",
            "\1\23",
            "\1\23",
            "",
            "",
            "",
            "\1\14\5\uffff\1\24",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\14\2\uffff\1\14\2\uffff\1\24",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 125:3: ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_globalVars_7_0= ruleGlobalVariable ) ) | ( (lv_registers_8_0= ruleRegister ) ) | ( (lv_processes_9_0= ruleProcess ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000026000007F000L,0x000000C000000CE0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000026000007F000L,0x000000C000000C60L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000410000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000282000007F000L,0x000000C000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000820000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0xE271030000000070L,0x000000000780300BL});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0010020000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xE261010000000072L,0x000000000780300BL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xE261030000000070L,0x000000000780300BL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xE261010000000070L,0x000000000780300BL});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0400020000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0xF261010000000070L,0x000000000780300BL});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0001000000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000000003F000L,0x000000C000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0084000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000000000007F000L,0x000000C000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0004020000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0xE2E1010000000070L,0x000000000780300BL});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000002L,0x0000003800000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000600000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000002L,0x0000000078000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000002L,0x0000000180000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0008000000000000L,0x00000000007FC000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000038000L});

}