#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class LogicDrapiDrMuRepository, LogicDrapiMuNowNext, LogicKotlinx_coroutines_coreConflatedBroadcastChannel<E>, LogicDrapiMuScheduleBroadcast, LogicKotlinThrowable, LogicKotlinx_coroutines_coreCancellationException, LogicDrapiDate, LogicDrapiProgramCard, LogicKotlinArray<T>, LogicKotlinException, LogicKotlinRuntimeException, LogicKotlinIllegalStateException, LogicDrapiPrimaryAsset, LogicDrapiInfo, LogicKotlinx_coroutines_coreAtomicDesc, LogicKotlinx_coroutines_coreAtomicOp<__contravariant T>, LogicKotlinx_coroutines_coreOpDescriptor;

@protocol LogicKotlinCoroutineContext, LogicKotlinx_coroutines_coreFlow, LogicKotlinCoroutineContextElement, LogicKotlinCoroutineContextKey, LogicKotlinx_coroutines_coreReceiveChannel, LogicKotlinx_coroutines_coreSelectClause2, LogicKotlinx_coroutines_coreChannelIterator, LogicKotlinx_coroutines_coreSelectClause1, LogicKotlinx_coroutines_coreSelectInstance, LogicKotlinSuspendFunction1, LogicKotlinIterator, LogicKotlinx_coroutines_coreDisposableHandle, LogicKotlinContinuation;

NS_ASSUME_NONNULL_BEGIN

@interface KotlinBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface KotlinBase (KotlinBaseCopying) <NSCopying>
@end;

__attribute__((objc_runtime_name("KotlinMutableSet")))
__attribute__((swift_name("KotlinMutableSet")))
@interface LogicMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((objc_runtime_name("KotlinMutableDictionary")))
__attribute__((swift_name("KotlinMutableDictionary")))
@interface LogicMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((objc_runtime_name("KotlinNumber")))
__attribute__((swift_name("KotlinNumber")))
@interface LogicNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((objc_runtime_name("KotlinByte")))
__attribute__((swift_name("KotlinByte")))
@interface LogicByte : LogicNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((objc_runtime_name("KotlinUByte")))
__attribute__((swift_name("KotlinUByte")))
@interface LogicUByte : LogicNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((objc_runtime_name("KotlinShort")))
__attribute__((swift_name("KotlinShort")))
@interface LogicShort : LogicNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((objc_runtime_name("KotlinUShort")))
__attribute__((swift_name("KotlinUShort")))
@interface LogicUShort : LogicNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((objc_runtime_name("KotlinInt")))
__attribute__((swift_name("KotlinInt")))
@interface LogicInt : LogicNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((objc_runtime_name("KotlinUInt")))
__attribute__((swift_name("KotlinUInt")))
@interface LogicUInt : LogicNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((objc_runtime_name("KotlinLong")))
__attribute__((swift_name("KotlinLong")))
@interface LogicLong : LogicNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((objc_runtime_name("KotlinULong")))
__attribute__((swift_name("KotlinULong")))
@interface LogicULong : LogicNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((objc_runtime_name("KotlinFloat")))
__attribute__((swift_name("KotlinFloat")))
@interface LogicFloat : LogicNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((objc_runtime_name("KotlinDouble")))
__attribute__((swift_name("KotlinDouble")))
@interface LogicDouble : LogicNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((objc_runtime_name("KotlinBoolean")))
__attribute__((swift_name("KotlinBoolean")))
@interface LogicBoolean : LogicNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol LogicKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<LogicKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TvChannels")))
@interface LogicTvChannels : KotlinBase <LogicKotlinx_coroutines_coreCoroutineScope>
- (instancetype)initWithApi:(LogicDrapiDrMuRepository *)api coroutineContext:(id<LogicKotlinCoroutineContext>)coroutineContext __attribute__((swift_name("init(api:coroutineContext:)"))) __attribute__((objc_designated_initializer));
- (void)subscribe __attribute__((swift_name("subscribe()")));
- (void)dispose __attribute__((swift_name("dispose()")));
@property (readonly) LogicKotlinx_coroutines_coreConflatedBroadcastChannel<NSArray<LogicDrapiMuNowNext *> *> *channels __attribute__((swift_name("channels")));
@property (readonly) LogicDrapiDrMuRepository *api __attribute__((swift_name("api")));
@property (readonly) id<LogicKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((swift_name("TvChannelsViewModel")))
@protocol LogicTvChannelsViewModel
@required
- (void)playTvChannelMuNowNext:(LogicDrapiMuNowNext *)muNowNext __attribute__((swift_name("playTvChannel(muNowNext:)")));
- (void)playProgramMuNowNext:(LogicDrapiMuNowNext *)muNowNext __attribute__((swift_name("playProgram(muNowNext:)")));
- (void)reload __attribute__((swift_name("reload()")));
- (void)onCleared __attribute__((swift_name("onCleared()")));
@property (readonly) id<LogicKotlinx_coroutines_coreFlow> channels __attribute__((swift_name("channels")));
@property (readonly) id<LogicKotlinx_coroutines_coreFlow> playbackUri __attribute__((swift_name("playbackUri")));
@property (readonly) id<LogicKotlinx_coroutines_coreFlow> error __attribute__((swift_name("error")));
@end;

__attribute__((swift_name("TvChannelsViewModelImpl")))
@interface LogicTvChannelsViewModelImpl : KotlinBase <LogicKotlinx_coroutines_coreCoroutineScope, LogicTvChannelsViewModel>
- (instancetype)initWithCoroutineContext:(id<LogicKotlinCoroutineContext>)coroutineContext __attribute__((swift_name("init(coroutineContext:)"))) __attribute__((objc_designated_initializer));
- (void)playTvChannelMuNowNext:(LogicDrapiMuNowNext *)muNowNext __attribute__((swift_name("playTvChannel(muNowNext:)")));
- (void)playProgramMuNowNext:(LogicDrapiMuNowNext *)muNowNext __attribute__((swift_name("playProgram(muNowNext:)")));
- (void)reload __attribute__((swift_name("reload()")));
- (void)onCleared __attribute__((swift_name("onCleared()")));
@property (readonly) id<LogicKotlinx_coroutines_coreFlow> channels __attribute__((swift_name("channels")));
@property (readonly) id<LogicKotlinx_coroutines_coreFlow> playbackUri __attribute__((swift_name("playbackUri")));
@property (readonly) id<LogicKotlinx_coroutines_coreFlow> error __attribute__((swift_name("error")));
@property (readonly) id<LogicKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UriKt")))
@interface LogicUriKt : KotlinBase
+ (NSString *)decryptUriInput:(NSString *)input __attribute__((swift_name("decryptUri(input:)")));
@end;

__attribute__((swift_name("KotlinCoroutineContext")))
@protocol LogicKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<LogicKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<LogicKotlinCoroutineContextElement> _Nullable)getKey:(id<LogicKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<LogicKotlinCoroutineContext>)minusKeyKey:(id<LogicKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<LogicKotlinCoroutineContext>)plusContext:(id<LogicKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end;

__attribute__((swift_name("DrapiDrMuRepository")))
@interface LogicDrapiDrMuRepository : KotlinBase
- (instancetype)initWithCacheDir:(NSString * _Nullable)cacheDir sizeBytes:(int64_t)sizeBytes __attribute__((swift_name("init(cacheDir:sizeBytes:)"))) __attribute__((objc_designated_initializer));
- (BOOL)equalsOther:(id _Nullable)other __attribute__((swift_name("equals(other:)")));
- (int32_t)hashCode __attribute__((swift_name("hashCode()")));
- (NSString *)toString __attribute__((swift_name("toString()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrapiMuNowNext")))
@interface LogicDrapiMuNowNext : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 ChannelSlug:(NSString * _Nullable)ChannelSlug Channel:(NSString * _Nullable)Channel Now:(LogicDrapiMuScheduleBroadcast * _Nullable)Now Next:(NSArray<LogicDrapiMuScheduleBroadcast *> * _Nullable)Next serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:ChannelSlug:Channel:Now:Next:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel Now:(LogicDrapiMuScheduleBroadcast * _Nullable)Now Next:(NSArray<LogicDrapiMuScheduleBroadcast *> *)Next __attribute__((swift_name("init(ChannelSlug:Channel:Now:Next:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (LogicDrapiMuScheduleBroadcast * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSArray<LogicDrapiMuScheduleBroadcast *> *)component4 __attribute__((swift_name("component4()")));
- (LogicDrapiMuNowNext *)doCopyChannelSlug:(NSString *)ChannelSlug Channel:(NSString *)Channel Now:(LogicDrapiMuScheduleBroadcast * _Nullable)Now Next:(NSArray<LogicDrapiMuScheduleBroadcast *> *)Next __attribute__((swift_name("doCopy(ChannelSlug:Channel:Now:Next:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *Channel __attribute__((swift_name("Channel")));
@property (readonly) NSString *ChannelSlug __attribute__((swift_name("ChannelSlug")));
@property (readonly) NSArray<LogicDrapiMuScheduleBroadcast *> *Next __attribute__((swift_name("Next")));
@property (readonly) LogicDrapiMuScheduleBroadcast * _Nullable Now __attribute__((swift_name("Now")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSendChannel")))
@protocol LogicKotlinx_coroutines_coreSendChannel
@required
- (BOOL)closeCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("close(cause:)")));
- (void)invokeOnCloseHandler:(void (^)(LogicKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnClose(handler:)")));
- (BOOL)offerElement:(id _Nullable)element __attribute__((swift_name("offer(element:)")));
@property (readonly) BOOL isClosedForSend __attribute__((swift_name("isClosedForSend")));
@property (readonly) BOOL isFull __attribute__((swift_name("isFull")));
@property (readonly) id<LogicKotlinx_coroutines_coreSelectClause2> onSend __attribute__((swift_name("onSend")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreBroadcastChannel")))
@protocol LogicKotlinx_coroutines_coreBroadcastChannel <LogicKotlinx_coroutines_coreSendChannel>
@required
- (BOOL)cancelCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (void)cancelCause_:(LogicKotlinx_coroutines_coreCancellationException * _Nullable)cause __attribute__((swift_name("cancel(cause_:)")));
- (id<LogicKotlinx_coroutines_coreReceiveChannel>)openSubscription __attribute__((swift_name("openSubscription()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_coroutines_coreConflatedBroadcastChannel")))
@interface LogicKotlinx_coroutines_coreConflatedBroadcastChannel<E> : KotlinBase <LogicKotlinx_coroutines_coreBroadcastChannel>
- (instancetype)initWithValue:(E _Nullable)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (BOOL)cancelCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (void)cancelCause_:(LogicKotlinx_coroutines_coreCancellationException * _Nullable)cause __attribute__((swift_name("cancel(cause_:)")));
- (BOOL)closeCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("close(cause:)")));
- (void)invokeOnCloseHandler:(void (^)(LogicKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnClose(handler:)")));
- (BOOL)offerElement:(E _Nullable)element __attribute__((swift_name("offer(element:)")));
- (id<LogicKotlinx_coroutines_coreReceiveChannel>)openSubscription __attribute__((swift_name("openSubscription()")));
@property (readonly) BOOL isClosedForSend __attribute__((swift_name("isClosedForSend")));
@property (readonly) BOOL isFull __attribute__((swift_name("isFull")));
@property (readonly) id<LogicKotlinx_coroutines_coreSelectClause2> onSend __attribute__((swift_name("onSend")));
@property (readonly) E _Nullable value __attribute__((swift_name("value")));
@property (readonly) E _Nullable valueOrNull __attribute__((swift_name("valueOrNull")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreFlow")))
@protocol LogicKotlinx_coroutines_coreFlow
@required
@end;

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol LogicKotlinCoroutineContextElement <LogicKotlinCoroutineContext>
@required
@property (readonly) id<LogicKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol LogicKotlinCoroutineContextKey
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrapiMuScheduleBroadcast")))
@interface LogicDrapiMuScheduleBroadcast : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Title:(NSString * _Nullable)Title Description:(NSString * _Nullable)Description Subtitle:(NSString * _Nullable)Subtitle StartTime:(LogicDrapiDate * _Nullable)StartTime EndTime:(LogicDrapiDate * _Nullable)EndTime ProgramCard:(LogicDrapiProgramCard * _Nullable)ProgramCard OnlineGenreText:(NSString * _Nullable)OnlineGenreText ProductionNumber:(NSString * _Nullable)ProductionNumber ProgramCardHasPrimaryAsset:(BOOL)ProgramCardHasPrimaryAsset SeriesHasProgramCardWithPrimaryAsset:(BOOL)SeriesHasProgramCardWithPrimaryAsset AnnouncedStartTime:(LogicDrapiDate * _Nullable)AnnouncedStartTime AnnouncedEndTime:(LogicDrapiDate * _Nullable)AnnouncedEndTime ProductionCountry:(NSString * _Nullable)ProductionCountry ProductionYear:(int32_t)ProductionYear VideoWidescreen:(BOOL)VideoWidescreen SubtitlesTTV:(BOOL)SubtitlesTTV VideoHD:(BOOL)VideoHD WhatsOnUri:(NSString * _Nullable)WhatsOnUri IsRerun:(BOOL)IsRerun serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Title:Description:Subtitle:StartTime:EndTime:ProgramCard:OnlineGenreText:ProductionNumber:ProgramCardHasPrimaryAsset:SeriesHasProgramCardWithPrimaryAsset:AnnouncedStartTime:AnnouncedEndTime:ProductionCountry:ProductionYear:VideoWidescreen:SubtitlesTTV:VideoHD:WhatsOnUri:IsRerun:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithTitle:(NSString *)Title Description:(NSString *)Description Subtitle:(NSString *)Subtitle StartTime:(LogicDrapiDate *)StartTime EndTime:(LogicDrapiDate *)EndTime ProgramCard:(LogicDrapiProgramCard *)ProgramCard OnlineGenreText:(NSString * _Nullable)OnlineGenreText ProductionNumber:(NSString *)ProductionNumber ProgramCardHasPrimaryAsset:(BOOL)ProgramCardHasPrimaryAsset SeriesHasProgramCardWithPrimaryAsset:(BOOL)SeriesHasProgramCardWithPrimaryAsset AnnouncedStartTime:(LogicDrapiDate *)AnnouncedStartTime AnnouncedEndTime:(LogicDrapiDate *)AnnouncedEndTime ProductionCountry:(NSString *)ProductionCountry ProductionYear:(int32_t)ProductionYear VideoWidescreen:(BOOL)VideoWidescreen SubtitlesTTV:(BOOL)SubtitlesTTV VideoHD:(BOOL)VideoHD WhatsOnUri:(NSString *)WhatsOnUri IsRerun:(BOOL)IsRerun __attribute__((swift_name("init(Title:Description:Subtitle:StartTime:EndTime:ProgramCard:OnlineGenreText:ProductionNumber:ProgramCardHasPrimaryAsset:SeriesHasProgramCardWithPrimaryAsset:AnnouncedStartTime:AnnouncedEndTime:ProductionCountry:ProductionYear:VideoWidescreen:SubtitlesTTV:VideoHD:WhatsOnUri:IsRerun:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (BOOL)component10 __attribute__((swift_name("component10()")));
- (LogicDrapiDate *)component11 __attribute__((swift_name("component11()")));
- (LogicDrapiDate *)component12 __attribute__((swift_name("component12()")));
- (NSString *)component13 __attribute__((swift_name("component13()")));
- (int32_t)component14 __attribute__((swift_name("component14()")));
- (BOOL)component15 __attribute__((swift_name("component15()")));
- (BOOL)component16 __attribute__((swift_name("component16()")));
- (BOOL)component17 __attribute__((swift_name("component17()")));
- (NSString *)component18 __attribute__((swift_name("component18()")));
- (BOOL)component19 __attribute__((swift_name("component19()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (LogicDrapiDate *)component4 __attribute__((swift_name("component4()")));
- (LogicDrapiDate *)component5 __attribute__((swift_name("component5()")));
- (LogicDrapiProgramCard *)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (BOOL)component9 __attribute__((swift_name("component9()")));
- (LogicDrapiMuScheduleBroadcast *)doCopyTitle:(NSString *)Title Description:(NSString *)Description Subtitle:(NSString *)Subtitle StartTime:(LogicDrapiDate *)StartTime EndTime:(LogicDrapiDate *)EndTime ProgramCard:(LogicDrapiProgramCard *)ProgramCard OnlineGenreText:(NSString * _Nullable)OnlineGenreText ProductionNumber:(NSString *)ProductionNumber ProgramCardHasPrimaryAsset:(BOOL)ProgramCardHasPrimaryAsset SeriesHasProgramCardWithPrimaryAsset:(BOOL)SeriesHasProgramCardWithPrimaryAsset AnnouncedStartTime:(LogicDrapiDate *)AnnouncedStartTime AnnouncedEndTime:(LogicDrapiDate *)AnnouncedEndTime ProductionCountry:(NSString *)ProductionCountry ProductionYear:(int32_t)ProductionYear VideoWidescreen:(BOOL)VideoWidescreen SubtitlesTTV:(BOOL)SubtitlesTTV VideoHD:(BOOL)VideoHD WhatsOnUri:(NSString *)WhatsOnUri IsRerun:(BOOL)IsRerun __attribute__((swift_name("doCopy(Title:Description:Subtitle:StartTime:EndTime:ProgramCard:OnlineGenreText:ProductionNumber:ProgramCardHasPrimaryAsset:SeriesHasProgramCardWithPrimaryAsset:AnnouncedStartTime:AnnouncedEndTime:ProductionCountry:ProductionYear:VideoWidescreen:SubtitlesTTV:VideoHD:WhatsOnUri:IsRerun:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSString * _Nullable)getPrimaryAssetUri __attribute__((swift_name("getPrimaryAssetUri()")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) LogicDrapiDate *AnnouncedEndTime __attribute__((swift_name("AnnouncedEndTime")));
@property (readonly) LogicDrapiDate *AnnouncedStartTime __attribute__((swift_name("AnnouncedStartTime")));
@property (readonly) NSString *Description __attribute__((swift_name("Description")));
@property (readonly) LogicDrapiDate *EndTime __attribute__((swift_name("EndTime")));
@property (readonly) BOOL IsRerun __attribute__((swift_name("IsRerun")));
@property (readonly) NSString * _Nullable OnlineGenreText __attribute__((swift_name("OnlineGenreText")));
@property (readonly) NSString *ProductionCountry __attribute__((swift_name("ProductionCountry")));
@property (readonly) NSString *ProductionNumber __attribute__((swift_name("ProductionNumber")));
@property (readonly) int32_t ProductionYear __attribute__((swift_name("ProductionYear")));
@property (readonly) LogicDrapiProgramCard *ProgramCard __attribute__((swift_name("ProgramCard")));
@property (readonly) BOOL ProgramCardHasPrimaryAsset __attribute__((swift_name("ProgramCardHasPrimaryAsset")));
@property (readonly) BOOL SeriesHasProgramCardWithPrimaryAsset __attribute__((swift_name("SeriesHasProgramCardWithPrimaryAsset")));
@property (readonly) LogicDrapiDate *StartTime __attribute__((swift_name("StartTime")));
@property (readonly) NSString *Subtitle __attribute__((swift_name("Subtitle")));
@property (readonly) BOOL SubtitlesTTV __attribute__((swift_name("SubtitlesTTV")));
@property (readonly) NSString *Title __attribute__((swift_name("Title")));
@property (readonly) BOOL VideoHD __attribute__((swift_name("VideoHD")));
@property (readonly) BOOL VideoWidescreen __attribute__((swift_name("VideoWidescreen")));
@property (readonly) NSString *WhatsOnUri __attribute__((swift_name("WhatsOnUri")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface LogicKotlinThrowable : KotlinBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (LogicKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) LogicKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
@end;

__attribute__((swift_name("KotlinException")))
@interface LogicKotlinException : LogicKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface LogicKotlinRuntimeException : LogicKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface LogicKotlinIllegalStateException : LogicKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCancellationException")))
@interface LogicKotlinx_coroutines_coreCancellationException : LogicKotlinIllegalStateException
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreReceiveChannel")))
@protocol LogicKotlinx_coroutines_coreReceiveChannel
@required
- (void)cancel __attribute__((swift_name("cancel()")));
- (BOOL)cancelCause:(LogicKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (void)cancelCause_:(LogicKotlinx_coroutines_coreCancellationException * _Nullable)cause __attribute__((swift_name("cancel(cause_:)")));
- (id<LogicKotlinx_coroutines_coreChannelIterator>)iterator __attribute__((swift_name("iterator()")));
- (id _Nullable)poll __attribute__((swift_name("poll()")));
@property (readonly) BOOL isClosedForReceive __attribute__((swift_name("isClosedForReceive")));
@property (readonly) BOOL isEmpty __attribute__((swift_name("isEmpty")));
@property (readonly) id<LogicKotlinx_coroutines_coreSelectClause1> onReceive __attribute__((swift_name("onReceive")));
@property (readonly) id<LogicKotlinx_coroutines_coreSelectClause1> onReceiveOrNull __attribute__((swift_name("onReceiveOrNull")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSelectClause2")))
@protocol LogicKotlinx_coroutines_coreSelectClause2
@required
- (void)registerSelectClause2Select:(id<LogicKotlinx_coroutines_coreSelectInstance>)select param:(id _Nullable)param block:(id<LogicKotlinSuspendFunction1>)block __attribute__((swift_name("registerSelectClause2(select:param:block:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrapiDate")))
@interface LogicDrapiDate : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property int64_t time __attribute__((swift_name("time")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrapiProgramCard")))
@interface LogicDrapiProgramCard : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 seen2:(int32_t)seen2 Type:(NSString * _Nullable)Type SeriesTitle:(NSString * _Nullable)SeriesTitle EpisodeTitle:(NSString * _Nullable)EpisodeTitle SeriesSlug:(NSString * _Nullable)SeriesSlug SeriesUrn:(NSString * _Nullable)SeriesUrn HostName:(NSString * _Nullable)HostName SeriesHostName:(NSString * _Nullable)SeriesHostName PrimaryChannel:(NSString * _Nullable)PrimaryChannel PrimaryChannelSlug:(NSString * _Nullable)PrimaryChannelSlug SeasonEpisodeNumberingValid:(BOOL)SeasonEpisodeNumberingValid SeasonTitle:(NSString * _Nullable)SeasonTitle SeasonSlug:(NSString * _Nullable)SeasonSlug SeasonUrn:(NSString * _Nullable)SeasonUrn SeasonNumber:(int32_t)SeasonNumber PrePremiere:(BOOL)PrePremiere ExpiresSoon:(BOOL)ExpiresSoon OnlineGenreText:(NSString * _Nullable)OnlineGenreText PrimaryAsset:(LogicDrapiPrimaryAsset * _Nullable)PrimaryAsset HasPublicPrimaryAsset:(BOOL)HasPublicPrimaryAsset AssetTargetTypes:(NSString * _Nullable)AssetTargetTypes PrimaryBroadcastStartTime:(LogicDrapiDate * _Nullable)PrimaryBroadcastStartTime SortDateTime:(LogicDrapiDate * _Nullable)SortDateTime OnDemandInfo:(LogicDrapiInfo * _Nullable)OnDemandInfo Slug:(NSString * _Nullable)Slug Urn:(NSString * _Nullable)Urn PrimaryImageUri:(NSString * _Nullable)PrimaryImageUri PresentationUri:(NSString * _Nullable)PresentationUri PresentationUriAutoplay:(NSString * _Nullable)PresentationUriAutoplay Title:(NSString * _Nullable)Title Subtitle:(NSString * _Nullable)Subtitle IsNewSeries:(BOOL)IsNewSeries OriginalTitle:(NSString * _Nullable)OriginalTitle RectificationStatus:(NSString * _Nullable)RectificationStatus RectificationAuto:(BOOL)RectificationAuto RectificationText:(NSString * _Nullable)RectificationText serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:seen2:Type:SeriesTitle:EpisodeTitle:SeriesSlug:SeriesUrn:HostName:SeriesHostName:PrimaryChannel:PrimaryChannelSlug:SeasonEpisodeNumberingValid:SeasonTitle:SeasonSlug:SeasonUrn:SeasonNumber:PrePremiere:ExpiresSoon:OnlineGenreText:PrimaryAsset:HasPublicPrimaryAsset:AssetTargetTypes:PrimaryBroadcastStartTime:SortDateTime:OnDemandInfo:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:Subtitle:IsNewSeries:OriginalTitle:RectificationStatus:RectificationAuto:RectificationText:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithType:(NSString *)Type SeriesTitle:(NSString *)SeriesTitle EpisodeTitle:(NSString *)EpisodeTitle SeriesSlug:(NSString *)SeriesSlug SeriesUrn:(NSString *)SeriesUrn HostName:(NSString *)HostName SeriesHostName:(NSString *)SeriesHostName PrimaryChannel:(NSString *)PrimaryChannel PrimaryChannelSlug:(NSString *)PrimaryChannelSlug SeasonEpisodeNumberingValid:(BOOL)SeasonEpisodeNumberingValid SeasonTitle:(NSString * _Nullable)SeasonTitle SeasonSlug:(NSString * _Nullable)SeasonSlug SeasonUrn:(NSString * _Nullable)SeasonUrn SeasonNumber:(int32_t)SeasonNumber PrePremiere:(BOOL)PrePremiere ExpiresSoon:(BOOL)ExpiresSoon OnlineGenreText:(NSString *)OnlineGenreText PrimaryAsset:(LogicDrapiPrimaryAsset * _Nullable)PrimaryAsset HasPublicPrimaryAsset:(BOOL)HasPublicPrimaryAsset AssetTargetTypes:(NSString *)AssetTargetTypes PrimaryBroadcastStartTime:(LogicDrapiDate * _Nullable)PrimaryBroadcastStartTime SortDateTime:(LogicDrapiDate *)SortDateTime OnDemandInfo:(LogicDrapiInfo * _Nullable)OnDemandInfo Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title Subtitle:(NSString *)Subtitle IsNewSeries:(BOOL)IsNewSeries OriginalTitle:(NSString *)OriginalTitle RectificationStatus:(NSString *)RectificationStatus RectificationAuto:(BOOL)RectificationAuto RectificationText:(NSString *)RectificationText __attribute__((swift_name("init(Type:SeriesTitle:EpisodeTitle:SeriesSlug:SeriesUrn:HostName:SeriesHostName:PrimaryChannel:PrimaryChannelSlug:SeasonEpisodeNumberingValid:SeasonTitle:SeasonSlug:SeasonUrn:SeasonNumber:PrePremiere:ExpiresSoon:OnlineGenreText:PrimaryAsset:HasPublicPrimaryAsset:AssetTargetTypes:PrimaryBroadcastStartTime:SortDateTime:OnDemandInfo:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:Subtitle:IsNewSeries:OriginalTitle:RectificationStatus:RectificationAuto:RectificationText:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (BOOL)component10 __attribute__((swift_name("component10()")));
- (NSString * _Nullable)component11 __attribute__((swift_name("component11()")));
- (NSString * _Nullable)component12 __attribute__((swift_name("component12()")));
- (NSString * _Nullable)component13 __attribute__((swift_name("component13()")));
- (int32_t)component14 __attribute__((swift_name("component14()")));
- (BOOL)component15 __attribute__((swift_name("component15()")));
- (BOOL)component16 __attribute__((swift_name("component16()")));
- (NSString *)component17 __attribute__((swift_name("component17()")));
- (LogicDrapiPrimaryAsset * _Nullable)component18 __attribute__((swift_name("component18()")));
- (BOOL)component19 __attribute__((swift_name("component19()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component20 __attribute__((swift_name("component20()")));
- (LogicDrapiDate * _Nullable)component21 __attribute__((swift_name("component21()")));
- (LogicDrapiDate *)component22 __attribute__((swift_name("component22()")));
- (LogicDrapiInfo * _Nullable)component23 __attribute__((swift_name("component23()")));
- (NSString *)component24 __attribute__((swift_name("component24()")));
- (NSString *)component25 __attribute__((swift_name("component25()")));
- (NSString *)component26 __attribute__((swift_name("component26()")));
- (NSString *)component27 __attribute__((swift_name("component27()")));
- (NSString *)component28 __attribute__((swift_name("component28()")));
- (NSString *)component29 __attribute__((swift_name("component29()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component30 __attribute__((swift_name("component30()")));
- (BOOL)component31 __attribute__((swift_name("component31()")));
- (NSString *)component32 __attribute__((swift_name("component32()")));
- (NSString *)component33 __attribute__((swift_name("component33()")));
- (BOOL)component34 __attribute__((swift_name("component34()")));
- (NSString *)component35 __attribute__((swift_name("component35()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString *)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (NSString *)component9 __attribute__((swift_name("component9()")));
- (LogicDrapiProgramCard *)doCopyType:(NSString *)Type SeriesTitle:(NSString *)SeriesTitle EpisodeTitle:(NSString *)EpisodeTitle SeriesSlug:(NSString *)SeriesSlug SeriesUrn:(NSString *)SeriesUrn HostName:(NSString *)HostName SeriesHostName:(NSString *)SeriesHostName PrimaryChannel:(NSString *)PrimaryChannel PrimaryChannelSlug:(NSString *)PrimaryChannelSlug SeasonEpisodeNumberingValid:(BOOL)SeasonEpisodeNumberingValid SeasonTitle:(NSString * _Nullable)SeasonTitle SeasonSlug:(NSString * _Nullable)SeasonSlug SeasonUrn:(NSString * _Nullable)SeasonUrn SeasonNumber:(int32_t)SeasonNumber PrePremiere:(BOOL)PrePremiere ExpiresSoon:(BOOL)ExpiresSoon OnlineGenreText:(NSString *)OnlineGenreText PrimaryAsset:(LogicDrapiPrimaryAsset * _Nullable)PrimaryAsset HasPublicPrimaryAsset:(BOOL)HasPublicPrimaryAsset AssetTargetTypes:(NSString *)AssetTargetTypes PrimaryBroadcastStartTime:(LogicDrapiDate * _Nullable)PrimaryBroadcastStartTime SortDateTime:(LogicDrapiDate *)SortDateTime OnDemandInfo:(LogicDrapiInfo * _Nullable)OnDemandInfo Slug:(NSString *)Slug Urn:(NSString *)Urn PrimaryImageUri:(NSString *)PrimaryImageUri PresentationUri:(NSString *)PresentationUri PresentationUriAutoplay:(NSString *)PresentationUriAutoplay Title:(NSString *)Title Subtitle:(NSString *)Subtitle IsNewSeries:(BOOL)IsNewSeries OriginalTitle:(NSString *)OriginalTitle RectificationStatus:(NSString *)RectificationStatus RectificationAuto:(BOOL)RectificationAuto RectificationText:(NSString *)RectificationText __attribute__((swift_name("doCopy(Type:SeriesTitle:EpisodeTitle:SeriesSlug:SeriesUrn:HostName:SeriesHostName:PrimaryChannel:PrimaryChannelSlug:SeasonEpisodeNumberingValid:SeasonTitle:SeasonSlug:SeasonUrn:SeasonNumber:PrePremiere:ExpiresSoon:OnlineGenreText:PrimaryAsset:HasPublicPrimaryAsset:AssetTargetTypes:PrimaryBroadcastStartTime:SortDateTime:OnDemandInfo:Slug:Urn:PrimaryImageUri:PresentationUri:PresentationUriAutoplay:Title:Subtitle:IsNewSeries:OriginalTitle:RectificationStatus:RectificationAuto:RectificationText:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *AssetTargetTypes __attribute__((swift_name("AssetTargetTypes")));
@property (readonly) NSString *EpisodeTitle __attribute__((swift_name("EpisodeTitle")));
@property (readonly) BOOL ExpiresSoon __attribute__((swift_name("ExpiresSoon")));
@property (readonly) BOOL HasPublicPrimaryAsset __attribute__((swift_name("HasPublicPrimaryAsset")));
@property (readonly) NSString *HostName __attribute__((swift_name("HostName")));
@property (readonly) BOOL IsNewSeries __attribute__((swift_name("IsNewSeries")));
@property (readonly) LogicDrapiInfo * _Nullable OnDemandInfo __attribute__((swift_name("OnDemandInfo")));
@property (readonly) NSString *OnlineGenreText __attribute__((swift_name("OnlineGenreText")));
@property (readonly) NSString *OriginalTitle __attribute__((swift_name("OriginalTitle")));
@property (readonly) BOOL PrePremiere __attribute__((swift_name("PrePremiere")));
@property (readonly) NSString *PresentationUri __attribute__((swift_name("PresentationUri")));
@property (readonly) NSString *PresentationUriAutoplay __attribute__((swift_name("PresentationUriAutoplay")));
@property (readonly) LogicDrapiPrimaryAsset * _Nullable PrimaryAsset __attribute__((swift_name("PrimaryAsset")));
@property (readonly) LogicDrapiDate * _Nullable PrimaryBroadcastStartTime __attribute__((swift_name("PrimaryBroadcastStartTime")));
@property (readonly) NSString *PrimaryChannel __attribute__((swift_name("PrimaryChannel")));
@property (readonly) NSString *PrimaryChannelSlug __attribute__((swift_name("PrimaryChannelSlug")));
@property (readonly) NSString *PrimaryImageUri __attribute__((swift_name("PrimaryImageUri")));
@property (readonly) BOOL RectificationAuto __attribute__((swift_name("RectificationAuto")));
@property (readonly) NSString *RectificationStatus __attribute__((swift_name("RectificationStatus")));
@property (readonly) NSString *RectificationText __attribute__((swift_name("RectificationText")));
@property (readonly) BOOL SeasonEpisodeNumberingValid __attribute__((swift_name("SeasonEpisodeNumberingValid")));
@property (readonly) int32_t SeasonNumber __attribute__((swift_name("SeasonNumber")));
@property (readonly) NSString * _Nullable SeasonSlug __attribute__((swift_name("SeasonSlug")));
@property (readonly) NSString * _Nullable SeasonTitle __attribute__((swift_name("SeasonTitle")));
@property (readonly) NSString * _Nullable SeasonUrn __attribute__((swift_name("SeasonUrn")));
@property (readonly) NSString *SeriesHostName __attribute__((swift_name("SeriesHostName")));
@property (readonly) NSString *SeriesSlug __attribute__((swift_name("SeriesSlug")));
@property (readonly) NSString *SeriesTitle __attribute__((swift_name("SeriesTitle")));
@property (readonly) NSString *SeriesUrn __attribute__((swift_name("SeriesUrn")));
@property (readonly) NSString *Slug __attribute__((swift_name("Slug")));
@property (readonly) LogicDrapiDate *SortDateTime __attribute__((swift_name("SortDateTime")));
@property (readonly) NSString *Subtitle __attribute__((swift_name("Subtitle")));
@property (readonly) NSString *Title __attribute__((swift_name("Title")));
@property (readonly) NSString *Type __attribute__((swift_name("Type")));
@property (readonly) NSString *Urn __attribute__((swift_name("Urn")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface LogicKotlinArray<T> : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(LogicInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<LogicKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreChannelIterator")))
@protocol LogicKotlinx_coroutines_coreChannelIterator
@required
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSelectClause1")))
@protocol LogicKotlinx_coroutines_coreSelectClause1
@required
- (void)registerSelectClause1Select:(id<LogicKotlinx_coroutines_coreSelectInstance>)select block:(id<LogicKotlinSuspendFunction1>)block __attribute__((swift_name("registerSelectClause1(select:block:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSelectInstance")))
@protocol LogicKotlinx_coroutines_coreSelectInstance
@required
- (void)disposeOnSelectHandle:(id<LogicKotlinx_coroutines_coreDisposableHandle>)handle __attribute__((swift_name("disposeOnSelect(handle:)")));
- (id _Nullable)performAtomicIfNotSelectedDesc:(LogicKotlinx_coroutines_coreAtomicDesc *)desc __attribute__((swift_name("performAtomicIfNotSelected(desc:)")));
- (id _Nullable)performAtomicTrySelectDesc:(LogicKotlinx_coroutines_coreAtomicDesc *)desc __attribute__((swift_name("performAtomicTrySelect(desc:)")));
- (void)resumeSelectCancellableWithExceptionException:(LogicKotlinThrowable *)exception __attribute__((swift_name("resumeSelectCancellableWithException(exception:)")));
- (BOOL)trySelectIdempotent:(id _Nullable)idempotent __attribute__((swift_name("trySelect(idempotent:)")));
@property (readonly) id<LogicKotlinContinuation> completion __attribute__((swift_name("completion")));
@property (readonly) BOOL isSelected __attribute__((swift_name("isSelected")));
@end;

__attribute__((swift_name("KotlinSuspendFunction")))
@protocol LogicKotlinSuspendFunction
@required
@end;

__attribute__((swift_name("KotlinSuspendFunction1")))
@protocol LogicKotlinSuspendFunction1 <LogicKotlinSuspendFunction>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrapiPrimaryAsset")))
@interface LogicDrapiPrimaryAsset : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 Kind:(NSString * _Nullable)Kind Uri:(NSString * _Nullable)Uri DurationInMilliseconds:(int64_t)DurationInMilliseconds Downloadable:(BOOL)Downloadable RestrictedToDenmark:(BOOL)RestrictedToDenmark StartPublish:(LogicDrapiDate * _Nullable)StartPublish EndPublish:(LogicDrapiDate * _Nullable)EndPublish Target:(NSString * _Nullable)Target Encrypted:(BOOL)Encrypted IsLiveStream:(BOOL)IsLiveStream serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:Kind:Uri:DurationInMilliseconds:Downloadable:RestrictedToDenmark:StartPublish:EndPublish:Target:Encrypted:IsLiveStream:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithKind:(NSString *)Kind Uri:(NSString *)Uri DurationInMilliseconds:(int64_t)DurationInMilliseconds Downloadable:(BOOL)Downloadable RestrictedToDenmark:(BOOL)RestrictedToDenmark StartPublish:(LogicDrapiDate *)StartPublish EndPublish:(LogicDrapiDate *)EndPublish Target:(NSString *)Target Encrypted:(BOOL)Encrypted IsLiveStream:(BOOL)IsLiveStream __attribute__((swift_name("init(Kind:Uri:DurationInMilliseconds:Downloadable:RestrictedToDenmark:StartPublish:EndPublish:Target:Encrypted:IsLiveStream:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (BOOL)component10 __attribute__((swift_name("component10()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (int64_t)component3 __attribute__((swift_name("component3()")));
- (BOOL)component4 __attribute__((swift_name("component4()")));
- (BOOL)component5 __attribute__((swift_name("component5()")));
- (LogicDrapiDate *)component6 __attribute__((swift_name("component6()")));
- (LogicDrapiDate *)component7 __attribute__((swift_name("component7()")));
- (NSString *)component8 __attribute__((swift_name("component8()")));
- (BOOL)component9 __attribute__((swift_name("component9()")));
- (LogicDrapiPrimaryAsset *)doCopyKind:(NSString *)Kind Uri:(NSString *)Uri DurationInMilliseconds:(int64_t)DurationInMilliseconds Downloadable:(BOOL)Downloadable RestrictedToDenmark:(BOOL)RestrictedToDenmark StartPublish:(LogicDrapiDate *)StartPublish EndPublish:(LogicDrapiDate *)EndPublish Target:(NSString *)Target Encrypted:(BOOL)Encrypted IsLiveStream:(BOOL)IsLiveStream __attribute__((swift_name("doCopy(Kind:Uri:DurationInMilliseconds:Downloadable:RestrictedToDenmark:StartPublish:EndPublish:Target:Encrypted:IsLiveStream:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL Downloadable __attribute__((swift_name("Downloadable")));
@property (readonly) int64_t DurationInMilliseconds __attribute__((swift_name("DurationInMilliseconds")));
@property (readonly) BOOL Encrypted __attribute__((swift_name("Encrypted")));
@property (readonly) LogicDrapiDate *EndPublish __attribute__((swift_name("EndPublish")));
@property (readonly) BOOL IsLiveStream __attribute__((swift_name("IsLiveStream")));
@property (readonly) NSString *Kind __attribute__((swift_name("Kind")));
@property (readonly) BOOL RestrictedToDenmark __attribute__((swift_name("RestrictedToDenmark")));
@property (readonly) LogicDrapiDate *StartPublish __attribute__((swift_name("StartPublish")));
@property (readonly) NSString *Target __attribute__((swift_name("Target")));
@property (readonly) NSString *Uri __attribute__((swift_name("Uri")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrapiInfo")))
@interface LogicDrapiInfo : KotlinBase
- (instancetype)initWithSeen1:(int32_t)seen1 StartPublish:(LogicDrapiDate * _Nullable)StartPublish EndPublish:(LogicDrapiDate * _Nullable)EndPublish serializationConstructorMarker:(id _Nullable)serializationConstructorMarker __attribute__((swift_name("init(seen1:StartPublish:EndPublish:serializationConstructorMarker:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithStartPublish:(LogicDrapiDate *)StartPublish EndPublish:(LogicDrapiDate *)EndPublish __attribute__((swift_name("init(StartPublish:EndPublish:)"))) __attribute__((objc_designated_initializer));
- (LogicDrapiDate *)component1 __attribute__((swift_name("component1()")));
- (LogicDrapiDate *)component2 __attribute__((swift_name("component2()")));
- (LogicDrapiInfo *)doCopyStartPublish:(LogicDrapiDate *)StartPublish EndPublish:(LogicDrapiDate *)EndPublish __attribute__((swift_name("doCopy(StartPublish:EndPublish:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) LogicDrapiDate *EndPublish __attribute__((swift_name("EndPublish")));
@property (readonly) LogicDrapiDate *StartPublish __attribute__((swift_name("StartPublish")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol LogicKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreDisposableHandle")))
@protocol LogicKotlinx_coroutines_coreDisposableHandle
@required
- (void)dispose __attribute__((swift_name("dispose()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreAtomicDesc")))
@interface LogicKotlinx_coroutines_coreAtomicDesc : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeOp:(LogicKotlinx_coroutines_coreAtomicOp<id> *)op failure:(id _Nullable)failure __attribute__((swift_name("complete(op:failure:)")));
- (id _Nullable)prepareOp:(LogicKotlinx_coroutines_coreAtomicOp<id> *)op __attribute__((swift_name("prepare(op:)")));
@end;

__attribute__((swift_name("KotlinContinuation")))
@protocol LogicKotlinContinuation
@required
- (void)resumeWithResult:(id _Nullable)result __attribute__((swift_name("resumeWith(result:)")));
@property (readonly) id<LogicKotlinCoroutineContext> context __attribute__((swift_name("context")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreOpDescriptor")))
@interface LogicKotlinx_coroutines_coreOpDescriptor : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreAtomicOp")))
@interface LogicKotlinx_coroutines_coreAtomicOp<__contravariant T> : LogicKotlinx_coroutines_coreOpDescriptor
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeAffected:(T _Nullable)affected failure:(id _Nullable)failure __attribute__((swift_name("complete(affected:failure:)")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
- (id _Nullable)prepareAffected:(T _Nullable)affected __attribute__((swift_name("prepare(affected:)")));
- (BOOL)tryDecideDecision:(id _Nullable)decision __attribute__((swift_name("tryDecide(decision:)")));
@property (readonly) BOOL isDecided __attribute__((swift_name("isDecided")));
@end;

NS_ASSUME_NONNULL_END
